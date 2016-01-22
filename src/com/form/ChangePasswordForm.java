package com.form;

import java.util.ArrayList;
import java.util.List;

import org.mybeans.form.FormBean;

public class ChangePasswordForm extends FormBean {
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
	public void setConfirmPassowrd(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}

	public boolean isPresent() {
        return action != null;
    }
	
	public List<String> getValidationErrors() {
		
		List<String> errors = new ArrayList<String>();
		
		//check confirm pass null or empty
		if(oldPassword == null || oldPassword.length() == 0) {
			errors.add("Insert old password");
		}
		//check new pass null or empty
		if(newPassword == null || newPassword.length() == 0) {
			errors.add("Insert new password");
		}
		
		System.out.println("Change Password:" + oldPassword + newPassword + confirmPassword);
		
		if(confirmPassword == null || confirmPassword.length() == 0) {
			errors.add("Insert confirm password");
		}
		if(newPassword != null && confirmPassword != null && newPassword != confirmPassword) {
			errors.add("New passwords do not match");
		}
		//action check
		if(action == null) {
			errors.add("no action");
		}
		//check if there is any error
		if(errors.size() > 0) {
			return errors;
		}
		
		if(!action.equals("Change")) {
			errors.add("invalid button");
		}
		
		return errors;
		
	}
}
