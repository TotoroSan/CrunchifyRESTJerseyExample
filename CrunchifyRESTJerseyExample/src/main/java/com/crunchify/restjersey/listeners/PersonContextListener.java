
  package com.crunchify.restjersey.listeners;
  

import com.crunchify.restjersey.model.ModelResourceRepository;

  
  
  import java.sql.SQLException;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;


  
  @WebListener
  public final class PersonContextListener implements ServletContextListener { 
		/*
		 * @javax.ws.rs.core.Context ServletContext context;
		 */
	  
	  public PersonContextListener() {
	  
	  }
	  
	  
	  public void contextInitialized(ServletContextEvent sce) { 

		  System.out.println("new servlet context initialized => PersonService servlet created");
		  //DataManager contextDataManager = new DataManager();
		  //DatabaseConnection databaseConnection = new DatabaseConnection(); // establish database connection
		  //PersonRepository personRepository = new PersonRepository(); // keep person repository for the whole servlet context lifecycle (change later if i make storage own serice or integrate EJB)
	  }
  
	  
	  public void contextDestroyed(ServletContextEvent sce) { 
		// close databse connection => transfer everything from cache to db 
		  
//		  DatabaseAgent.postData();
//		  
//		  try {
//			DatabaseConnection.getConnection().close();
//		  } catch (SQLException e) {
//			e.printStackTrace();
//		  } // close connection
//		  
		  System.out.println("servlet context destroyed, data connection closed => JOBS DONE");
		  
		   
		  
	  } 
	  
	  // a session listener would manage data for each indivdual http session => if i would have the persons hashmap here, it would only persit until a sessnion has ended 
	  // on closing of a session we can transfer data to the data base 
  }
 