package com.form;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.mybeans.form.FormBean;

public class RequestCheckForm extends FormBean {
//	private String username;
	private String amount;
	private String action;

//	public String getUsername() {
//		return username;
//	}
//
//	public void setUsername(String username) {
//		this.username = username;
//	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
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

		
		System.out.print("Step1:" + amount);
		
		if (amount == null || amount.trim().length() == 0) {
			errors.add("Amount is required");
		}
		
		System.out.print("Step2:" + amount);
		
		if (amount.matches(".*[<>\"].*")) {
			errors.add("Amount may not contain angle brackets or quotes");
		}
		try{
			if (Float.parseFloat(amount) < 0) {
			errors.add("Amount cannot be less than zero");
		}	else if(Float.parseFloat(amount) > 1000000){
			errors.add("Amount cannot be more than $1,000,000");
		}
			}catch(Exception ex){
			errors.add("Please enter a valid amount");
		}
		if (errors.size() > 0) {
			return errors;
		}
//		if (Float.parseFloat(amount) <= 0) {
//			errors.add("Amount should be more than zero");
//		}
		if (!action.equals("RequestCheck")) {
			errors.add("Invalid Action");
		}
		return errors;

	}

}
