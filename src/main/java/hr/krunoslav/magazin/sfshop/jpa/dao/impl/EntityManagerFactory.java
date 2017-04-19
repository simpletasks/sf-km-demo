package hr.krunoslav.magazin.sfshop.jpa.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class EntityManagerFactory {

	private static javax.persistence.EntityManagerFactory emf = Persistence.createEntityManagerFactory("demo-project");

	private EntityManager entitymanager;

	public EntityManager getEntitymanager() {
		if (entitymanager == null) {
			synchronized (this) {
				if (entitymanager == null) {
					entitymanager = emf.createEntityManager();
				}
			}
		} else {
			if (!entitymanager.isOpen()) {
				synchronized (this) {
					if (!entitymanager.isOpen()) {
						entitymanager = emf.createEntityManager();
					}
				}
			}
		}
		return entitymanager;

	}
}
