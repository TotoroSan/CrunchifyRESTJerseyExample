//
//public class dump {
//	package com.crunchify.restjersey.model;
//
//	import java.lang.invoke.MethodHandles;
//	import java.util.List;
//	import java.util.Optional;
//	import java.util.logging.Logger;
//
//	import jakarta.persistence.EntityManager;
//	import jakarta.persistence.EntityManagerFactory;
//	import jakarta.persistence.Persistence;
//	import jakarta.persistence.PersistenceContext;
//	import jakarta.persistence.criteria.Order;
//
//	// TODO generalise to model repository
//	// to make it stateless we could just rest on request via listener since i dont have EJB environment yet
//	public class PersonRepository {
//		private static final Logger logger = Logger.getLogger(MethodHandles.lookup().lookupClass().getName());
//		// this defines that the entitymanager will exist during the context lifecycle
//		// (does it auto delete?)
//		// it basically what i did manually iwth the listeners, but its way cleaner this
//		// way.
//		// i can probably configure the context for the manager but default is app
//		// lifecycle (check)
//
//		// entitymanager serves as L1 cache => it knows all objects that are part of a
//		// transaction
//		// entitymanager factory serves as L2 cache => it knows all objects of all
//		// transactions
//		// check where entitymanager should be moved => one per thread i think, so just
//		// create once on context start of a servlet thread
//
//		@PersistenceContext
//		private static EntityManagerFactory emf;
//
//		public static EntityManagerFactory getEMF() {
//			if (emf == null) {
//				emf = Persistence.createEntityManagerFactory("default"); // default here is important => referende in
//																			// persistenxe xml
//			}
//			return emf;
//		}
//
//		// entitymanager per persistence conttext (= lifetime of servlet container (i.e.
//		// thread)
//		@PersistenceContext
//		private static EntityManager em = PersonRepository.getEMF().createEntityManager();
//
//		public static Person create(Person person) {
//			logger.info("Creating person " + person.getName());
//
//			em.getTransaction().begin();
//			em.persist(person);
//			em.getTransaction().commit();
//
//			return person;
//		}
//
//		public static List<Person> findAll() {
//			logger.info("Getting all Persons");
//
//			return em.createQuery("SELECT p FROM Person p", Person.class).getResultList();
//
//		}
//
//		public static Person findById(int id) {
//			logger.info("Getting Person by id " + id);
//
//			return em.find(Person.class, id);
//
//		}
//		// TODO MOVE TO ORDER INSTEAD OF SPECIFIC CLASS => THEN DO Order.class
//
//		public static void delete(int id) {
//			logger.info("Deleting Person by id " + id);
//
//			Person person = em.find(Person.class, id);
//
//			if (person != null) {
//				em.getTransaction().begin();
//				person = em.merge(person);
//				em.remove(person);
//				em.getTransaction().commit();
//			} else {
//				// return as message maybe TODO
//				System.out.println("Person not found");
//			}
//
//		}
//
//		public Person update(Person person) {
//			logger.info("Updating Person " + person.getName());
//
//			return em.merge(person);
//		}
//
//	}
//
//}
