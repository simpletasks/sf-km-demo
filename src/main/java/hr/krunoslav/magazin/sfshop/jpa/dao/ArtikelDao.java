package hr.krunoslav.magazin.sfshop.jpa.dao;

import java.util.List;

import hr.krunoslav.magazin.sfshop.jpa.entities.Artikel;

public interface ArtikelDao extends Dao {

	/**
	 * Fetch {@link Artikel}  for nummer2 value. Per nummer2 may be zero or multiple {@link Artikel} entities.
	 * 
	 * @param numbers list of nummer2 values
	 * @return list of {@link Artikel}
	 */
	List<Artikel> findArtikelsByNummer2(List<String> numbers);
	
	Artikel findArtikelByNummer2(String number);
}
