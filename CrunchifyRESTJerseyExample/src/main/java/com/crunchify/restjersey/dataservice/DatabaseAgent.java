package com.crunchify.restjersey.dataservice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//import org.apache.commons.dbutils.handlers.BeanHandler;

import com.crunchify.restjersey.model.Person;
import com.crunchify.restjersey.personservice.PersonServiceImpl;

// transfer a persons data to SQL data base via JDBC driver to connect with the database 
// get data from db 
// this class interacts with the actual database and persistent data 
// next step => TODO make dynamic (adaptable to table and database)



public class DatabaseAgent {
	
	// testing purposes
	public static void postData() {
		// Specify the connection URL as per SQL server connection string.
		// do loop here that goes over all data in cache 
		Connection conn = DatabaseConnection.getConnection(); // get the connection
		PreparedStatement stmt = null;
		// TODO make a queue of persons that need to be updated in data manger and use this here => so i dont get pk constraint agaiin and again
		// implement non violation of pk constraints (id)
//		for (Person person : DataManager.getAllPersons()) {
//		
//			try {
//				
//				// Create a statement object, this is the vehicle for carrying your SQL inserts							
//	
//				// Create a statement object, this is the vehicle for carrying your SQL inserts							
//				 stmt = conn.prepareStatement("INSERT Persons" +
//						  " VALUES(?,?,?,?,?)");
//				  //SET the values in your table columns 
//				  stmt.setInt(1, person.getId()); 
//				  stmt.setString(2, person.getName()); 
//				  stmt.setString(3, person.getAddress()); 
//				  stmt.setString(4, person.getNationality());
//				  stmt.setString(5, person.getPhonenumber());
//				  
//				  //EXECUTE the update => this sends the statement via the connection we made
//				  stmt.executeUpdate();
//					 	
//			}
//			
//			catch (Exception e) {
//				System.err.println(" Error: ");
//				e.printStackTrace(System.err);	
//			}
//			
//			// CLOSE the Statement and Connection objects (this is executed ALWAYS)
//			finally { 
//				if (stmt != null) {
//					try {
//						stmt.close(); 
//					} catch (SQLException e) {
//						e.printStackTrace();
//					}
//				}
//			}	
//		}
	}
	
	public static Person getData(int key) {
		// return full record from data base for given key 
		Connection conn = DatabaseConnection.getConnection(); // get the connection
		PreparedStatement stmt = null;
		Person person = null;
		
//		try {
//			stmt = conn.prepareStatement("SELECT * FROM Persons WHERE PersonID=" + key);
//			ResultSet resultSet = stmt.executeQuery();
//			
//			 //this handler converts the result set into the specified bean (=> tries to convert it to a class object)
////			BeanHandler<Person> beanHandler = new BeanHandler<Person>(Person.class);
////			person = beanHandler.handle(resultSet);
//			
//			
//		} catch (SQLException e) {
//			System.err.println(" Error: ");
//			e.printStackTrace();
//		}
		
		return person;
			
	}
	
//	public static void checkDataExistence(int key) {
//		
//	}
//	
//	
//	public void generateStatement() {
//		// TODO write code to generate a statement according to passed data
//	}
	
}
