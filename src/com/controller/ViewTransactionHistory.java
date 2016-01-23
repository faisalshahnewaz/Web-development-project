package com.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.genericdao.MatchArg;
import org.genericdao.RollbackException;

import com.databean.CustomerBean;
import com.databean.FundBean;
import com.databean.TransactionBean;
import com.databean.ViewCustomerAccountBean;
import com.databean.ViewTransactionBean;
import com.model.CustomerDAO;
import com.model.FundDAO;
import com.model.Model;
import com.model.TrancDAO;


public class ViewTransactionHistory extends Action{

	
	private CustomerDAO cDAO;
	private TrancDAO tDAO;
	private FundDAO fDAO;
	
	public ViewTransactionHistory(Model model) {
		cDAO = model.getCustomerDAO();
		tDAO = model.getTrancDAO();
		fDAO = model.getFundDAO();
	}
	
	@Override
	public String getName() {
		
		return "ViewTransactionHistory.do";
	}

	@Override
	public String perform(HttpServletRequest request) {
		
		List<String> errors = new ArrayList<String>();
		request.setAttribute("errors",errors);
		
		List<ViewTransactionBean> transactions = new ArrayList<ViewTransactionBean>();
		
		
		try {
		
			TransactionBean[] transactionBeans = tDAO.match(MatchArg.equals("cid", Integer.parseInt(request.getParameter("viewtransactionhistorycid"))));
						
			
			for (int i = 0; i < transactionBeans.length; i++) {
				
				System.out.println("FundName:" + transactionBeans[i].getFundid());
				
				ViewTransactionBean viewTransaction = new ViewTransactionBean();
				
				System.out.println(transactionBeans[i].getFundid() != 0);
				
				if(transactionBeans[i].getFundid() != 0) {
					FundBean fund = fDAO.read(transactionBeans[i].getFundid());
					viewTransaction.setFundname(fund.getFundName());
				}
				
				
				//System.out.println("FundName:" + fund.getFundName());
				
				
				viewTransaction.setTransactiontype(transactionBeans[i].getTransactiontype());
				viewTransaction.setAmount(transactionBeans[i].getAmount());
				viewTransaction.setExecutedate(transactionBeans[i].getExecutedate());
				viewTransaction.setShares(transactionBeans[i].getShares());
				transactions.add(viewTransaction);
			}
			
			request.setAttribute("transactions",transactions);
			
//			System.out.println(customerBeans[0].getUsername());
			
			return "ViewTransactionHistory.jsp";
			
			
		} catch (RollbackException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "error.jsp";
		}
	}

	
}
