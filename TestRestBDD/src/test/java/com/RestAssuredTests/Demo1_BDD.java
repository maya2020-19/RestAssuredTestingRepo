package com.RestAssuredTests;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.matcher.ResponseAwareMatcher;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class Demo1_BDD {

	@Test
	public void Get_req() {

		Response response = 
		
		given().when().get("https://reqres.in/api/users?page=2")
		.then().statusCode(200).statusLine("HTTP/1.1 200 OK")
				.assertThat().body("data[2].id", equalTo(9)).header("Connection", "keep-alive")
				.log().body()
				.extract().response();
			
				
			String	jsonAsString = response.asString();
		Assert.assertEquals(jsonAsString.contains("first_name"),true);
		

	}

}
