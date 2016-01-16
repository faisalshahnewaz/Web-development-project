package com.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.mybeans.form.FormBeanException;
import org.mybeans.form.FormBeanFactory;

import com.form.ChangeEmployeePasswordForm;
import com.model.EmployeeDAO;
import com.model.Model;

public class ChangeEmployeePasswordAction extends Action{

	private FormBeanFactory<ChangeEmployeePasswordForm> formBeanFactory = FormBeanFactory.getInstance(ChangeEmployeePasswordForm.class);
	private EmployeeDAO employeeDAO;
	
	public ChangeEmployeePasswordAction(Model model) {
		employeeDAO = model.getEmployeeDAO();
	}
	
	
	@Override
	public String getName() {
		return "ChangePasswordAction.do";
	}

	@Override
	public String perform(HttpServletRequest request) {
		
		List<String> errors = new ArrayList<String>(); 
		request.setAttribute("errors", errors);
		
		
		try {
			//load the form params to a form bean
			ChangeEmployeePasswordForm form = formBeanFactory.create(request);
			
			//if no param redirect to change pass jsp (1st time)
			if(!form.isPresent()) {
				return "ChangeCustomerPassword.jsp";
			}
			//check validation errors
			errors.addAll(form.getValidationErrors());
			if(errors.size()>0) {
				return "error.jsp";
			}
			
		} catch (FormBeanException e) {
			errors.add(e.toString());
			return "error.jsp";
		}
		
		
		return null;
	}

	
}
