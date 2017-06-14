package com.integerationtest;

import static com.jayway.restassured.RestAssured.given;
import static com.jayway.restassured.RestAssured.when;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.is;

import java.util.Arrays;

import org.apache.http.HttpStatus;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
//import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.example.DemoSpringBootApplication;
import com.example.model.Staff;
import com.example.repository.StaffRepository;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;

@RunWith(SpringJUnit4ClassRunner.class)   // 1
@SpringApplicationConfiguration(classes = DemoSpringBootApplication.class)   // 2
@WebAppConfiguration   // 3
@IntegrationTest("server.port:8091") 
public class StaffIntegerationTestIT {

	@Autowired
	StaffRepository staffrep;
	
	Staff staff1;
	Staff staff2;
	Staff staff3;
	
	@Value("${local.server.port}")   // 6
    int port;
	
	@Before
    public void setUp() {
		staff1 = new Staff("Prasanna",1,"cse","os",25);
		staff2 = new Staff("prem",2,"cse","ds",25);
		staff3 = new Staff("prem",21,"cse","dss",25);
		
		
		
		staffrep.deleteAll();
		staffrep.save(Arrays.asList(staff1,staff2,staff3));
		
		RestAssured.port = port;
	}
	
	 @Test
	    public void displayall() {
		// Integer id = staff1.getId();
	        when().
	                get("/api/staff").
	        then().
	                statusCode(HttpStatus.SC_OK).
	                body("name",hasItems("Prasanna","prem"));
	               
	    }
	 
	@Test
	  public void addItemShouldReturnSavedItem() {
		
	    given()
	      .body(staff3)
	      .contentType(ContentType.JSON)
	    .when()
	      .post("/api/staff")
	    .then()
	      .statusCode(HttpStatus.SC_OK)
	      .body("id", is(21));
	     
	      
	  }
	@Test
	public void delete(){
		when().
			delete("/api/staff/{id}",2).
		then().
			statusCode(HttpStatus.SC_OK);
	}
@Test
public void update()
{
	staff1.setName("stark");
	 given()
     .body(staff1)
     .contentType(ContentType.JSON)
     .when()
     .put("/api/staff/1")
     .then()
		.statusCode(HttpStatus.SC_OK)
		 .body("name",is("stark"));
}

@Test
public void displaybysubject()
{
	//String sub = staff2.getSubject();
	 given()
     .body(staff1)
     .contentType(ContentType.JSON)
    .when()
     .get("age/{age}",25)
     .then()
     	.statusCode(HttpStatus.SC_OK)
     	.body("name", hasItems("prasanna"));
}
	
}
