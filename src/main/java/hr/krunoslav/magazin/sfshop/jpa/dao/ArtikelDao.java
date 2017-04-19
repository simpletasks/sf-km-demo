package hr.krunoslav.magazin.sfshop.jpa.dao;

import java.util.List;

import hr.krunoslav.magazin.sfshop.jpa.entities.Artikel;

public interface ArtikelDao extends Dao {

	/**
	 * Fetch list of {@link Artikel}  for nummer2 value. Per nummer2 may be zero or multiple {@link Artikel} entities.
	 * 
	 * @param numbers list of nummer2 values
	 * @return list of {@link Artikel}
	 */
	List<Artikel> findArtikelsByNummer2(List<String> numbers);
	
	/**
	 * If in database exists more than one row for nummer2 value first from list will be returned.
	 * 
	 * @param number
	 * @return instance or null
	 */
	Artikel findArtikelByNummer2(String number);
}
