package hr.krunoslav.magazin.sfshop.it.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.File;
import java.math.BigInteger;
import java.util.List;

import javax.persistence.EntityManager;
import javax.xml.transform.Source;

import org.junit.After;
import org.junit.Test;

import hr.krunoslav.magazin.sfshop.jaxb.elements.Inventory;
import hr.krunoslav.magazin.sfshop.jpa.dao.WarenkorbdetailsDao;
import hr.krunoslav.magazin.sfshop.jpa.dao.impl.ArtikelDaoImpl;
import hr.krunoslav.magazin.sfshop.jpa.dao.impl.EntityManagerFactory;
import hr.krunoslav.magazin.sfshop.jpa.dao.impl.ObjekteDaoImpl;
import hr.krunoslav.magazin.sfshop.jpa.dao.impl.WarenkorbdetailsDaoImpl;
import hr.krunoslav.magazin.sfshop.jpa.dao.impl.WarenkorbkoepfeDaoImpl;
import hr.krunoslav.magazin.sfshop.jpa.entities.Warenkorbdetail;
import hr.krunoslav.magazin.sfshop.jpa.entities.Warenkorbkoepfe;
import hr.krunoslav.magazin.sfshop.services.jaxb.SchemaSourceLocator;
import hr.krunoslav.magazin.sfshop.services.shopping_cart.ShoppingCartService;
import hr.krunoslav.magazin.sfshop.test.ConstantsInTest;
import hr.krunoslav.magazin.sfshop.test.util.FileUtil;
import hr.krunoslav.magazin.sfshop.test.util.XmlToJavaUtil;
import hr.krunoslav.magazin.sfshop.unit.dao.core.EntityBuilder;

public class XmlItemsToPersistedWarekorbdetailsIT implements ConstantsInTest {

	private FileUtil fileUtil = new FileUtil(URI_PATH_DELIMITER, PATH_TO_XML_FILE_DIR, PATH_TO_XSD_FILE_DIR);
	/**
	 * cache persisted entities for test and cleaning database after test is
	 * finished
	 */
	EntityBuilder entityCache = new EntityBuilder(null);

	@After
	public void tearDown() {
		entityCache.deleteCreatedEntities();
		if (entityCache.getEntityManager().isOpen()) {
			entityCache.getEntityManager().close();
		}
	}

	@Test
	public void testHappyConvertToJava() {
		String xmlFileName = FILENAME_DATA_NO_IGNORED_ITEM_SUBTAGS_XML;
		String xsdFileName = FILENAME_DATA_FULL_XSD;
		// prepare
		File xmlFile = fileUtil.checkIfXmlDataFileExist(xmlFileName);
		SchemaSourceLocator xsdLocator = new SchemaSourceLocator();
		Source schemaSource = xsdLocator.loadSchemaSource();

		assertNotNull("Xsd file is NULL!", schemaSource);
		assertNotNull("Xml file is NULL!", xmlFile);

		Inventory inventory = XmlToJavaUtil.convertToJava(xmlFile, schemaSource);

		assertNotNull("Invertory can not be NULL !", inventory);
		assertNotNull("Items can not be NULL! ", inventory.getItems());

		// service under test
		ShoppingCartService service = new ShoppingCartService(new EntityManagerFactory(), new ArtikelDaoImpl(),
				new ObjekteDaoImpl(), new WarenkorbkoepfeDaoImpl(), new WarenkorbdetailsDaoImpl());
		if (!service.createShoppingCart(inventory.getItems())) {
			new AssertionError("Conversion of xml item to jpa entities failed!");
		}

		// test phase
		BigInteger persistedId = service.getLastPersistedWarenkorbkoepfeId();
		if (persistedId == null) {
			new AssertionError("Persisted warekorkkoepfe id is NULL !");
		}

		EntityManager em = getNewEntitymanager();
		Warenkorbkoepfe wp = findPersistedWarekorbkopfe(persistedId, em);

		assertNotNull("Warenkorbkoepfe not persisted!", wp);

		List<Warenkorbdetail> wdList = findPersistedWarekorbdetails(persistedId, em);

		entityCache.getCreated().add(wp);
		for (Warenkorbdetail wd : wdList) {
			entityCache.getCreated().add(wd);
		}

		int itemTagCount = XmlToJavaUtil.getTagCount(XML_TAG_ITEM, xmlFile);
		assertEquals("Count of persisted Warenkorbdetails not equal items count!", itemTagCount, wdList.size());

	}

	private List<Warenkorbdetail> findPersistedWarekorbdetails(BigInteger persistedId, EntityManager em) {
		WarenkorbdetailsDao dDao = new WarenkorbdetailsDaoImpl();
		dDao.setEntitymanager(em);
		List<Warenkorbdetail> wdList = dDao.findByWarenkorbkoepfeId(persistedId);
		return wdList;
	}

	private Warenkorbkoepfe findPersistedWarekorbkopfe(BigInteger persistedId, EntityManager em) {
		WarenkorbkoepfeDaoImpl wDao = new WarenkorbkoepfeDaoImpl();
		wDao.setEntitymanager(em);
		Warenkorbkoepfe wp = wDao.findById(persistedId);
		return wp;
	}

	private EntityManager getNewEntitymanager() {
		EntityManagerFactory emf = new EntityManagerFactory();
		EntityManager em = emf.getEntitymanager();
		// make sure EntityManager is new one
		em.close();
		em = emf.getEntitymanager();
		entityCache.setEntityManager(em);
		return em;
	}
}
