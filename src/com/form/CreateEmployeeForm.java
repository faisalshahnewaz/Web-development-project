/**
 * Name: Tanay Pahare
 * Date: 12/15/2015
 * Course Number: 08672
 */

package com.form;

import java.util.ArrayList;
import java.util.List;

import org.mybeans.form.FormBean;

//Form to store and validate the entries in register.jsp
public class CreateEmployeeForm extends FormBean {
	private String firstname;
	private String lastname;
	private String username;
	private String password;
	private String confirm;
	//private String action;

	public String getFirstname() {
		return firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public String getConfirm() {
		return confirm;
	}

	//public String getAction() {
		//return action;
	//}

	public void setFirstname(String s) {
		firstname = trimAndConvert(s, "<>\"");
	}

	public void setLastname(String s) {
		lastname = trimAndConvert(s, "<>\"");
	}

	public void setUsername(String s) {
		username = trimAndConvert(s, "<>\"");
	}

	public void setPassword(String s) {
		password = s.trim();
	}

	public void setConfirm(String s) {
		confirm = s.trim();
	}

	//public void setAction(String s) {
		//confirm = s.trim();
	//}

	public List<String> getValidationErrors() {
		List<String> errors = new ArrayList<String>();

		if (firstname == null || firstname.length() == 0) {
			errors.add("First Name is required");
		}

		if (lastname == null || lastname.length() == 0) {
			errors.add("Last Name is required");
		}

		if (username == null || username.length() == 0) {
			errors.add("Username is required");
		}

		if (password == null || password.length() == 0) {
			errors.add("Password is required");
		}

		if (confirm == null || confirm.length() == 0) {
			errors.add("Confirm Password is required");
		}

		//if (action == null) {
			//errors.add("No action");
		//}
		if (errors.size() > 0) {
			return errors;
		}

		if (!password.equals(confirm)) {
			errors.add("Passwords are not the same");
		}
		//if (!action.equals("Create")) {
			//errors.add("Invalid button");
		//}
		return errors;
	}
}
