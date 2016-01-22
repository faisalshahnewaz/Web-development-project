package com.form;

/**
 * @author faisalshahnewaz.
 */

import java.util.ArrayList;
import java.util.List;

public class ViewCustomerAccountSearchForm {

	private String username;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	public List<String> getValidationErrors() {
		
		List<String> errors = new ArrayList<String>();
		
		if (username == null || username.length() == 0)
			errors.add("Customer name required");
		
		//sanitization check
		if (username.matches(".*[<>\"].*"))
			errors.add("invalid customer name");
		
		return errors;
	}
}
