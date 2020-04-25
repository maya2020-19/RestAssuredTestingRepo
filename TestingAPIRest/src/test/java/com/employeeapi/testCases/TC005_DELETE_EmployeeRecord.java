package com.employeeapi.testCases;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.employeeapi.base.TestBase;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;

public class TC005_DELETE_EmployeeRecord extends TestBase {

	@BeforeClass
	public void Delete_Emp() throws InterruptedException {

		System.out.println("----Started TC005 Delete Emp----");

		RestAssured.baseURI = "https://dummy.restapiexample.com/api/v1";
		httprequest = RestAssured.given();

		response = httprequest.request(Method.GET, "/employees");

		JsonPath jsonpathevaluator = response.jsonPath();

		String empId = jsonpathevaluator.get("[0].id");
		response = httprequest.request(Method.DELETE, "/delete/" +empId);

		Thread.sleep(5000);
	}

	@Test
	void checkResponseBody() {
		System.out.println("****Checking the Response Body****");
		String respbody = response.getBody().asString();
		Assert.assertEquals(respbody.contains("successfully! deleted Records"),true);
	}

	@AfterClass

	void teardown() {
		System.out.println("----Finished TC005 Delete Emp----");

	}
}
