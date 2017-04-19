package hr.krunoslav.magazin.sfshop.services.shopping_cart;

import java.math.BigInteger;

import javax.persistence.EntityManager;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import hr.krunoslav.magazin.sfshop.jaxb.elements.Item;
import hr.krunoslav.magazin.sfshop.jaxb.elements.Items;
import hr.krunoslav.magazin.sfshop.jpa.dao.ArtikelDao;
import hr.krunoslav.magazin.sfshop.jpa.dao.Dao;
import hr.krunoslav.magazin.sfshop.jpa.dao.ObjekteDao;
import hr.krunoslav.magazin.sfshop.jpa.dao.WarenkorbdetailsDao;
import hr.krunoslav.magazin.sfshop.jpa.dao.WarenkorbkoepfeDao;
import hr.krunoslav.magazin.sfshop.jpa.dao.impl.EntityManagerFactory;

import hr.krunoslav.magazin.sfshop.jpa.entities.Artikel;
import hr.krunoslav.magazin.sfshop.jpa.entities.Objekte;
import hr.krunoslav.magazin.sfshop.jpa.entities.Warenkorbdetail;
import hr.krunoslav.magazin.sfshop.jpa.entities.Warenkorbkoepfe;
import hr.krunoslav.magazin.sfshop.main.ShoppingCartItemsImporter;

public class ShoppingCartService {

	private static final Logger LOG = LogManager.getLogger(ShoppingCartService.class);

	private EntityManagerFactory emf = null;
	private ArtikelDao artikelDao = null;
	private ObjekteDao objekteDao = null;
	private WarenkorbkoepfeDao warenkorbkoepfeDao = null;
	private WarenkorbdetailsDao warenkorbkoepfeItemDao = null;

	public ShoppingCartService(EntityManagerFactory emf, ArtikelDao artikelDao, ObjekteDao objekteDao,
			WarenkorbkoepfeDao warenkorbkoepfeDao, WarenkorbdetailsDao warenkorbkoepfeItemDao) {
		super();
		this.emf = emf;
		this.artikelDao = artikelDao;
		this.objekteDao = objekteDao;
		this.warenkorbkoepfeDao = warenkorbkoepfeDao;
		this.warenkorbkoepfeItemDao = warenkorbkoepfeItemDao;
	}

	/**
	 * Method accepts list if {@link Item}, loads default {@link Objekte},
	 * create {@link Warenkorbkoepfe} for that <i>objekte</i>, matches every
	 * {@link Item} with {@link Artikel} from database, creates
	 * {@link Warenkorbdetail} for every <i>item</i> and persist new entities to
	 * database.
	 * 
	 * @param items
	 *            contains list of {@link Item}
	 * @return returns true for success or false in case of exception
	 */
	public boolean createShoppingCart(Items items) {

		EntityManager entityManager = emf.getEntitymanager();
		this.setEntityManager(entityManager);

		Objekte object = getObjekteFromDb(ShoppingCartItemsImporter.DEFAULT_OBJEKTE_ID);
		if (object == null) {
			LOG.info("Objekte instance is null. Aborting.");
			return false;
		}

		Warenkorbkoepfe warenkorbkoepfe = this.createWarenkorbkoepfe(object);

		if (!this.createWarenknobedetails(items, warenkorbkoepfe)){
			return false;
		}

		this.syncronizeWithDatabase(entityManager, objekteDao);

		LOG.info("Warenkorbkoepfe with id={} created.", warenkorbkoepfe.getId());
		return true;

	}

	private boolean createWarenknobedetails(Items items, Warenkorbkoepfe warenkorbkoepfe) {
		for (Item tm : items.getItem()) {
			Artikel artikel = getArtikelForItem(tm);
			if (artikel == null) {
				LOG.info("Item with uid={} can not be mapped to artikle", tm.getUid());
				return false;
			}
			this.createWarenkorbdetail(warenkorbkoepfe, tm, artikel);
		}
		return true;
	}

	private void setEntityManager(EntityManager entityManager) {
		artikelDao.setEntitymanager(entityManager);
		objekteDao.setEntitymanager(entityManager);
		warenkorbkoepfeDao.setEntitymanager(entityManager);
		warenkorbkoepfeItemDao.setEntitymanager(entityManager);
	}

	private void syncronizeWithDatabase(EntityManager entityManager, Dao daoImpl) {
		daoImpl.flushInTransaction(entityManager);
	}

	private Warenkorbkoepfe createWarenkorbkoepfe(Objekte object) {
		Warenkorbkoepfe warenkorbkoepfe = warenkorbkoepfeDao.createWarenkorbkoepfe(object);
		warenkorbkoepfeDao.persist(warenkorbkoepfe);
		return warenkorbkoepfe;
	}

	private void createWarenkorbdetail(Warenkorbkoepfe warenkorbkoepfe, Item tm, Artikel artikel) {
		Warenkorbdetail warenkorbdetail = warenkorbkoepfeItemDao.createWarenkorbdetail(warenkorbkoepfe);
		warenkorbdetail.setArtikel(artikel);
		warenkorbdetail.setMenge(tm.getValue2().getValue());
		warenkorbkoepfeItemDao.persist(warenkorbdetail);
	}

	private Artikel getArtikelForItem(Item tm) {
		return artikelDao.findArtikelByNummer2(tm.getValue0());
	}

	private Objekte getObjekteFromDb(BigInteger id) {
		return objekteDao.findById(id);
	}

}
