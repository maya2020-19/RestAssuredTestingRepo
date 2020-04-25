package com.employeeapi.testCases;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.employeeapi.base.TestBase;
import com.employeeapi.utilities.RestUtils;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC003_POST_EmployeeRecord extends TestBase {

	String ename = RestUtils.empname();
	String esal = RestUtils.empsal();
	String eage = RestUtils.empage();

	@BeforeClass
	public void POST_Method() throws InterruptedException {

		System.out.println("----Started TC003 POST Emp record----");

		RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";
		httprequest = RestAssured.given();

		// Request Payload to be sent

		JSONObject requestparams = new JSONObject();

		requestparams.put("name", ename);
		requestparams.put("salary", esal);
		requestparams.put("age", eage);

		httprequest.header("Content-Type", "application/json");
		httprequest.body(requestparams.toJSONString());

		response = httprequest.request(Method.POST, "/create");

		Thread.sleep(5000);
	}

	@Test
	void checkResponseBody() {
		System.out.println("****Checking the Response Body****");
		String respbody = response.getBody().asString();
		System.out.print(respbody);
		Assert.assertEquals(respbody.contains(ename), true);
		Assert.assertEquals(respbody.contains(esal), true);
		Assert.assertEquals(respbody.contains(eage), true);

	}

	@Test
	void checkStatusCode() {
		System.out.println("****Checking the Status Code****");
		int statuscode = response.getStatusCode();
		System.out.println("The status code is " + statuscode);
		Assert.assertEquals(statuscode, 200);
	}

	@Test
	void checkStatusLine() {
		System.out.println("****Checking the Status Line****");

		String statusline = response.getStatusLine();
		System.out.println("The status Line is " + statusline);
		Assert.assertEquals(statusline, "HTTP/1.1 200 OK");
	}

	@Test
	void checkSuccessStatus() {
		System.out.println("****Checking the Status****");
		String successstatus = response.jsonPath().get("status");
		System.out.println("The content is " + successstatus);
		Assert.assertEquals(successstatus, "success");

	}

	@AfterClass
	void teardown()
	{
		System.out.println("----Finished TC003 POST Emp record----");
	}
}
