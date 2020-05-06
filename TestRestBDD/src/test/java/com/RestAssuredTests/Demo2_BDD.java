package com.RestAssuredTests;

import java.util.HashMap;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import io.restassured.RestAssured;

public class Demo2_BDD {
	
	public static HashMap map = new HashMap();
	
	
	@BeforeClass
	public void postdata() {
		
		map.put("name", Restapis.setname());
		map.put("job", Restapis.setjob());
		
		RestAssured.baseURI="https://reqres.in/";
		RestAssured.basePath="\r\n" + "/api/users";
	}
	
	@Test
	public void testpost() {
		
		given()
		.contentType("application/json; charset=utf-8")
		.body(map)
		.when()
		.post()
		.then()
		.statusCode(201);	
		
	}

}
