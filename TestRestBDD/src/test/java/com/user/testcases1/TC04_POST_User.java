package com.user.testcases1;

import org.json.simple.JSONObject;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.google.gson.JsonObject;
import com.user.testbase1.TestBase1;
import com.user.utilities1.RestUtil;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import junit.framework.Assert;

public class TC04_POST_User extends TestBase1 {

	String name1 = RestUtil.Username();
	String job1 = RestUtil.UserJob();

	@BeforeClass
	public void create_user() {

		System.out.println("TC04 Started..............");
		RestAssured.baseURI = "https://reqres.in";
		httpRequest = RestAssured.given();

		JSONObject reqParam = new JSONObject();
		reqParam.put("name", name1);
		reqParam.put("job", job1);

		httpRequest.header("Content-Type", "application/json; charset=utf-8");
		httpRequest.body(reqParam.toJSONString());

		response = httpRequest.request(Method.POST, "/api/users");

	}

	@Test
	public void validate_response() {
		String responseBody = response.getBody().asString();
		System.out.println("The response content is --- " + responseBody);
		Assert.assertEquals(responseBody.contains("id"), true);

		JsonPath value = response.jsonPath();
		System.out.println("the name is ---- " + value.get("name"));
		System.out.println("the job is ----- " + value.get("job"));
		Assert.assertEquals(value.get("name"), name1);
		Assert.assertEquals(value.get("job"), job1);

		String idvalue = value.get("id");
		System.out.println("Id value is --- " + idvalue);
	}

	@Test
	public void statuscode() {

		int statuscode = response.getStatusCode();
		System.out.println("The statuscode is --- " + statuscode);
		Assert.assertEquals(statuscode, 201);

	}

	@AfterClass
	public void teardown() {

		System.out.println("TC04 Finished..............");

	}

}
