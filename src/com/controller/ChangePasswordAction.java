package com.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.genericdao.MatchArg;
import org.genericdao.RollbackException;
import org.mybeans.form.FormBeanException;
import org.mybeans.form.FormBeanFactory;

import com.databean.CustomerBean;
import com.form.ChangePasswordForm;
import com.model.CustomerDAO;
import com.model.Model;

public class ChangePasswordAction extends Action {
	private FormBeanFactory<ChangePasswordForm> formBeanFactory = FormBeanFactory.getInstance(ChangePasswordForm.class);
	private CustomerDAO customerDAO;
	
	public ChangePasswordAction(Model model) {
		customerDAO = model.getCustomerDAO();
	}
	
	@Override
	public String getName() {
		return "ChangePassword.do";
	}
	@Override
	public String perform(HttpServletRequest request) {
		
		List<String> errors = new ArrayList<String>(); 
		request.setAttribute("errors", errors);
		
		
		try {
			//load the form params to a form bean
			ChangePasswordForm form = formBeanFactory.create(request);
			request.setAttribute("form", form);
			
			//if no param redirect to change pass jsp (1st time)
			if(!form.isPresent()) {
				return "ChangePassword.jsp";
			}
			//check validation errors
			errors.addAll(form.getValidationErrors());
			if(errors.size()>0) {
				return "ChangePassword.jsp";
			}
			
			//look up the employee and check is this the right employee
			CustomerBean[] customer = customerDAO.match(MatchArg.equals("username", form.getUserName()));
			if(customer.length == 0) {
				errors.add("No user name found");
				return "ChangePassword.jsp";
			}
			
			//check old password field matches?
			if(!customer[0].getPassword().equals(form.getOldPassword())) {
				errors.add("Old password does not match");
				return "ChangePassword.jsp";
			}
			
			//if no error then,
			customerDAO.changePassword(customer[0].getUsername(), form.getNewPassword());
			
			return "ChangePwdSuccess.jsp";
			
		} catch (FormBeanException e) {
			errors.add(e.toString());
			return "ChangePassword.jsp";
		} catch (RollbackException e1) {
			errors.add(e1.toString());
			return "ChangePassword.jsp";
		}
	}
}
