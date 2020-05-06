package com.RestAssuredTests;

import java.util.HashMap;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;

public class Demo3_BDD {

public static HashMap map = new HashMap();
String name =Restapis.setname();
String job = Restapis.setjob();
int user_id = 2;


	@BeforeClass
	public void putdata() {
		
		map.put("name", name);
		map.put("job", job);
		
		RestAssured.baseURI="https://reqres.in";
		RestAssured.basePath="/api/users/" + user_id;
		
	}
	
	@Test
	public void puttest() {
		
		given()
		.contentType("application/json; charset=utf-8")
		.body(map)
		.when()
		.put()
		.then()
		.statusCode(200)
		.log().all();
	}
	
	
	
}
