package com.user.testcases1;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.user.testbase1.TestBase1;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import junit.framework.Assert;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class TC02_GET_SingleUser extends TestBase1{

	@BeforeClass
	public void Get_An_user() {
		
		System.out.println("TC02 Started........");
		
		RestAssured.baseURI = "https://reqres.in";
		httpRequest = RestAssured.given();
		response = httpRequest.request(Method.GET,"/api/user/" +usr);
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	

	}

	@Test (priority=1)
	public void validate_reponsebody() {
		String responseBody= response.getBody().asString();
		System.out.println("The response is ---- " + responseBody);
		int SC = response.getStatusCode();
		Assert.assertEquals(SC, 200);
	}
	
	@Test (priority=2)
	public void validate_ResponseTime() {
		
	long time	= response.getTime();
	System.out.println("Response Time is ---- " + time);
	 if(time > 3000) {
		 System.out.println("Resp time is greater....");
		 Assert.assertEquals(time<3000, true);
	 }
	
	}
	
	@AfterClass
	public void teardown() {
		
		System.out.println("TC02 Finished........");
	}
}
