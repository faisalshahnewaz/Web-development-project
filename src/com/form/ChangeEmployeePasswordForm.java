package com.form;

import java.util.ArrayList;
import java.util.List;

import org.mybeans.form.FormBean;

public class ChangeEmployeePasswordForm extends FormBean{

	private String username;
    private String oldPassword;
    private String newPassword;
    private String action;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
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
		
		//check user name
		if(username == null || username.length()==0) {
			
		}
		//check confirm pass null or empty
		if(oldPassword == null || oldPassword.length() == 0) {
			errors.add("Insert old password");
		}
		//check new pass null or empty
		if(newPassword == null || newPassword.length() == 0) {
			errors.add("Insert new password");
		}
		//action check
		if(action == null) {
			errors.add("no action");
		}
		//check if there is any error
		if(errors.size() > 0) {
			return errors;
		}
		
		if(action.equals("Change")) {
			errors.add("invalid button");
		}
		
		return errors;
		
	}
}