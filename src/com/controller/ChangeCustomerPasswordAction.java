package com.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpSession;

import org.genericdao.MatchArg;
import org.genericdao.RollbackException;
import org.mybeans.form.FormBeanException;
import org.mybeans.form.FormBeanFactory;

import com.databean.CustomerBean;
import com.form.ChangeCustomerPasswordForm;
///import com.form.LoginForm;
import com.model.CustomerDAO;
import com.model.Model;

public class ChangeCustomerPasswordAction extends Action{
	private FormBeanFactory<ChangeCustomerPasswordForm> formBeanFactory = FormBeanFactory.getInstance(ChangeCustomerPasswordForm.class);
	private CustomerDAO cDAO;
	
	public ChangeCustomerPasswordAction(Model model) {
		// TODO Auto-generated constructor stub
		cDAO = model.getCustomerDAO();
	}
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "ChangeCustomerPassword.do";
	}

	@Override
	public String perform(HttpServletRequest request) {
		// TODO Auto-generated method stub
		//HttpSession session = request.getSession();
	
		/*if (session.getAttribute("employee") != null) {
        	return "ChangeCustomerPassword.jsp";
        }*/
		List<String> errors = new ArrayList<String>();
        request.setAttribute("errors",errors);
        try {
	    	ChangeCustomerPasswordForm form = formBeanFactory.create(request);
	        request.setAttribute("form",form);

	        // If no params were passed, return with no errors so that the form will be
	        // presented (we assume for the first time).
	        if (!form.isPresent()) {
	            return "ChangeCustomerPassword.jsp";
	        }

	        // Any validation errors?
	        errors.addAll(form.getValidationErrors());
	        if (errors.size() != 0) {
	            return "ChangeCustomerPassword.jsp";
	        }

       		

	        // Look up the user
	        //User user = userDAO.read(form.getUserName());
	        CustomerBean[] customer = cDAO.match(MatchArg.equals("username",form.getUsername()));
	        
	        if (customer.length == 0) {
	            errors.add("Name not found");
	            return "ChangeCustomerPassword.jsp";
	        }

	        // Check the password
	        if (!customer[0].getPassword().equals(form.getOldPassword())) {
	            errors.add("Incorrect password");
	            return "ChangeCustomerPassword.jsp";
	        }
	
	        // Attach (this copy of) the user bean to the session
	        cDAO.changePassword(customer[0].getUsername(), form.getNewPassword());
	     //   message = "Password Changed successfully";
	  //      request.setAttribute("message", message);
	        // If redirectTo is null, redirect to the "todolist" action
			return "ChangeCusPwdSuccess.jsp";
        } catch (RollbackException e) {
        	errors.add(e.getMessage());
        	return "error.jsp";
        } catch (FormBeanException e) {
        	errors.add(e.getMessage());
        	return "error.jsp";
        }
	}
}
