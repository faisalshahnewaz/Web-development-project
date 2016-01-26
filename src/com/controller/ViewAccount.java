package com.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.genericdao.RollbackException;

import com.databean.CustomerBean;
import com.databean.ViewCustomerAccountBean;
import com.model.CustomerDAO;
import com.model.FundPriceHistoryDAO;
import com.model.Model;


public class ViewAccount extends Action{

	
	private CustomerDAO cDAO;
	private FundPriceHistoryDAO fundPriceHistoryDAO;
	
	public ViewAccount(Model model) {
		cDAO = model.getCustomerDAO();
		fundPriceHistoryDAO = model.getFundPriceHistoryDAO();
	}
	
	@Override
	public String getName() {
		
		return "ViewAccount.do";
	}

	@Override
	public String perform(HttpServletRequest request) {
		List<String> errors = new ArrayList<String>();
		request.setAttribute("errors",errors);
		HttpSession session = request.getSession();
		CustomerBean customer = (CustomerBean) session.getAttribute("customer");
		if(customer == null){
			errors.add("Please login first");
			return "CustomerLogin.do";
		}		
		
		
		try {
			CustomerBean customerBean = (CustomerBean) session.getAttribute("customer");
				
				ViewCustomerAccountBean viewCusBean = new ViewCustomerAccountBean();
				
				//load data to bean
				viewCusBean.setCid(customerBean.getCid());
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
				
				
			String date = fundPriceHistoryDAO.getMaxDate();
			request.setAttribute("customer",viewCusBean);
			request.setAttribute("Date", date);
			return "ViewAccount.jsp";
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "error.jsp";
	}

	
}
