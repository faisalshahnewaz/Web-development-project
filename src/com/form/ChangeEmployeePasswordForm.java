package com.form;

import java.util.ArrayList;
import java.util.List;

import org.mybeans.form.FormBean;

public class ChangeEmployeePasswordForm extends FormBean {
	private String oldPassword;
	private String newPassword;
	private String confirmPassword;
	private String action;

	public String getOldPassword() {
		return oldPassword;
	}

	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}

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
	
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	
	public List<String> getValidationErrors(){
		List<String> errors = new ArrayList<String>();
		
		if(oldPassword == null||oldPassword.length() == 0){
			errors.add("Please enter the old password");
		}
		
		if(newPassword == null || newPassword.length() == 0){
			errors.add("Please enter the new password");
		}
		
		if(confirmPassword == null || confirmPassword.length() == 0){
			errors.add("Please add the confirmed password");
		}
		
		if(errors.size() > 0){
			return errors;
		}
		
		if(!newPassword.equals(confirmPassword)){
        	errors.add("Passwords don't match");
        }
		if (newPassword.equals(oldPassword)) {
			errors.add("New Password is same to the old one");
		}
		if(action == null || !action.equals("Change")){
			errors.add("Invalid action");
		}
		
		if(oldPassword.matches(".*[<>\"].*")){
			errors.add("Old Password cannot contain angular brackets or quotes");
		}
		
		if(newPassword.matches(".*[<>\"].*")){
			errors.add("New Password cannot contain angular brackets or quotes");
		}
		
		if(confirmPassword.matches(".*[<>\"].*")){
			errors.add("Confirm Password cannot contain angular brackets or quotes");
		}
		
		return errors;
	}
}