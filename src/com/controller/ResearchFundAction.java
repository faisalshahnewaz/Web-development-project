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
		return "ResearchFund.do";
	}

	@Override
	public String perform(HttpServletRequest request) {
		List<String> errors = new ArrayList<String>();
		request.setAttribute("error", errors);
		
		try{
			String fundId = request.getParameter("fundId");
			if(fundId == null){
				FundBean[] fundList = fundDAO.match();
				request.setAttribute("fundList",fundList);
				return "ResearchFund.jsp";
			}
			int fundid = Integer.parseInt(fundId);
			
			FundPriceHistoryBean[] fundHistory = fundPriceHistoryDAO.match(MatchArg.equals("fundid", fundid));
			if(fundHistory.length == 0){
				errors.add("Cannot find the fund");
				return "ResearchFund.jsp";
			}
			FundBean fund = fundDAO.read(fundid);
			request.setAttribute("fundName", fund.getFundName());
			request.setAttribute("fundHistory", fundHistory);
			return "ResearchFund.jsp";
		}catch(RollbackException e){
			errors.add("Exception");
			return "ResearchFund.jsp";
		}
	}
	
}
