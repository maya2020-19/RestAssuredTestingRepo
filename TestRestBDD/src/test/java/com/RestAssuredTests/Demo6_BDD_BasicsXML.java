package com.RestAssuredTests;

import org.testng.annotations.Test;

import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class Demo6_BDD_BasicsXML {
	
	@Test
	public void testsinglecontent() {
		given()
		
		.when()
		.get("http://thomas-bayer.com/sqlrest/CUSTOMER/15")
		.then()
		.statusCode(200)
		.body("CUSTOMER.ID", equalTo("15"))
		.log().all();
		
		
		
	}
	
	@Test
	public void testcontent() {
		given()
		
		.when()
		.get("http://thomas-bayer.com/sqlrest/CUSTOMER/15")
		.then()
		.statusCode(200)
		.body("CUSTOMER.text()", equalTo("15BillClancy319 Upland Pl.Seattle"))
		.log().all();
	}

	@Test
	public void testXpath() {
		given()
		
		.when()
		.get("http://thomas-bayer.com/sqlrest/CUSTOMER/15")
		.then()
		.statusCode(200)
		.body(hasXPath("/CUSTOMER/FIRSTNAME",containsString("Bill")))
		.log().all();
	}
	
	@Test
	public void testXpath2() {
		given()
		
		.when()
		.get("http://thomas-bayer.com/sqlrest/INVOICE/")
		.then()
		.statusCode(200)
		.body(hasXPath("/INVOICEList/INVOICE[text()='30']"))
		.log();
	}
	

}
