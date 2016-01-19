package com.controller;

/**
 * @author faisalshahnewaz.
 */

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;




import org.genericdao.MatchArg;
import org.genericdao.RollbackException;
import org.mybeans.form.FormBeanException;
import org.mybeans.form.FormBeanFactory;
import org.mybeans.form.FormBeanFactoryException;

import com.form.CreateCustomerForm;
import com.form.CreateEmployeeForm;
import com.model.CustomerDAO;
import com.model.Model;

public class CreateCustomerAction extends Action{

	private FormBeanFactory<CreateCustomerForm> formBeanFactory = FormBeanFactory.getInstance(CreateCustomerForm.class);
	private CustomerDAO cDAO;
	//constructor
	public CreateCustomerAction(Model model) {
		cDAO = model.getCustomerDAO();
	}
	
	@Override
	public String getName() {
		
		return "CreateCustomer.do";
	}

	/*
	 * 
	 */
	@Override
	public String perform(HttpServletRequest request) {
		
		List<String> errors = new ArrayList<String>();
		request.setAttribute("errors", errors);
		
		
		try {
			
			//create a form to get data from front end.
			CreateCustomerForm form = formBeanFactory.create(request);
			request.setAttribute("form", form);
			
			//check if there is any data? if none then its 1st time, then load the page.
			
			return null;
		} catch (FormBeanException e) {
			
			errors.add(e.getMessage());
			return "error.jsp";
		}
		
	}
	
	
}
