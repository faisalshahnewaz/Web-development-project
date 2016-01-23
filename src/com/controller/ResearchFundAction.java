package com.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.genericdao.MatchArg;
import org.genericdao.RollbackException;

import com.databean.FundBean;
import com.databean.FundPriceHistoryBean;
import com.model.FundDAO;
import com.model.FundPriceHistoryDAO;
import com.model.Model;

public class ResearchFundAction extends Action {
	FundDAO fundDAO;
	FundPriceHistoryDAO fundPriceHistoryDAO;
	public ResearchFundAction(Model model) {
		fundDAO = model.getFundDAO();
		fundPriceHistoryDAO = model.getFundPriceHistoryDAO();
	}
	@Override
	public String getName() {
		return "researchFund.do";
	}

	@Override
	public String perform(HttpServletRequest request) {
		List<String> errors = new ArrayList<String>();
		request.setAttribute("error", errors);
		
		try{
			String fundName = request.getParameter("fundName");
			if(fundName == null){
				FundBean[] fundList = fundDAO.match();
				request.setAttribute("fundList",fundList);
				return "ResearchFund.jsp";
			}
			FundPriceHistoryBean[] fundHistory = fundPriceHistoryDAO.match(MatchArg.equals("fundName", fundName));
			if(fundHistory.length == 0){
				errors.add("Cannot find the fund");
				return "ResearchFund.jsp";
			}
			request.setAttribute("fundHistory", fundHistory);
			return "ResearchFund.jsp";
		}catch(RollbackException e){
			errors.add("Exception");
			return "ResearchFund.jsp";
		}
	}
	
}
