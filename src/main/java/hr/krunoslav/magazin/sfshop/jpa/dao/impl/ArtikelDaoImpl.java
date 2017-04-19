package hr.krunoslav.magazin.sfshop.jpa.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import hr.krunoslav.magazin.sfshop.jpa.dao.ArtikelDao;
import hr.krunoslav.magazin.sfshop.jpa.dao.JpaDaoAbstractImpl;
import hr.krunoslav.magazin.sfshop.jpa.entities.Artikel;

public class ArtikelDaoImpl extends JpaDaoAbstractImpl<Artikel> implements ArtikelDao {

	private static final Logger LOG = LogManager.getLogger(ArtikelDaoImpl.class);

	@Override
	public List<Artikel> findArtikelsByNummer2(List<String> numbers) {
		List<Artikel> results = entitymanager.createNamedQuery("Artikel.findAllByNummer2List", Artikel.class)
				.setParameter("numbers", numbers).getResultList();
		return results;
	}

	@Override
	public Artikel findArtikelByNummer2(String number) {
		Artikel artikel = null;
		try {
			List<Artikel> results = entitymanager.createNamedQuery("Artikel.findByNummer2", Artikel.class)
					.setParameter("number", number).getResultList();
			artikel = getFirstResult(results);
		} catch (Exception e) {
			LOG.error("Exception loading instance of Artikle", e);
			return null;
		}
		return artikel;
	}

}
