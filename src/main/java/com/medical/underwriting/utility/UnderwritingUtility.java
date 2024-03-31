package com.medical.underwriting.utility;

import java.util.UUID;

import org.springframework.stereotype.Component;

@Component
public class UnderwritingUtility {

	/**
	 * This method is used to return the generated UUID
	 * @return : the generated UUID
	 */
	
	public String generateUUID() {
		return UUID.randomUUID().toString();
	}
	
}
