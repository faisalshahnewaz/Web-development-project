package com.form;

import java.util.ArrayList;
import java.util.List;

import org.mybeans.form.FormBean;

public class ChangeEmployeePasswordForm extends FormBean{

	private String newPassword;
	private String confirmPassword;
	
	public String getNewPassword() {
		return newPassword;
	}
	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	
	public List<String> getValidationErrors() {
		
		List<String> errors = new ArrayList<String>();
		
		//check new pass null or empty
		if(newPassword == null || newPassword.length() == 0) {
			errors.add("Insert new password");
		}
		//check confirm pass null or empty
		if(confirmPassword == null || confirmPassword.length() == 0) {
			errors.add("Insert confirm password");
		}
		//check if there is any error
		if(errors.size() > 0) {
			return errors;
		}
		
		//if no error check new and confirm pass match?
		if(!newPassword.equals(confirmPassword)) {
			return errors;
		}
		
		return errors;
		
	}
}