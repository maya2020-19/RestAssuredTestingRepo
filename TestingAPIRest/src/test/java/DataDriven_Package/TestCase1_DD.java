package DataDriven_Package;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TestCase1_DD {

@Test
	
	public void postNewEmp() {
		
		RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";
		
		RequestSpecification httpRequest = RestAssured.given();
		
		//Request Payload to be sent
		
		JSONObject requestparams = new JSONObject();
	
		requestparams.put("name", "abji");
		requestparams.put("salary", "40000");
		requestparams.put("age", "27");
		
		httpRequest.header("Content-Type","application/json");
		httpRequest.body(requestparams.toJSONString());
		
		Response resp = httpRequest.request(Method.POST, "/create");
		
		String respbody = resp.getBody().asString();
		System.out.print(respbody);
		Assert.assertEquals(respbody.contains("abji"), true);
		Assert.assertEquals(respbody.contains("40000"), true);
		Assert.assertEquals(respbody.contains("27"), true);

		// status code validation

		int statuscode = resp.getStatusCode();
		System.out.println("The status code is " + statuscode);
		Assert.assertEquals(statuscode, 200);
}
	
}
