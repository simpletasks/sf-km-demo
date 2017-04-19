package hr.krunoslav.magazin.sfshop.unit.dao.core;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;

/**
 * Class have common setup for every JPA related test. For every test creates
 * entity manager and secures cleaning of database after test is done. In tests,
 * recommendation is to use methods
 * {@link EntityBuilder#persistInTransaction(java.io.Serializable)} and
 * {@link EntityBuilder#removeInTransaction(java.io.Serializable)}
 * for automated removal of persisted entities during test.
 * 
 * @author Krunoslav Magazin
 *
 */
public class TestJpaAbstract {

	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("demo-project");

	protected EntityManager em = null;
	protected EntityBuilder builder = null;

	/**
	 * In overridden method first call this method
	 * 
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		em = createEntityManager();
		builder = new EntityBuilder(em);

	}

	/**
	 * In overridden method on last call this method
	 * 
	 * @throws Exception
	 */
	@After
	public void tearDown() throws Exception {
		builder.deleteCreatedEntities();
		if (em.isOpen()) {
			em.close();
		}
	}

	public EntityManager createEntityManager() {
		return emf.createEntityManager();
	}
}
