package hr.krunoslav.magazin.sfshop.jpa.dao;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.math.BigInteger;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public abstract class JpaDaoAbstractImpl<E> implements Dao {

	protected EntityManager entitymanager;
	protected Class entityClass;
	
	public JpaDaoAbstractImpl() {
		ParameterizedType parameterizedType = (ParameterizedType) this.getClass().getGenericSuperclass();
		Type[] types = parameterizedType.getActualTypeArguments();
		for (Type t : types){
			// TODO set Logger !!
			System.out.println( "type = " + t.getTypeName());
		}
		entityClass = (Class) parameterizedType.getActualTypeArguments()[0];
	}
	
	@Override
	public <E> void persist(E entity) {
		entitymanager.persist(entity);
		
	}
	
	@Override
	public <E> E findById(BigInteger id){
		return (E) entitymanager.find(entityClass, id);
	}
	
	
	public <E> E getFirstResult(List<E> entities){
		if (entities == null || entities.isEmpty()){
			return null;
		}
		return entities.get(0);
	}
	
	/**
	 * Use this method <b>only</b> if entityManager is used in just current thread. 
	 * @param entityManager
	 */
	public void flushInTransaction(EntityManager entityManager) {
		EntityTransaction transaction = entityManager.getTransaction();
		try {
			transaction.begin();
			transaction.commit();
		} catch (Exception e) {
			if (transaction.isActive()){
				transaction.rollback();
			}
		} finally {
			entityManager.close();
		}
	}


	public EntityManager getEntitymanager() {
		return entitymanager;
	}


	public void setEntitymanager(EntityManager entitymanager) {
		this.entitymanager = entitymanager;
	}

}
