package hr.krunoslav.magazin.sfshop.unit.dao;

import static org.junit.Assert.*;

import org.junit.Test;

import hr.krunoslav.magazin.sfshop.jpa.dao.ArtikelDao;
import hr.krunoslav.magazin.sfshop.jpa.dao.impl.ArtikelDaoImpl;
import hr.krunoslav.magazin.sfshop.jpa.entities.Artikel;
import hr.krunoslav.magazin.sfshop.unit.dao.core.TestJpaAbstract;

public class ArtikelDaoTest extends TestJpaAbstract {

	private ArtikelDao artikelDao = new ArtikelDaoImpl();
	
	@Override
	public void setUp() throws Exception {
		super.setUp();
		artikelDao.setEntitymanager(em);
	}
	
	@Test
	public void testArtikelSelectByNummer2(){
		//prepare
		String nummer2 = "TestingNum2";
		Artikel persistedArtikel = new Artikel();
		persistedArtikel.setNummer2(nummer2);
		
		// action
		builder.persistInTransaction(persistedArtikel);
		
		// test result with empty PersistenceContext
		artikelDao.setEntitymanager(em);
		Artikel expectedPersisted = artikelDao.findArtikelByNummer2(nummer2);
		
		assertNotNull(expectedPersisted);
		assertEquals(persistedArtikel.getId().longValue(), expectedPersisted.getId().longValue());
	}
}
