package com.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.genericdao.MatchArg;
import org.genericdao.RollbackException;

import com.databean.CustomerBean;
import com.databean.TransactionBean;
import com.databean.ViewCustomerAccountBean;
import com.model.CustomerDAO;
import com.model.Model;
import com.model.TrancDAO;


public class ViewSelfTransactionHistory extends Action{

	
	private CustomerDAO cDAO;
	private TrancDAO tDAO;
	
	public ViewSelfTransactionHistory(Model model) {
		cDAO = model.getCustomerDAO();
		tDAO = model.getTrancDAO();
	}
	
	@Override
	public String getName() {
		
		return "ViewSelfTransactionHistory.do";
	}

	@Override
	public String perform(HttpServletRequest request) {
		
		List<String> errors = new ArrayList<String>();
		request.setAttribute("errors",errors);
		
		System.out.println("aaaa");
		
		
		try {
		
			TransactionBean[] transactionBeans = tDAO.match(MatchArg.equals("cid", Integer.parseInt(request.getParameter("viewselftransactionhistorycid"))));
			
			request.setAttribute("transactions",transactionBeans);
			
//			System.out.println(customerBeans[0].getUsername());
			
			return "ViewSelfTransactionHistory.jsp";
			
			
		} catch (RollbackException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "error.jsp";
		}
	}

	
}
