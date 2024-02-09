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
// this is the database interface on application level (uses java persistence api)
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
	
	// TODO RETURN INFO ABOUT DUPLICATE ID => CURRENTLY PRODUCES inteernal server error on dupe id 
	public static ModelResource create(ModelResource resource) {
		logger.info("Creating " + resource.getClass()); // TODO add info about id 

		em.getTransaction().begin();
		em.persist(resource); // persist according to the binding defined in the specific resource class def
		em.getTransaction().commit();

		return resource;
	}

	public static List<ModelResource> findAll(ModelResource resource) {
		// TODO check how to handle => need two versions
		logger.info("Getting all resources of requested type"); 
		// TODO non functional
		//return em.createQuery("SELECT p FROM Person p", resource.getClass()).getResultList();
		return null;
	}
	
	// we need resource here to know which class it is 
	// TODO RETURN INFO ABOUT DUPLICATE ID => CURRENTLY PRODUCES inteernal server error on dupe id 
	public static ModelResource findById(int id, ModelResource resource) {
		logger.info("Getting " + resource.getClass() + " by id " + id);
		return em.find(resource.getClass(), id);

	}
	// TODO MOVE TO ORDER INSTEAD OF SPECIFIC CLASS => THEN DO Order.class
	
	// TODO change away from class. Either split into different deletes for each class 
	//TODO FOR NOW WE SEND JUST EMPTY OBJECT (OR DUMMY) TO KEEP IT STREAMLINED 
	public static void delete(int id, ModelResource resource) {
		logger.info("Deleting Resource " + resource.getClass() + " id " + id);
// check if we can just pass the class object itself with person.class
	// fix and figure out
		resource = em.find(resource.getClass(), id);

		if (resource != null) {
			em.getTransaction().begin();
			resource = em.merge(resource);
			em.remove(resource);
			em.getTransaction().commit();
		} else {
			// return as message maybe TODO
			System.out.println("resource not found");
		}

	}

	public ModelResource update(ModelResource resource) {
		logger.info("Updating resource " + resource.getClass());

		return em.merge(resource);
	}

}
