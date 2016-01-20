package com.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.genericdao.RollbackException;

import com.databean.CustomerBean;
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
		
		System.out.println("aaaa");
		
		//1.Check if any customer account? 2. get them in a list 3.reload to bean each one and  
		
		CustomerBean[] customerList;
		try {
			customerList = cDAO.getCustomerList();
			
			for(CustomerBean list: customerList) {
				System.out.println("User Name:" + list.getUsername());
//				System.out.println("First Name:" + list.getFirstname());
//				System.out.println("Last Name:" + list.getLastname());
//				System.out.println("Address line1:" + list.getAddrline1());
//				System.out.println("Address line2:" + list.getAddrline2());
//				System.out.println("Cash:" + list.getCash());
			}
			
		} catch (RollbackException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "EmployeeLoginSuccess.jsp";
	}

	
}
