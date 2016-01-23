package com.controller;

import java.util.*;
import java.math.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.genericdao.DuplicateKeyException;
import org.genericdao.MatchArg;
import org.genericdao.RollbackException;
import org.mybeans.form.FormBeanException;
import org.mybeans.form.FormBeanFactory;
import java.text.*;

import com.databean.*;
import com.form.*;
import com.model.*;

public class SellFundAction extends Action {
	TrancDAO tDAO;
	PositionDAO pDAO;
	FundDAO fDAO;
	public SellFundAction(Model model) {
		tDAO = model.getTrancDAO();
		pDAO = model.getPosDAO();
		fDAO = model.getFundDAO();
	}
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "SellFund.do";
	}

	@Override
	public String perform(HttpServletRequest request) {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		List<String> errors = new ArrayList<String>();
		request.setAttribute("errors", errors);
		try {
			CustomerBean customer = (CustomerBean) session.getAttribute("customer");
			List<FundInfoBean> fundInfo = new ArrayList<FundInfoBean>();
			PositionBean[] pb = pDAO.match(MatchArg.equals("customerid", customer.getCid()));
			for (int i = 0; i < pb.length; i++) {
				FundBean fb = fDAO.read(pb[i].getFundid());
				fundInfo.add(new FundInfoBean(fb.getFundid(), fb.getTicker(), fb.getFundName(), ((double) pb[i].getShares()) / 1000));
			}
			//String shareSell = request.getParameter("shareSell");
			request.setAttribute("fundInfo", fundInfo);
			//System.out.println(shareSell);
			Map<String, String[]> map = request.getParameterMap();
			String[] shareSell = map.get("shareSell");
			boolean flag = false;
			String s = null;
			for (int i = 0; i < shareSell.length; i++) {
				if (shareSell[i] != null && shareSell[i].length() > 0) {
					flag = true;
					s = shareSell[i];
				}
			}
			if (!flag) {
				System.out.println("hahahahahah");
				errors.add("Share amount can not be empty!");
				return "FundInfo.jsp";
			}
			//System.out.println("haha");
			try {
				double tmp = Double.parseDouble(s);
			} catch (Exception e) {
				errors.add("Your input should be a number");
				return "FundInfo.jsp";
			}
			BigDecimal bg = new BigDecimal(s);
			if (bg.doubleValue() <= 0) {
				errors.add("Your input can not be negative");
				return "FundInfo.jsp";
			}
			if (bg.scale() > 3) {
				errors.add("Your input should only have at most three decimal places");
				return "FundInfo.jsp";
			}
			double share = Double.parseDouble(s);
			String fundid = request.getParameter("fundid");
			//long allshare = pDAO.read(customer.getCid(),Integer.parseInt(fundid)).getShares();
			PositionBean pos = pDAO.read(customer.getCid(), Integer.parseInt(fundid));
			if (pos == null) {
				errors.add("You don't have this fund");
				return "FundInfo.jsp";
			}
			long allshare = pos.getShares();
			TransactionBean[] tb = tDAO.match(MatchArg.equals("executedate", null));
			for (int i = 0; i < tb.length; i++) {
				if (tb[i].getCid() == customer.getCid() && tb[i].getTransactiontype() == "sell") {
					allshare -= tb[i].getShares();
				}
			}
			if (allshare - (long) (share * 1000) < 0) {
				errors.add("You don't have enough share");
				return "FundInfo.jsp";
			}
			//System.out.println("sss");
			long Share = (long) (share * 1000);
			TransactionBean transaction = new TransactionBean();
			transaction.setCid(customer.getCid());
			transaction.setFundid(Integer.parseInt(fundid));
			transaction.setShares(Share);
			transaction.setTransactiontype("sell");
			tDAO.create(transaction);
			return "SellFundSuccess.jsp";
		} catch (RollbackException e) {
			errors.add(e.getMessage());
			return "error.jsp";
		}
	}

}
