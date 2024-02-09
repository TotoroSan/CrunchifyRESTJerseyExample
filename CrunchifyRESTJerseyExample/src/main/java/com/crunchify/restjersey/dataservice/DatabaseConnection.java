package com.crunchify.restjersey.dataservice;

import java.sql.Connection;
import java.sql.DriverManager;

// barebones testing
// store connection data for current context 
// called and destroyed on context event 
// connection is static, change to dynamic TODO
// CURRENTLY UNUSED 
public class DatabaseConnection {
	
	private static String connectionUrl;
	private static Connection connection;
	
	public DatabaseConnection(){
		this.connectionUrl = "jdbc:sqlserver://localhost:1433;databaseName=TESTDB;encrypt=true;trustServerCertificate=true;user=SA;password=<Testpassword123!>";
		
		try {
			
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");	//LOAD the API driver => creates drivermanager object for the passed server 
			this.connection = DriverManager.getConnection(connectionUrl);	//Establish connection to SQL Server	
			System.out.println("Database connection established and ready to use");
		} 
		catch (Exception e) {
			System.err.println(" Error: ");
			e.printStackTrace(System.err);	
		}	
	}
	
	public static String getConnectionUrl() {
		return connectionUrl;
	}
	public static void setConnectionUrl(String connectionUrl) {
		DatabaseConnection.connectionUrl = connectionUrl;
	}
	public static Connection getConnection() {
		return connection;
	}
	public static void setConnection(Connection conn) {
		DatabaseConnection.connection = conn;
	}
	
}
