package hr.krunoslav.magazin.sfshop.unit.dao;

import java.math.BigInteger;

import static org.junit.Assert.*;
import org.junit.Test;

import hr.krunoslav.magazin.sfshop.jpa.dao.ObjekteDao;
import hr.krunoslav.magazin.sfshop.jpa.dao.WarenkorbkoepfeDao;
import hr.krunoslav.magazin.sfshop.jpa.dao.impl.ObjekteDaoImpl;
import hr.krunoslav.magazin.sfshop.jpa.dao.impl.WarenkorbkoepfeDaoImpl;
import hr.krunoslav.magazin.sfshop.jpa.entities.Objekte;
import hr.krunoslav.magazin.sfshop.jpa.entities.Warenkorbkoepfe;
import hr.krunoslav.magazin.sfshop.unit.dao.core.TestJpaAbstract;

public class WarenkorbkoepfeDaoTest extends TestJpaAbstract {

	private WarenkorbkoepfeDao wDao = new WarenkorbkoepfeDaoImpl();
	
	@Override
	public void setUp() throws Exception {
		super.setUp();
		wDao.setEntitymanager(em);
	}
	
	@Test
	public void testWarenkorbkoepfePersist(){
		//prepare
		ObjekteDao oDao = new ObjekteDaoImpl();
		oDao.setEntitymanager(em);
		Objekte objekte = oDao.findById(new BigInteger("1"));
		
		//execute method in test
		Warenkorbkoepfe warenkorbkoepfe = wDao.createWarenkorbkoepfe(objekte);
		builder.persistInTransaction(warenkorbkoepfe);
		
		// test result with empty PersistenceContext
		wDao.setEntitymanager(createEntityManager());
		Warenkorbkoepfe expectedResult = wDao.findById(warenkorbkoepfe.getId());
		
		assertNotNull(expectedResult);
		assertEquals(warenkorbkoepfe.getId().longValue(), expectedResult.getId().longValue());
		
	}
}
