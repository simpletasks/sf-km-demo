package hr.krunoslav.magazin.sfshop.jpa.dao.impl;

import java.math.BigInteger;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import hr.krunoslav.magazin.sfshop.jpa.dao.JpaDaoAbstractImpl;
import hr.krunoslav.magazin.sfshop.jpa.dao.ObjekteDao;
import hr.krunoslav.magazin.sfshop.jpa.entities.Objekte;

public class ObjekteDaoImpl extends JpaDaoAbstractImpl<Objekte> implements ObjekteDao {

	private static final Logger LOG = LogManager.getLogger(ObjekteDaoImpl.class);
	
	@Override
	public <E> E findById(BigInteger id) {
		E object = null;
		try {
			object = super.findById(id);
		} catch (Exception e) {
			LOG.error("Exception loading instance of Objekte", e);
			return null;
		}
		return (E) object;
	}
}
