package com.RestAssuredTests;

import org.apache.commons.lang3.RandomStringUtils;

public class Restapis {
	
public static String setname() {
		
		String generatestring = RandomStringUtils.randomAlphabetic(3);
		return("John" + generatestring);
	}
	
	public static String setjob() {
		String generatestring = RandomStringUtils.randomNumeric(3);
		return("Leader" + generatestring);
		
	}
	
}
