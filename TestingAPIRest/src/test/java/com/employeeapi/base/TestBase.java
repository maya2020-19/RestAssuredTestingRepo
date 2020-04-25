package com.employeeapi.base;

import java.io.File;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.apache.logging.log4j.core.LoggerContext;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeClass;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TestBase {

	public static RequestSpecification httprequest;
	public static Response response;
	public String empId = "14";

	//public Logger logger;

	//@BeforeClass
//	public void setup() {

		// logger = (Logger) LogManager.getLogger("EmployeeRestAPI");

	//	String fileName = "C:\\Users\\Manikandan A\\eclipse-workspace\\RestTesting\\TestingAPIRest\\log4j.properties";
		//LoggerContext context = (LoggerContext) LogManager.getContext(false);

		//context.setConfigLocation(new File(fileName).toURI());
		//logger = (Logger) LoggerFactory.getLogger(TestBase.class);

		//String logMessage = String.format("Initialized (%s).", fileName);
	//	System.out.println(logMessage);
		//logger.info(logMessage);

	//}

}
