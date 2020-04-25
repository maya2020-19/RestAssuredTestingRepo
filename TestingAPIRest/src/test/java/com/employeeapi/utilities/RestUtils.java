package com.employeeapi.utilities;

import org.apache.commons.lang3.RandomStringUtils;


public class RestUtils {

	public static String empname() {
		
		String generatestring = RandomStringUtils.randomAlphabetic(1);
		return("Jos"+generatestring);
	}
	
	public static String empsal() {
		String generatestring = RandomStringUtils.randomNumeric(5);
		return(generatestring);
		
	}
	
	
	public static String empage() {
		String generatestring = RandomStringUtils.randomNumeric(2);
		return(generatestring);
		
	}
}


