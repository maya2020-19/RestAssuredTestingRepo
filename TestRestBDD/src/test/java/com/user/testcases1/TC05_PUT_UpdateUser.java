package com.user.testcases1;

import org.json.simple.JSONObject;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.user.testbase1.TestBase1;
import com.user.utilities1.RestUtil;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import junit.framework.Assert;

public class TC05_PUT_UpdateUser extends TestBase1 {

	String name1 = RestUtil.Username();
	String job1 = RestUtil.UserJob();

	@BeforeClass
	public void update_user() {

		System.out.println("TC05 Started..............");
		RestAssured.baseURI = "https://reqres.in";
		httpRequest = RestAssured.given();

		JSONObject reqparam = new JSONObject();

		reqparam.put("name", name1);
		reqparam.put("job", job1);

		httpRequest.header("Content-Type", "application/json");
		httpRequest.body(reqparam.toJSONString());

		response = httpRequest.request(Method.PUT, "/api/users/" + user);

	}

	@Test
	public void validate_response() {

		String responseBody = response.getBody().asString();
		System.out.println("The response content is --- " + responseBody);
		Assert.assertEquals(responseBody.contains("updatedAt"), true);

		JsonPath value = response.jsonPath();
		System.out.println("the name is ---- " + value.get("name"));
		System.out.println("the job is ----- " + value.get("job"));
		Assert.assertEquals(value.get("name"), name1);
		Assert.assertEquals(value.get("job"), job1);

		String upadtedAt = value.get("updatedAt");
		System.out.println("Id value is --- " + upadtedAt);

	}

	@Test
	public void validate_status() {

		int statuscode = response.getStatusCode();
		System.out.println("The statuscode is --- " + statuscode);
		Assert.assertEquals(statuscode, 200);
	}

	@AfterClass
	public void teardown() {

		System.out.println("TC05 Finished..............");

	}

}
