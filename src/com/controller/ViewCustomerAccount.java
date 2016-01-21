package com.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.genericdao.RollbackException;

import com.databean.CustomerBean;
import com.databean.ViewCustomerAccountBean;
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
		
		/*
		 * 1.get the list of customers from CustomerDAO
		 * 2. create a list of View customer account to hold the objects of view customer acc.bean.
		 * 3. load data from different table to each view cus acc bean.
		 * 4. add the beans to the list.
		 * 5. pass the bean list to jsp.
		 * 6. return the jsp name.
		*/
		CustomerBean[] customerBeans;
		List<ViewCustomerAccountBean> customerList = new ArrayList<ViewCustomerAccountBean>();
		
		try {
			customerBeans = cDAO.getCustomerList();
			
			for(CustomerBean list: customerBeans) {
				
				ViewCustomerAccountBean viewCusBean = new ViewCustomerAccountBean();
				
				//load data to bean
				viewCusBean.setCid(Integer.toString(list.getCid()));
				viewCusBean.setUsername(list.getUsername());
				viewCusBean.setFirstname(list.getFirstname());
				viewCusBean.setLastname(list.getLastname());
				viewCusBean.setAddrline1(list.getAddrline1());
				viewCusBean.setAddrline2(list.getAddrline2());
				viewCusBean.setCity(list.getCity());
				viewCusBean.setState(list.getState());
				viewCusBean.setZip(list.getZip());
				viewCusBean.setCash(list.getCash());
				
				//other data load
				
				System.out.println("User Name:" + list.getUsername());				
				
				//add the bean to the List
				customerList.add(viewCusBean);
			}
			
			request.setAttribute("customerList",customerList);
			
			
			
			
			System.out.println(customerBeans[0].getUsername());
			
		} catch (RollbackException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "EmployeeLoginSuccess.jsp";
	}

	
}
