package APITesting.com.org.api;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Demo1_GET_Req {

	@Test
	public void GET_Emp() {

		// define the base URI - STEP 1

		RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";

		// what kind of request we are going to send - that is via request specification
		// - (Request object) - STEP 2
		RequestSpecification httprequest = RestAssured.given();

		// RESPONSE Object - STEP 3
		Response resp = httprequest.request(Method.GET, "/employees");

		// print response in console window - STEP 4

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

	}
}
