package TestJobSeeker;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.jobs.register.DBConnection;
import com.jobs.register.JobSeekerRegistration;


@RunWith(Parameterized.class)
@FixMethodOrder(MethodSorters.DEFAULT) 
public class TestJobSeekerInfo {

	private Connection connection;

	private JobSeekerRegistration register; 

	private String name;
	private int age;
	private String qualification;
	private int expericence;
	private String domain;
	private long salary;

	public TestJobSeekerInfo(String name, int age, String qualification, int expericence, String domain, long salary) {
		this.name = name;
		this.age = age;
		this.qualification = qualification;
		this.expericence = expericence;
		this.domain = domain;
		this.salary = salary;
	}
	
	@BeforeClass 
	public void init() {
		
		connection = DBConnection.establishConnection();
		
		
		register = new JobSeekerRegistration(connection); 
		
	}

	@Test
	public void testAddJobSeeker() { 
		
		int effectedRows = register.addJobSeeker(name, age, qualification, expericence, domain, salary); 
		
		Assert.assertEquals(1, effectedRows);  
		
	}
	
	@AfterClass 
	public void destroy() {
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Parameters 
	public Collection<Object[]> dataProvider() {

		return Arrays.asList(new Object[][] { { "rahul", 25, "m.tech", 2, "analyst", 800000 },
				{ "karthik", 24, "mca", 1, "emmbaded", 600000 } }); 

	}

}
