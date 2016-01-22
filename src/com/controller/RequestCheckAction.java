package com.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.genericdao.MatchArg;
import org.genericdao.RollbackException;
import org.mybeans.form.FormBeanException;
import org.mybeans.form.FormBeanFactory;

import com.databean.CustomerBean;
import com.databean.TransactionBean;
import com.form.DepositeCheckForm;
import com.form.RequestCheckForm;
import com.model.CustomerDAO;
import com.model.Model;
import com.model.TrancDAO;

public class RequestCheckAction extends Action {
	private FormBeanFactory<RequestCheckForm> formBeanFactory = FormBeanFactory.getInstance(RequestCheckForm.class);
	CustomerDAO customerDAO;
	TrancDAO trancDAO;
	public RequestCheckAction(Model model) {
		this.customerDAO = model.getCustomerDAO();
		this.trancDAO = model.getTrancDAO();
	}
	@Override
	public String getName() {
		return "RequestCheck.do";
	}

	@Override
	public String perform(HttpServletRequest request) {
		HttpSession session = request.getSession();
		
		List<String> errors = new ArrayList<String>();
		request.setAttribute("errors", errors);
		try{
			RequestCheckForm form = formBeanFactory.create(request);
			request.setAttribute("form",form);
			
//			int depositcheckcid = Integer.parseInt(request.getParameter("depositcheckcid"));
//	        request.setAttribute("depositcheckcid", depositcheckcid);
			
			if(!form.isPresent()){
				return "RequestCheck.jsp";
			}
			
//			System.out.print("Username here:" + form.getUsername());
//			System.out.print("Amount here:" + form.getAmount());
			System.out.print("Deposit Check look 1");
			
			
			errors.addAll(form.getValidationErrors());
			
			if(errors.size()!=0){
				return "RequestCheck.jsp";
			}
			
			
//			CustomerBean[] customer = customerDAO.match(MatchArg.equals("username", form.getUsername()));
//			if(customer.length == 0){
//				errors.add("Username does not exist");
//				return "DepositCheck.jsp";
//			}
			
			
			//System.out.println("hh");
			
			CustomerBean customer = (CustomerBean) session.getAttribute("customer");
			
			TransactionBean tBean = new TransactionBean();
			tBean.setCid(customer.getCid());
			tBean.setTransactiontype("request");
			
			long depositmoney = (long) (1000 * Double.parseDouble(form.getAmount()));
			
			tBean.setAmount(depositmoney);
			
			trancDAO.create(tBean);
			
			System.out.print("look 5");
			
			return "RequestCheckSuccess.jsp";
		}catch (RollbackException e) {
        	errors.add(e.getMessage());
        	return "error.jsp";
        } catch (FormBeanException e) {
        	errors.add(e.getMessage());
        	return "error.jsp";
        }
		
		
	}

}
