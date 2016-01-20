package com.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.genericdao.MatchArg;
import org.genericdao.RollbackException;
import org.mybeans.form.FormBeanException;
import org.mybeans.form.FormBeanFactory;

import com.databean.CustomerBean;
import com.form.DepositeCheckForm;
import com.model.CustomerDAO;
import com.model.Model;

public class DepositeCheckAction extends Action {
	private FormBeanFactory<DepositeCheckForm> formBeanFactory = FormBeanFactory.getInstance(DepositeCheckForm.class);
	CustomerDAO customerDAO;
	public DepositeCheckAction(Model model) {
		this.customerDAO = model.getCustomerDAO();
	}
	@Override
	public String getName() {
		return "DepositCheck.do";
	}

	@Override
	public String perform(HttpServletRequest request) {
		System.out.println("jjj");
		List<String> errors = new ArrayList<String>();
		request.setAttribute("errors", errors);
		try{
			DepositeCheckForm form = formBeanFactory.create(request);
			request.setAttribute("form",form);
			
			if(!form.isPresent()){
				return "DepositCheck.jsp";
			}
			
			System.out.print("Username here:" + form.getUsername());
			System.out.print("Amount here:" + form.getAmount());
			System.out.print("look 1");
			
			
			errors.addAll(form.getValidationErrors());
			
			if(errors.size()!=0){
				return "DepositCheck.jsp";
			}
			
			System.out.print("look 2");
			
			CustomerBean[] customer = customerDAO.match(MatchArg.equals("username", form.getUsername()));
			if(customer.length == 0){
				errors.add("Username does not exist");
				return "DepositCheck.jsp";
			}
			
			System.out.print("look 3");
			
			//System.out.println("hh");
			customer[0].setCash(form.getAmount());
			
			System.out.print("look 4");
			
			customerDAO.update(customer[0]);
			
			System.out.print("look 5");
			
			return "CreateFundSuccess.jsp";
		}catch (RollbackException e) {
        	errors.add(e.getMessage());
        	return "error.jsp";
        } catch (FormBeanException e) {
        	errors.add(e.getMessage());
        	return "error.jsp";
        }
		
		
	}

}
