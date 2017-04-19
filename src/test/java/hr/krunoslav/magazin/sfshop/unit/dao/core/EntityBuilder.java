package hr.krunoslav.magazin.sfshop.unit.dao.core;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;

/**
 * Class is a container for persisted entities in test.
 * Also {@link #persistInTransaction(Serializable)} automatically add persited entity to ordered list.
 * 
 * @author Krunoslav Magazin
 *
 */
public class EntityBuilder {

	EntityManager em = null;
    List<Serializable> created = new ArrayList<>();
    
    
    public EntityBuilder(EntityManager em) {
		super();
		this.em = em;
	}

	/**
     * Persist entity in new transaction and add entity to created entities list.
     * @param entity
     */
    public void persistInTransaction(Serializable entity){
        em.getTransaction().begin();
        em.persist(entity);
        em.getTransaction().commit();
        created.add(entity);
    }
    
    /**
     * Remove entity in new transaction
     * @param entity
     */
    public void removeInTransaction(Serializable entity){
        em.getTransaction().begin();
        em.remove(entity);
        em.getTransaction().commit();
    }
    
    /**
     * All members of created entities list delegates to {@link #removeInTransaction(Serializable)} for removal.
     * In reverse order to honour DB relations.
     */
    public void deleteCreatedEntities(){
        Collections.reverse(created);
        Iterator<Serializable> it = created.iterator();
        while (it.hasNext()) {
            Serializable serializable = (Serializable) it.next();
            removeInTransaction(serializable);
            it.remove();
        }
    }
    
    public void setEm(EntityManager em) {
        this.em = em;
    }

    public List<Serializable> getCreated() {
        return created;
    }
    
}
