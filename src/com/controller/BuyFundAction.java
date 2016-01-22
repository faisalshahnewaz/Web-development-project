package com.controller;
import java.util.*;
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
public class BuyFundAction extends Action {
	private FormBeanFactory<BuyFundForm> formBeanFactory = FormBeanFactory.getInstance(BuyFundForm.class);
	CustomerDAO cDAO;
	TrancDAO tDAO;
	FundDAO fDAO;
	public BuyFundAction(Model model) {
		cDAO = model.getCustomerDAO();
		tDAO = model.getTrancDAO();
		fDAO = model.getFundDAO();
	}
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "BuyFund.do";
	}

	@Override
	public String perform(HttpServletRequest request) {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		List<String> errors = new ArrayList<String>();
		request.setAttribute("errors", errors);
		try {
			BuyFundForm form = formBeanFactory.create(request);
			request.setAttribute("form", form);
			if (!form.isPresent()) {
				return "BuyFund.jsp";
			}
			errors.addAll(form.getValidationErrors());
			if (errors.size() > 0) {
				return "BuyFund.jsp";
			}
			String fundsymbol = form.getFundsymbol();
			CustomerBean c = (CustomerBean) session.getAttribute("customer");
			FundBean[] fb = fDAO.match(MatchArg.equals("ticker", fundsymbol));
			TransactionBean transaction = new TransactionBean();
			//parse the money
			Double amount = Double.parseDouble(form.getMoney());
			DecimalFormat df = new DecimalFormat("0.000");
			String tmpAmount = df.format(amount);
			double amount1 = Double.parseDouble(tmpAmount);
			long money = (long) (1000 * amount1);
			transaction.setAmount(money);
			transaction.setCid(c.getCid());
			transaction.setFundid(fb[0].getFundid());
			transaction.setTransactiontype("buy");
			tDAO.create(transaction);
			return "BuyFund.jsp";
		} catch (FormBeanException e) {
			errors.add(e.getMessage());
			return "error.jsp";
		} catch (RollbackException e) {
			errors.add(e.getMessage());
			return "error.jsp";
		}
	}
}
