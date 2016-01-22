package com.controller;

import javax.servlet.http.HttpServletRequest;

import com.model.CustomerDAO;
import com.model.Model;

public class ViewCustomerAccountSearchAction extends Action{

	private CustomerDAO cDAO;
	
	public ViewCustomerAccountSearchAction(Model model) {
		cDAO = model.getCustomerDAO();
	}

	@Override
	public String getName() {
		return "ViewCustomerAccountSearch.do";
	}

	@Override
	public String perform(HttpServletRequest request) {
		
		
		
		return "ViewCustomerAccount.jsp";
	}
}
