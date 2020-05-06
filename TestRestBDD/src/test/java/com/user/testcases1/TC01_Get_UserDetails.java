package com.user.testcases1;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.user.testbase1.TestBase1;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class TC01_Get_UserDetails extends TestBase1 {

	@BeforeClass
	public void GET_user() throws InterruptedException {

		System.out.println("Starting 1st TestCase........");

		RestAssured.baseURI = "https://reqres.in";

		httpRequest = RestAssured.given();
		response = httpRequest.request(Method.GET, "/api/users");
		Thread.sleep(3000);

	}

	@Test(priority = 1)
	public void validate_responsebody() {
		System.out.println("Validating Responsebody........");
		String responseBody = response.getBody().asString();
		System.out.println("The reponse is" + responseBody);
	}

	@Test(priority = 2)
	public void validate_statuscode() {
		System.out.println("Validating StatusCode........");
		int statuscode = response.getStatusCode();
		System.out.println("Status code is ---" + statuscode);
		Assert.assertEquals(statuscode, 200);
	}

	@Test(priority = 3)
	public void validate_headers() {
		System.out.println("Validating Header........");
		String headervalue = response.header("Content-Type");
		Assert.assertEquals(headervalue, "application/json; charset=utf-8");
		System.out.println("The header value is -- " + headervalue);
	}

	@Test(priority = 4)
	public void validate_AllHeaders() {
		System.out.println("Validating AllHeaders........");
		Headers AllHeaders = response.headers();
		for (Header header : AllHeaders) {
			System.out.println(header.getName());
			System.out.println(header.getValue());

		}
	}

	@AfterClass
	
	public void teardown() {
		
		System.out.println("TC01 Finished...........");
	}
}
