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

// to make it stateless we could just rest on request via listener since i dont have EJB environment yet
public class PersonRepository {
	private static final Logger logger = Logger.getLogger(MethodHandles.lookup().lookupClass().getName());
	// this defines that the entitymanager will exist during the context lifecycle (does it auto delete?)
	// it basically what i did manually iwth the listeners, but its way cleaner this way.
	// i can probably configure the context for the manager but default is app lifecycle (check)
	
	// the entitymanager also serves as a sort of cache (i think it should have it built in)
	// since it keeps track of all persons persisted and probably keeps them
	
	// entity manager contains all objects created in its lifecycle
	
	@PersistenceContext
	private static EntityManagerFactory emf;
	@PersistenceContext
	private static EntityManager em;
	public static EntityManagerFactory getEMF (){
	    if (emf == null){
	        emf = Persistence.createEntityManagerFactory("default");
	    }
	    return emf;
	}
	

	
	
	
	public static Person create(Person person) {
		logger.info("Creating person " + person.getName());
		
		EntityManager em = PersonRepository.getEMF().createEntityManager();
				
	    try{
	        em.getTransaction().begin();
	        em.persist(person);
	        em.getTransaction().commit();
	    }finally{
	        em.close();
	    }
		return person;
	}
	
    public static List<Person> findAll() {
        logger.info("Getting all Persons");
		EntityManager em = PersonRepository.getEMF().createEntityManager();
	    try{
	    	return em.createQuery("SELECT p FROM Person p", Person.class).getResultList();
	    }finally{
	        em.close();
	    }   
    }

    public static Person findById(int id) {
        logger.info("Getting Person by id " + id);
        EntityManager em = PersonRepository.getEMF().createEntityManager();
        try{
            return em.find(Person.class, id);
        }finally{
            em.close();
        } 
    }
    // TODO MOVE TO ORDER INSTEAD OF SPECIFIC CLASS => THEN DO Order.class
    // MERGE ENTITY MANAGERS TO ONE? TODO
    // DOES IT HANDLE CACHING?
    public static void delete(int id) {
    	logger.info("Deleting Person by id " + id);
        EntityManager em = PersonRepository.getEMF().createEntityManager();

        try{
        	Person person = findById(id);
        	
        	// need to attach the entity first before we can delete it ("know that it exists")
        	if (!em.contains(person)) {
        		person = em.merge(person);
        	}
          
            em.remove(person);
            
        }finally{
            em.close();
        }
        
        
    }

    public Person update(Person person) {
        logger.info("Updating Person " + person.getName());
        EntityManager em = PersonRepository.getEMF().createEntityManager();
        
        try{
            em.getTransaction().begin();
            return em.merge(person);
        }finally{
            em.close();
        }
        
        
    }

}
