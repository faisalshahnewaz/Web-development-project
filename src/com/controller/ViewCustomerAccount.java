package com.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.model.CustomerDAO;
import com.model.Model;


public class ViewCustomerAccount extends Action{

	private CustomerDAO cDAO;
	
	public ViewCustomerAccount(Model model) {
		cDAO = model.getCustomerDAO();
	}
	@Override
	public String getName() {
		
		return "ViewCustomerAccount.do";
	}

	@Override
	public String perform(HttpServletRequest request) {
		
		List<String> errors = new ArrayList<String>();
		request.setAttribute("errors",errors);
		
		//1.Check if any customer account? 2. get them in a list 3.reload to bean each one and  
		
		return null;
	}

	
}
