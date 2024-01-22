//package com.crunchify.restjersey.listeners;
//
//import java.sql.SQLException;
//
//import javax.servlet.ServletRequestEvent;
//import javax.servlet.ServletRequestListener;
//import javax.servlet.annotation.WebListener;
//
//import com.crunchify.restjersey.dataservice.DatabaseAgent;
//import com.crunchify.restjersey.dataservice.DatabaseConnection;
//
//
//@WebListener
//public class PersonRequestListener implements ServletRequestListener {
//
//
//    public PersonRequestListener() {
//    }
//    
//	/**
//     * @see ServletRequestListener#requestInitialized(ServletRequestEvent)
//     */
//    public void requestInitialized(ServletRequestEvent sre)  { 
//		  System.out.println("new request initialized");
//    }
//
//	/**
//     * @see ServletRequestListener#requestDestroyed(ServletRequestEvent)
//     */
//    public void requestDestroyed(ServletRequestEvent sre)  { 
//  	  //DatabaseAgent.postData();
//	  
//
//	  
//	  System.out.println("data posted");
//    	
//    	
//	  System.out.println("request destroyed");
//    }
//
//}
