
  package com.crunchify.restjersey.listeners;

  
  
  import java.sql.SQLException;

import javax.servlet.*;
  import javax.servlet.annotation.WebListener;

import com.crunchify.restjersey.dataservice.*; 
  
  @WebListener
  public final class PersonContextListener implements ServletContextListener { 
		/*
		 * @javax.ws.rs.core.Context ServletContext context;
		 */
	  
	  public PersonContextListener() {
	  
	  }
	  
	  
	  // this is triggered once the servlet context is started => this happens on boot up for the first time. 
	  // everything done here is only deleted if my application servlet shuts down (not the thread for it i think, but the whole applet)
	  // so ressources handled by this will be available over for all calls to the person service web application
	  public void contextInitialized(ServletContextEvent sce) { 
		  // execute everything here that relates to the application-level and needs to be accessable by all instances of the service (in my case for example the persons hashmap (which serves as cache)
		  // the persons hashmap would then be accessable for all service instances
		  // so it is the context for ALL servlet instances
		  // connection to the database can be established here, so that every instance of the service already has established connection => save connection as attribute to the context listener	  
		  //initialize context parameter and store in static variable 
		  System.out.println("new servlet context initialized => PersonService servlet created");
		  DatabaseConnection databaseConnection = new DatabaseConnection(); // establish database connection
		  

	  }
  
	  // implement the required context destroy method void
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
 