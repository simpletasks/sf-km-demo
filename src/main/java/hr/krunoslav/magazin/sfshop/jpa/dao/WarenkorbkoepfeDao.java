package hr.krunoslav.magazin.sfshop.jpa.dao;

import hr.krunoslav.magazin.sfshop.jpa.entities.Objekte;
import hr.krunoslav.magazin.sfshop.jpa.entities.Warenkorbkoepfe;

public interface WarenkorbkoepfeDao extends Dao {

	Warenkorbkoepfe createWarenkorbkoepfe(Objekte object);
}
