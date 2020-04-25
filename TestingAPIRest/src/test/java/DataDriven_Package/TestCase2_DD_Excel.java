package DataDriven_Package;

import java.io.IOException;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TestCase2_DD_Excel {

	@Test(dataProvider = "empdataproviderexcel")
	void postAddEmployees(String ename, String esal, String eage) {

		RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";

		RequestSpecification httpRequest = RestAssured.given();

		// Request Payload to be sent

		JSONObject requestparams = new JSONObject();

		requestparams.put("name", ename);
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
		Assert.assertEquals(statuscode, 200);
	}

	@DataProvider(name = "empdataproviderexcel")
	String[][] getEmpData() throws IOException 
	
	{

		String path = System.getProperty("user.dir") + "//src//test//java//DataDriven_Package//Dataexcel.xlsx";
		
		int rownum = XLUtils.getRowCount(path, "Sheet1");
		int colcount = XLUtils.getCellCount(path, "Sheet1", 1);

		String empdata[][] = new String[rownum][colcount];
		for (int i = 1; i <= rownum; i++) {
			for (int j = 0; j < colcount; j++) {

				empdata[i - 1][j] = XLUtils.getCellData(path, "Sheet1", i, j);
			}

		}

		return (empdata);

	}

}
