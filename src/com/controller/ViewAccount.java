package com.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.genericdao.RollbackException;

import com.databean.CustomerBean;
import com.databean.ViewCustomerAccountBean;
import com.model.CustomerDAO;
import com.model.Model;


public class ViewAccount extends Action{

	
	private CustomerDAO cDAO;
	
	public ViewAccount(Model model) {
		cDAO = model.getCustomerDAO();
	}
	
	@Override
	public String getName() {
		
		return "ViewAccount.do";
	}

	@Override
	public String perform(HttpServletRequest request) {
		HttpSession session = request.getSession();
		
		List<String> errors = new ArrayList<String>();
		request.setAttribute("errors",errors);
		
		System.out.println("aaaa");
		
		
		try {
			CustomerBean customerBean = (CustomerBean) session.getAttribute("customer");
				
				ViewCustomerAccountBean viewCusBean = new ViewCustomerAccountBean();
				
				//load data to bean
				viewCusBean.setCid(Integer.toString(customerBean.getCid()));
				viewCusBean.setUsername(customerBean.getUsername());
				viewCusBean.setFirstname(customerBean.getFirstname());
				viewCusBean.setLastname(customerBean.getLastname());
				viewCusBean.setAddrline1(customerBean.getAddrline1());
				viewCusBean.setAddrline2(customerBean.getAddrline2());
				viewCusBean.setCity(customerBean.getCity());
				viewCusBean.setState(customerBean.getState());
				viewCusBean.setZip(customerBean.getZip());
				viewCusBean.setCash(customerBean.getCash());
				
				//other data load
				
				System.out.println("User Name:" + customerBean.getUsername());				
				
				//add the bean to the List

			
			request.setAttribute("customer",viewCusBean);
			
			return "ViewAccount.jsp";
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "error.jsp";
	}

	
}
