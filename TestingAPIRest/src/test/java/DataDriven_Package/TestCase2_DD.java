package DataDriven_Package;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TestCase2_DD {

	@Test(dataProvider ="empdataprovider")
	public void postAddEmps(String ename, String esal, String eage) {

		RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";

		RequestSpecification httpRequest = RestAssured.given();

		// Request Payload to be sent

		JSONObject requestparams = new JSONObject();

		requestparams.put("name",ename);
		requestparams.put("salary", esal);
		requestparams.put("age", eage);

		httpRequest.header("Content-Type", "application/json");
		httpRequest.body(requestparams.toJSONString());

		Response resp = httpRequest.request(Method.POST, "/create");

		String respbody = resp.getBody().asString();
		System.out.print("Response body is: " + respbody);
		Assert.assertEquals(respbody.contains(ename), true);
		Assert.assertEquals(respbody.contains(esal), true);
		Assert.assertEquals(respbody.contains(eage), true);

		// status code validation

		int statuscode = resp.getStatusCode();
		System.out.println("The status code is " + statuscode);
		Assert.assertEquals(statuscode, 200);
	}

	@DataProvider(name = "empdataprovider")
	String[][] getEmpData() {

		String empdata[][] = { { "dfg123", "30000", "25" }, { "dfg124", "3000", "25" }, { "dfg125", "35000", "29" } };
		return (empdata);

	}

}
