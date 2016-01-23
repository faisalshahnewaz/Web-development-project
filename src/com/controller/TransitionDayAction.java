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

public class TransitionDayAction extends Action {
	CustomerDAO cDAO;
	TrancDAO tDAO;
	FundDAO fDAO;
	FundPriceHistoryDAO fphDAO;
	PositionDAO pDAO;
	public TransitionDayAction(Model model) {
		cDAO = model.getCustomerDAO();
		tDAO = model.getTrancDAO();
		fDAO = model.getFundDAO();
		fphDAO = model.getFundPriceHistoryDAO();
		pDAO = model.getPosDAO();
	}
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "TransitionDay.do";
	}

	@Override
	public String perform(HttpServletRequest request) {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		List<String> errors = new ArrayList<String>();
		request.setAttribute("errors", errors);
		try {
			Map map = request.getParameterMap();
			TransactionBean[] tb = tDAO.match(MatchArg.equals("executedate", null));
			//Set set = map.entrySet();
			String[] fids = (String[]) map.get("fundid");
			String[] prices = (String[]) map.get("price");
			String date = (String) session.getAttribute("date");
			Map<Integer, Double> mapPrice = new HashMap<Integer, Double>();
			int n = fids.length;
			for (int i = 0; i < n; i++) {
				addFundHistory(Integer.parseInt(fids[i]), date, 1000 * (long) Double.parseDouble(prices[i]), fphDAO);
				mapPrice.put(Integer.parseInt(fids[i]), Double.parseDouble(prices[i]));
			}
			for (int i = 0; i < tb.length; i++) {
				//tb[i].setExecutedate(date);
				//tDAO.update(tb[i]);
				CustomerBean customer = cDAO.read(tb[i].getCid());
				operation(customer, tb[i], pDAO, cDAO, mapPrice, tb[i].getTransactiontype());
				tb[i].setExecutedate(date);
				tDAO.update(tb[i]);
			}
			return "TransitionDaySuccess.jsp";
		} catch (FormBeanException e) {
			errors.add(e.getMessage());
			return "error.jsp";
		} catch (RollbackException e) {
			errors.add(e.getMessage());
			return "error.jsp";
		}
	}
	private void addFundHistory(int fundId, String priceDate, long price, FundPriceHistoryDAO fphDAO) throws FormBeanException, RollbackException{
		FundPriceHistoryBean bean = new FundPriceHistoryBean();
		bean.setFundid(fundId);
		bean.setPrice(price);
		bean.setPricedate(priceDate);
		fphDAO.create(bean);
	}
	private void operation(CustomerBean customer, TransactionBean transaction, PositionDAO pDAO, CustomerDAO cDAO, Map<Integer, Double> map, String type) throws FormBeanException, RollbackException {
		switch (type) {
		case "buy" :
			opbuy(customer, transaction, pDAO, cDAO, map);
			break;
		default :
			
		}
	}
	private void opbuy(CustomerBean customer, TransactionBean transaction, PositionDAO pDAO, CustomerDAO cDAO, Map<Integer, Double> map) throws FormBeanException, RollbackException {
		long cash = customer.getCash() - transaction.getAmount();
		customer.setCash(cash);
		cDAO.update(customer);
		PositionBean position = new PositionBean();
		position.setCustomerid(customer.getCid());
		position.setFundid(transaction.getFundid());
		double share = (((double) transaction.getAmount()) / 100) / map.get(transaction.getFundid());
		DecimalFormat df = new DecimalFormat("0.000");
		share = Double.valueOf(df.format(share));
		position.setShares((long) (share * 1000));
		PositionBean p = pDAO.read(customer.getCid(),transaction.getFundid());
		if (p == null) {
			pDAO.create(position);
		} else {
			pDAO.update(position);
		}
	}
}
