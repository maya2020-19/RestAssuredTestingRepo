package com.user.testcases1;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.user.testbase1.TestBase1;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import junit.framework.Assert;

public class TC03_GET_SingleUser_NotFound extends TestBase1 {
	
	@BeforeClass
	public void GET_user() throws InterruptedException {

		System.out.println("TC03 Started...........");

		RestAssured.baseURI = "https://reqres.in";

		httpRequest = RestAssured.given();
		response = httpRequest.request(Method.GET, "/api/users/" + Nuser);
		Thread.sleep(3000);

	}

	@Test(priority = 1)
	public void validate_responsebody() {
		System.out.println("Validating Responsebody........");
		String responseBody = response.getBody().asString();
		System.out.println("The reponse is" + responseBody);
		Assert.assertEquals(responseBody,"{}");
	}

	@Test(priority = 2)
	public void validate_statuscode() {
		System.out.println("Validating StatusCode........");
		int statuscode = response.getStatusCode();
		System.out.println("Status code is ---" + statuscode);
		Assert.assertEquals(statuscode, 404);
	}

	@AfterClass
	public void teardown() {
		System.out.println("TC03 finished...........");
	}

}
