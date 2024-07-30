package com.jobs.register;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

	public static Connection establishConnection() {

		Connection connection = null;

		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");

			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jobsora", "root", "root");
			

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		return connection; 
 
	}

}
