package hr.krunoslav.magazin.sfshop.jpa.dao.impl;

import hr.krunoslav.magazin.sfshop.jpa.dao.JpaDaoAbstractImpl;
import hr.krunoslav.magazin.sfshop.jpa.dao.WarenkorbdetailsDao;
import hr.krunoslav.magazin.sfshop.jpa.entities.Warenkorbdetail;
import hr.krunoslav.magazin.sfshop.jpa.entities.Warenkorbkoepfe;

public class WarenkorbdetailsDaoImpl extends JpaDaoAbstractImpl<Warenkorbdetail> implements WarenkorbdetailsDao {


	@Override
	public Warenkorbdetail createWarenkorbdetail(Warenkorbkoepfe warenkorbkoepfe) {
		return  new Warenkorbdetail(warenkorbkoepfe);
	}

}
