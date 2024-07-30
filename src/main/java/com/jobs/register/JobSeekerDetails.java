package com.jobs.register;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class JobSeekerDetails {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

//		System.out.println("Name: ");
//		String name = input.next();
//
//		System.out.println("Age: ");
//		int age = input.nextInt();
//
//		System.out.println("Qualification: ");
//		String qualification = input.next();
//
//		System.out.println("Experience: ");
//		int experience = input.nextInt();
//
//		System.out.println("Domain of experience: ");
//		String domain = input.next();
//
//		System.out.println("Expected salary: ");
//		long salary = input.nextLong(); 

		Connection connection = DBConnection.establishConnection();

		JobSeekerRegistration registration = new JobSeekerRegistration(connection);

		//registration.addJobSeeker(name, age, qualification, experience, domain, salary);
		
		registration.viewAllJobSeekers(); 

		input.close();
		try {
			connection.close();
		} catch (SQLException e) { 
			e.printStackTrace();
		}

	}

}
