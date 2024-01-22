
  package com.crunchify.restjersey.listeners;

  
  
  import java.sql.SQLException;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

import com.crunchify.restjersey.dataservice.*; 
  
  @WebListener
  public final class PersonContextListener implements ServletContextListener { 
		/*
		 * @javax.ws.rs.core.Context ServletContext context;
		 */
	  
	  public PersonContextListener() {
	  
	  }
	  
	  
	  public void contextInitialized(ServletContextEvent sce) { 

		  System.out.println("new servlet context initialized => PersonService servlet created");
		  DatabaseConnection databaseConnection = new DatabaseConnection(); // establish database connection
	  }
  
	  
	  public void contextDestroyed(ServletContextEvent sce) { 
		// close databse connection => transfer everything from cache to db 
		  
//		  DatabaseAgent.postData();
//		  
		  try {
			DatabaseConnection.getConnection().close();
		  } catch (SQLException e) {
			e.printStackTrace();
		  } // close connection
		  
		  System.out.println("servlet context destroyed, data connection closed => JOBS DONE");
		  
		   
		  
	  } 
	  
	  // a session listener would manage data for each indivdual http session => if i would have the persons hashmap here, it would only persit until a sessnion has ended 
	  // on closing of a session we can transfer data to the data base 
  }
 