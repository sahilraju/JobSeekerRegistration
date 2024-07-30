package com.jobs.register;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JobSeekerRegistration { 

	private Connection connection;

	public JobSeekerRegistration(Connection connection) {
		this.connection = connection;
	}

	public int addJobSeeker(String name, int age, String qualification, int experience, String domain,
			long expectedSalary) {

		int effectedRows = 0;

		try {
			PreparedStatement prepare = connection.prepareStatement(
					"INSERT INTO jobseeker (name,age,qualification,experience,domain_of_experience,salary) VALUES(?,?,?,?,?,?)");

			prepare.setString(1, name);
			prepare.setInt(2, age);
			prepare.setString(3, qualification);
			prepare.setInt(4, experience);
			prepare.setString(5, domain);
			prepare.setLong(6, expectedSalary); 

			effectedRows = prepare.executeUpdate();

			System.out.println(effectedRows + " row got effected");

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return effectedRows;

	}
	
	public void viewAllJobSeekers() {
		
		try {
			Statement statement = connection.createStatement();
			
			ResultSet result = statement.executeQuery("SELECT * From jobseeker");
			
			while(result.next()) {
				
				System.out.println("Name: "+result.getString(2));
				System.out.println("Age "+result.getInt(3));
				System.out.println("Qualification: "+result.getString(4));
				System.out.println("Experience: "+result.getInt(5));
				System.out.println("Domain: "+result.getString(6));
				System.out.println("Salary: "+result.getInt(7)); 
				System.out.println("------------------------------");  
				
			}
			
		} catch (SQLException e) { 
			e.printStackTrace();
		}
		
	}

}
