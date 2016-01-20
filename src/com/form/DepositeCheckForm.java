package com.form;

import java.util.ArrayList;
import java.util.List;

import org.mybeans.form.FormBean;

public class DepositeCheckForm extends FormBean {
	private String username;
	private int amount;
	private String action;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getAmount() {
		return amount;
	}

	public void getAmount(int amount) {
		this.amount = amount;
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
		if (username == null || username.trim().length() == 0) {
			errors.add("Username not present");
		}
		if (username.matches(".*[<>\"].*")) {
			errors.add("Username may not contain angle brackets or quotes");
		}
		if ("".equals(Integer.toString(amount))) {
			errors.add("Amount not Present");
		}
		if (Integer.toString(amount).matches(".*[<>\"].*")) {
			errors.add("Amount may not contain angle brackets or quotes");
		}
		if (amount <= 0) {
			errors.add("Amount should be more than zero");
		}
		if (errors.size() > 0) {
			return errors;
		}
		if (!action.equals("DepositeCheck")) {
			errors.add("Invalid Action");
		}
		return errors;

	}

}
