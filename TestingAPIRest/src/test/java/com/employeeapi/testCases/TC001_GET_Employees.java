package com.employeeapi.testCases;


import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.employeeapi.base.TestBase;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC001_GET_Employees extends TestBase {

	@BeforeClass
	public void Get_AllEmployees() throws InterruptedException {

		System.out.println("----Started TC001 GET ALL Employees----");
		
		RestAssured.baseURI = "https://dummy.restapiexample.com/api/v1";
		httprequest = RestAssured.given();

		response = httprequest.request(Method.GET, "/employees");

		Thread.sleep(3000);
	}

	@Test
	void checkResponseBody() {
	System.out.println("****Checking the Response Body****");
		String responsebody = response.getBody().asString();
		System.out.println("Response Body is --- " + responsebody);
		Assert.assertTrue(responsebody != null);
	}

	@Test
	void checkStatusCode() {
		System.out.println("****Checking the Status Code****");
		int statuscode = response.getStatusCode();
		System.out.println("StatusCode is --- " + statuscode);
		Assert.assertEquals(statuscode, 200);
	}

	@Test
	void checkStatusLine() {
		System.out.println("****Checking the Status Line****");
		String statusline = response.getStatusLine();
		System.out.println("StatusLine is --- " + statusline);
		Assert.assertEquals(statusline, "HTTP/1.1 200 OK");
	}

	@Test
	void checkcontenttype() {
		System.out.println("****Checking the Content-Type****");
		String contenttype = response.header("content-type");
		System.out.println("ContentType is --- " + contenttype);
		Assert.assertEquals(contenttype, "application/json;charset=utf-8");
	}

	@Test
	void checkcontentencoding() {
		System.out.println("****Checking the Content-encoding****");
		String contentencoding = response.header("content-encoding");
		System.out.println("ContentEncoding is --- " + contentencoding);
		Assert.assertEquals(contentencoding, "gzip");
	}

	@Test
	void checkServer() {
		System.out.println("****Checking the server****");
		String server = response.header("server");
		System.out.println("ContentEncoding is --- " + server);
		Assert.assertEquals(server, "Apache");
	}

	@Test
	void checkReponsetime() {
		System.out.println("****Checking the ResponseTime****");
		long responseTime = response.getTime();
		System.out.println("ContentEncoding is --- " + responseTime);

		if (responseTime > 30000) {

			System.out.println("Response Time is greater");
			Assert.assertTrue(responseTime < 30000);
		}

	}
	
	@AfterClass
	
	void tearDown() {
		
		System.out.println("-----Finished TC001 GET ALL Employees-----");
	}

}