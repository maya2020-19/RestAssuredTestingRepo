package com.user.testcases1;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.user.testbase1.TestBase1;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;

public class TC06_DELETE_User extends TestBase1 {
	
	@BeforeClass
	public void Delete_Emp() throws InterruptedException {

		System.out.println("TC05 Started............");

		RestAssured.baseURI = "https://reqres.in";
		httpRequest = RestAssured.given();

	//	response = httpRequest.request(Method.GET, "/api/users/");

		// JsonPath jsonpathevaluator = response.jsonPath();

		// String empId = jsonpathevaluator.get("[0].id");
		response = httpRequest.request(Method.DELETE, "/api/users/" +deluser);

		Thread.sleep(5000);
	}

	@Test
	void checkResponseBody() {
		System.out.println("****Checking the Response Body****");
		String respbody = response.getBody().asString();
		Assert.assertEquals(respbody.contains(""),true);
		int SC = response.getStatusCode();
		System.out.println("Statuscode -- " + 204);
		
	}

	@AfterClass

	void teardown() {
		System.out.println("TC05 Finished............");

	}
}

