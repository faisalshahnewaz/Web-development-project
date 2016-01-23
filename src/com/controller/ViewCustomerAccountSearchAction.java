package com.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.genericdao.RollbackException;
import org.mybeans.form.FormBeanException;
import org.mybeans.form.FormBeanFactory;

import com.databean.CustomerBean;
import com.databean.ViewCustomerAccountBean;
import com.form.ChangeCustomerPasswordForm;
import com.form.ViewCustomerAccountSearchForm;
import com.model.CustomerDAO;
import com.model.Model;

public class ViewCustomerAccountSearchAction extends Action{

	private FormBeanFactory<ViewCustomerAccountSearchForm> formBeanFactory = FormBeanFactory.getInstance(ViewCustomerAccountSearchForm.class);
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
		
		List<String> errors = new ArrayList<String>();
        request.setAttribute("errors",errors);
        
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
			
			ViewCustomerAccountSearchForm form = formBeanFactory.create(request);
	        request.setAttribute("form",form);
			
			customerBeans = cDAO.getCustomerListbySearch(form.getUsername());
			request.setAttribute("customerList",customerList);
			
			if (customerBeans.length>0) {
				for(CustomerBean customerBean: customerBeans) {
					
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
					customerList.add(viewCusBean);
				}				
				
				System.out.println(customerBeans[0].getUsername());
			}
			
			return "ViewCustomerAccount.jsp";
			
		} catch (RollbackException e) {
			errors.add(e.getMessage());
		} catch (FormBeanException e) {
			errors.add(e.getMessage());
		}
		
		return "error.jsp";
	}
}
