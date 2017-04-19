package hr.krunoslav.magazin.sfshop.unit.dao;

import static org.junit.Assert.*;

import java.math.BigInteger;

import org.junit.Test;

import hr.krunoslav.magazin.sfshop.jpa.dao.ObjekteDao;
import hr.krunoslav.magazin.sfshop.jpa.dao.WarenkorbdetailsDao;
import hr.krunoslav.magazin.sfshop.jpa.dao.WarenkorbkoepfeDao;
import hr.krunoslav.magazin.sfshop.jpa.dao.impl.ObjekteDaoImpl;
import hr.krunoslav.magazin.sfshop.jpa.dao.impl.WarenkorbdetailsDaoImpl;
import hr.krunoslav.magazin.sfshop.jpa.dao.impl.WarenkorbkoepfeDaoImpl;
import hr.krunoslav.magazin.sfshop.jpa.entities.Objekte;
import hr.krunoslav.magazin.sfshop.jpa.entities.Warenkorbdetail;
import hr.krunoslav.magazin.sfshop.jpa.entities.Warenkorbkoepfe;
import hr.krunoslav.magazin.sfshop.unit.dao.core.TestJpaAbstract;

public class WarenkorbdetailDaoTest extends TestJpaAbstract {

	private WarenkorbdetailsDao wDetailDao = new WarenkorbdetailsDaoImpl();

	@Override
	public void setUp() throws Exception {
		super.setUp();
		wDetailDao.setEntitymanager(em);
	}

	@Test
	public void testWarenkorbdetailPersist() {
		// prepare
		ObjekteDao oDao = new ObjekteDaoImpl();
		oDao.setEntitymanager(em);
		Objekte objekte = oDao.findById(new BigInteger("1"));

		WarenkorbkoepfeDao wDao = new WarenkorbkoepfeDaoImpl();
		wDao.setEntitymanager(em);
		Warenkorbkoepfe warenkorbkoepfe = wDao.createWarenkorbkoepfe(objekte);
		builder.persistInTransaction(warenkorbkoepfe);

		// execute method in test
		Warenkorbdetail warenkorbdetail = wDetailDao.createWarenkorbdetail(warenkorbkoepfe);
		builder.persistInTransaction(warenkorbdetail);

		// test result with empty PersistenceContext
		wDetailDao.setEntitymanager(createEntityManager());
		Warenkorbdetail expectedResult = wDetailDao.findById(warenkorbdetail.getId());

		assertNotNull(expectedResult);
		assertEquals(warenkorbdetail.getId().longValue(), expectedResult.getId().longValue());
	}
}
