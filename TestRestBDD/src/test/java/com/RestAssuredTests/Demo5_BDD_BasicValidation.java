package com.RestAssuredTests;

import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.RestAssured;
import io.restassured.http.Header;

/*
 * 
 1)Test Status Code
 2)Log Response
 3)Verifying Single Content in response body
 4)verifying Multiple content
 5)setting parameters and headers
 * 
 */

public class Demo5_BDD_BasicValidation {

	@Test(priority=1)
	public void teststatuscode() {
		
		given()
		.when()
		.get("https://jsonplaceholder.typicode.com/posts/4")
		.then()
		.statusCode(200)
		.log().all();
	}
	
	@Test(priority=2)
	public void testSingleContent() {
		
		given()
		.when()
		.get("https://reqres.in/api/users/2")
		.then()
		.statusCode(200)
	.body("data.email", equalTo("janet.weaver@reqres.in"));
	}
	
	
	
	@Test(priority=4)
	public void testMultipleContent() {
		
		given()
		.when()
		.get("https://reqres.in/api/users")
		.then()
		.statusCode(200)
	.body("data.email", hasItems("emma.wong@reqres.in",	
			"charles.morris@reqres.in"));
	}
	
	@Test(priority=3)
	public void testparamandHeaders() {
		
		given()
		.param("myname", "x")
	.header("id","y")
		.when()
		.get("https://reqres.in/api/users")
		.then()
		.statusCode(200)
		.log().all();
	
	}
	
}
