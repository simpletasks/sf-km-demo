package hr.krunoslav.magazin.sfshop.jpa.dao.impl;

import hr.krunoslav.magazin.sfshop.jpa.dao.JpaDaoAbstractImpl;
import hr.krunoslav.magazin.sfshop.jpa.dao.WarenkorbkoepfeDao;
import hr.krunoslav.magazin.sfshop.jpa.entities.Objekte;
import hr.krunoslav.magazin.sfshop.jpa.entities.Warenkorbkoepfe;

public class WarenkorbkoepfeDaoImpl extends JpaDaoAbstractImpl<Warenkorbkoepfe> implements WarenkorbkoepfeDao {


	@Override
	public Warenkorbkoepfe createWarenkorbkoepfe(Objekte object) {
		return new Warenkorbkoepfe(object);
	}

}
