package com.controller;

import java.util.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.genericdao.DuplicateKeyException;
import org.genericdao.RollbackException;
import org.mybeans.form.FormBeanException;
import org.mybeans.form.FormBeanFactory;
import com.form.*;
import com.model.*;

//import edu.cmu.cs.webapp.todolist8.databean.User;
//import edu.cmu.cs.webapp.todolist8.formbean.LoginForm;

//import edu.cmu.cs.webapp.todolist8.formbean.LoginForm;

import com.databean.*;

public class CustomerLoginAction extends Action {
	private FormBeanFactory<LoginForm> formBeanFactory = FormBeanFactory.getInstance(LoginForm.class);
	
	private CustomerDAO cDAO;
	public  CustomerLoginAction(Model model) {
		cDAO = model.getCustomerDAO();
	}
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "Login.do";
	}

	@Override
	public String perform(HttpServletRequest request) {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		if (session.getAttribute("customer") != null) {
        	return "success.jsp";
        }
		List<String> errors = new ArrayList<String>();
        request.setAttribute("errors",errors);
        try {
	    	LoginForm form = formBeanFactory.create(request);
	        request.setAttribute("form",form);

	        // If no params were passed, return with no errors so that the form will be
	        // presented (we assume for the first time).
	        if (!form.isPresent()) {
	            return "login.jsp";
	        }

	        // Any validation errors?
	        errors.addAll(form.getValidationErrors());
	        if (errors.size() != 0) {
	            return "login.jsp";
	        }

       		

	        // Look up the user
	        //User user = userDAO.read(form.getUserName());
	        CustomerBean customer = cDAO.read(form.getUsername());
	        
	        if (customer == null) {
	            errors.add("Name not found");
	            return "login.jsp";
	        }

	        // Check the password
	        if (!customer.getPassword().equals(form.getPassword())) {
	            errors.add("Incorrect password");
	            return "login.jsp";
	        }
	
	        // Attach (this copy of) the user bean to the session
	        session.setAttribute("customer",customer);
	        
	        // If redirectTo is null, redirect to the "todolist" action
			return "success.jsp";
        } catch (RollbackException e) {
        	errors.add(e.getMessage());
        	return "error.jsp";
        } catch (FormBeanException e) {
        	errors.add(e.getMessage());
        	return "error.jsp";
        }
	}
}
