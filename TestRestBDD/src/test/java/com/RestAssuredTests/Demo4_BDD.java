package com.RestAssuredTests;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

public class Demo4_BDD {
	
	int emp_id=2;


		@Test
		public void delete_req() {
	
	RestAssured.baseURI="https://reqres.in";
			RestAssured.basePath="/api/user/"+emp_id;
			
			given()
			.when()
			.delete()
			.then()
			.statusCode(204)
			.log().all();
	
	
}
	
	
}
