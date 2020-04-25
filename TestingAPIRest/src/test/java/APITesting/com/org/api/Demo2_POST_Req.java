package APITesting.com.org.api;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Demo2_POST_Req {

	@Test
	
	public void POST_Method() {
		
		RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";
		
		RequestSpecification httpRequest = RestAssured.given();
		
		//Request Payload to be sent
		
		JSONObject requestparams = new JSONObject();
	
		requestparams.put("name", "testone");
		requestparams.put("salary", 10000);
		requestparams.put("age", 27);
		//requestparams.put("id", 002);
		
		httpRequest.header("Content-Type","application/json");
		httpRequest.body(requestparams.toJSONString());
		
		Response resp = httpRequest.request(Method.POST, "/create");
		
		String respbody = resp.getBody().asString();
		System.out.print(respbody);

		// status code validation

		int statuscode = resp.getStatusCode();
		System.out.println("The status code is " + statuscode);
		Assert.assertEquals(statuscode, 200);
		
		// status line validation
		
		String statusline = resp.getStatusLine();
		System.out.println("The status Line is " + statusline);
		Assert.assertEquals(statusline, "HTTP/1.1 200 OK");
		
		String successstatus= resp.jsonPath().get("status");
		System.out.println("The content is " + successstatus);
		Assert.assertEquals(successstatus, "success");
		
		
		
	}
	
	
}
