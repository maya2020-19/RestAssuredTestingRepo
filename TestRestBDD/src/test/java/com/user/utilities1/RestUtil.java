package com.user.utilities1;

import org.apache.commons.lang3.RandomStringUtils;

public class RestUtil {
	
	
	public static String Username() {
		
		String generatestring = RandomStringUtils.randomAlphabetic(2);
		return("Jos"+generatestring);
	}
	
	public static String UserJob() {
		
		String generatestring = RandomStringUtils.randomAlphabetic(2);
		return("Josy"+generatestring);
	}

}
