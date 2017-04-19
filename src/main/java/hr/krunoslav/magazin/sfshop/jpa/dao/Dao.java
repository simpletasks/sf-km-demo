package hr.krunoslav.magazin.sfshop.jpa.dao;

import java.math.BigInteger;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

/**
 * Force using transaction scoped {@link EntityManager} instance per {@link EntityTransaction}.
 * Use {@link #flushInTransaction(EntityManager)} on the end of processing for transaction management.
 * 
 * @author Krunoslav Magazin
 *
 */
public interface Dao {

	<E> void persist(E entity);
	
	<E> E findById(BigInteger id);
	
	/**
	 * 
	 * @param entities
	 * @return if entities list is empty return NULL otherwise return first member
	 */
	<E> E getFirstResult(List<E> entities);
	
	/**
	 * Opens local transaction on entityManager than commit.
	 * In case of exception roll back.
	 * On exit close entityManager
	 * @param entityManager
	 */
	void flushInTransaction(EntityManager entityManager);
	
	public EntityManager getEntitymanager();
	
	public void setEntitymanager(EntityManager entitymanager);
}
