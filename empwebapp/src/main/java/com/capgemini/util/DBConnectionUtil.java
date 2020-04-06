package com.capgemini.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnectionUtil {
//define database properties
	private static final String URL = "jdbc:mysql://localhost:3306/employeedirectory";
	private static final String DRIVER = "com.mysql.jdbc.Driver";

	private static final String USERNAME = "root";
	
	private static final String PASSWORD = "root";
	
	private static Connection connection = null;
	//define static method
	 public static Connection openConnection() {
		//check the connection
		if(connection != null) {
			return connection;
		} else {
			try {
				//Load the driver
				Class.forName(DRIVER);
				
				//Get the connection 
				connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			} catch(Exception e) {
				
				e.printStackTrace();
			}
		}
		
		//return connection
		return connection;
	}


}
