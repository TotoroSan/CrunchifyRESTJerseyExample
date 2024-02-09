package com.crunchify.restjersey.model;

import java.lang.invoke.MethodHandles;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.Order;

// TODO generalise to model repository
// only serve servicemodelresources
// to make it stateless we could just rest on request via listener since i dont have EJB environment yet
// this is the database interface on application level that persists resources to the db (using java persistence api)
public class ModelResourceRepository {
	private static final Logger logger = Logger.getLogger(MethodHandles.lookup().lookupClass().getName());
	// this defines that the entitymanager will exist during the context lifecycle
	// (does it auto delete?)
	// it basically what i did manually iwth the listeners, but its way cleaner this
	// way.
	// i can probably configure the context for the manager but default is app
	// lifecycle (check)

	// entitymanager serves as L1 cache => it knows all objects that are part of a
	// transaction
	// entitymanager factory serves as L2 cache => it knows all objects of all
	// transactions
	// check where entitymanager should be moved => one per thread i think, so just
	// create once on context start of a servlet thread

	@PersistenceContext
	private static EntityManagerFactory emf;

	public static EntityManagerFactory getEMF() {
		if (emf == null) {
			emf = Persistence.createEntityManagerFactory("default"); // default here is important => referende in
																		// persistenxe xml
		}
		return emf;
	}

	// entitymanager per persistence conttext (= lifetime of servlet container (i.e.
	// thread)
	@PersistenceContext
	private static EntityManager em = ModelResourceRepository.getEMF().createEntityManager();
	

	public static ModelResource create(ModelResource resource) {
		logger.info("Creating " + resource.getClass()); // TODO add info about id 
	
		try {
			em.getTransaction().begin();
			em.persist(resource);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			em.getTransaction().commit(); // this flushes the cache to db => need to execute it to close transaction
		} 
		
	
		// persist according to the binding defined in the specific resource class def
		return resource;
	}

	public static List<? extends ModelResource> findAll(ModelResource resource) {
		// I need this return syntax for lists because a list cannot contain different subclasses! 
		//Java does not know at this point that my query will only return the same sub class only.
		logger.info("Getting all resources of requested type"); 
		// we need r as name in this statement because the function cannot handle select * i think 
		return em.createQuery("SELECT r FROM " + resource.getClass().getSimpleName() + " r", resource.getClass()).getResultList();
	}
	
	// we need resource here to know which class it is TODO change away from that => check how i can pass a subclass of modelresource (actual CLASS object)
	public static ModelResource findById(int id, ModelResource resource) {
		logger.info("Getting " + resource.getClass() + " by id " + id);
		return em.find(resource.getClass(), id);
	}
	
	
	// TODO change away from class. Either split into different deletes for each class 
	//TODO FOR NOW WE SEND JUST EMPTY OBJECT (OR DUMMY) TO KEEP IT STREAMLINED 
	public static void delete(int id, ModelResource resource) {
		logger.info("Deleting Resource " + resource.getClass() + " id " + id);

		try {
			em.getTransaction().begin();
			resource = em.merge(em.find(resource.getClass(), id));
			em.remove(resource);
		} catch (Exception e) {
			e.printStackTrace(); // remove stack trace from here to not have it double because already in caller TODO
		} finally {
			em.getTransaction().commit(); // close out transaction in any case
		}
	}

	public ModelResource update(ModelResource resource) {
		logger.info("Updating resource " + resource.getClass());
		return em.merge(resource);
	}

}
