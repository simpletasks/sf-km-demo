package hr.krunoslav.magazin.sfshop.jpa.dao;

import java.math.BigInteger;
import java.util.List;

import hr.krunoslav.magazin.sfshop.jpa.entities.Warenkorbdetail;
import hr.krunoslav.magazin.sfshop.jpa.entities.Warenkorbkoepfe;

public interface WarenkorbdetailsDao extends Dao {

	Warenkorbdetail createWarenkorbdetail(Warenkorbkoepfe warenkorbkoepfe);
	
	public List<Warenkorbdetail> findByWarenkorbkoepfeId(BigInteger id);
}
