package com.employeeapi.testCases;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import com.employeeapi.base.TestBase;

import io.restassured.RestAssured;
import io.restassured.http.Method;

public class TC002_GET_SingleEmployee extends TestBase{
	
	public void Get_Emp() throws InterruptedException {
	
		System.out.println("----Started TC002 GET Single Emp----");
		RestAssured.baseURI = "https://dummy.restapiexample.com/api/v1";
		httprequest = RestAssured.given();

		response = httprequest.request(Method.GET, "/employees/" +empId);

		Thread.sleep(6000);
	}
	
	@Test
	void checkResponseBody() {
	System.out.println("****Checking the Response Body****");
		String responsebody = response.getBody().asString();
		System.out.println("Response Body is --- " + responsebody);
		Assert.assertTrue(responsebody.contains(empId));
	}

	@Test
	void checkStatusCode() {
		System.out.println("****Checking the Status Code****");
		int statuscode = response.getStatusCode();
		System.out.println("StatusCode is --- " + statuscode);
		Assert.assertEquals(statuscode, 200);
	}
	
	@Test
	void checkContentLength() {
		System.out.println("****Checking the Content Length****");
		String contentLength = response.getHeader("content-length");
		System.out.println("Content length value is --- " + contentLength);
		Assert.assertTrue(Integer.parseInt(contentLength)<1000);
	}
	
	@AfterClass
	void teardown() {
		System.out.println("----Finished TC002 GET Single Emp----");
	}
}
