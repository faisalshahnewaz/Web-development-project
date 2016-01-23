package com.controller;

import java.text.DateFormat;
import java.text.FieldPosition;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.genericdao.RollbackException;
import org.mybeans.form.FormBeanException;
import org.mybeans.form.FormBeanFactory;

import com.databean.FundBean;
import com.databean.FundPriceHistoryBean;
import com.form.DateForm;
import com.model.FundDAO;
import com.model.FundPriceHistoryDAO;
import com.model.Model;

public class DateAction extends Action {
	private FormBeanFactory<DateForm> formBeanFactory = FormBeanFactory.getInstance(DateForm.class);
	private FundPriceHistoryDAO fundPriceHistoryDAO;
	private FundDAO fundDAO;

	public DateAction(Model model) {
		fundPriceHistoryDAO = model.getFundPriceHistoryDAO();
		fundDAO = model.getFundDAO();
	}

	@Override
	public String getName() {
		return "Date.do";
	}

	@Override
	public String perform(HttpServletRequest request) {
		HttpSession session = request.getSession();
		if(session == null){
			return "Index.jsp";
		}
		List<String> errors = new ArrayList<String>();
		request.setAttribute("errors", errors);
		
		try{
			DateForm form = formBeanFactory.create(request);
			request.setAttribute("form", form);
			if(!form.isPresent()){
				return "TransitionDay.jsp";
			}
			
			errors.addAll(form.getValidationErrors());
			
			if(errors.size() > 0){
				return "TransitionDay.jsp";
			}
				
			FundPriceHistoryBean[] fundHistoryBean = fundPriceHistoryDAO.match();
			
			int i = 1;
			
			SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
			SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
			if (fundHistoryBean.length != 0) {
				System.out.println("PriceDateMax" + fundHistoryBean[0].getPricedate());
				Date maxdate = sdf1.parse(fundHistoryBean[0].getPricedate());
				while(i<fundHistoryBean.length){
					Date temp = sdf1.parse(fundHistoryBean[i].getPricedate());
					if(maxdate.compareTo(temp) > 0){
						maxdate = temp;
					}
					i++;
				}
				System.out.println("PriceDate!!" + form.getPricedate());
				Date transactionDate = sdf1.parse(form.getPricedate());
				if(transactionDate.compareTo(maxdate) <= 0){
					errors.add("Transition day for this date has already occured");
					return "TransitionDay.jsp";
				}
			}
			FundBean[] fundBeans = fundDAO.match();
			request.setAttribute("fundBeans", fundBeans);
			session.setAttribute("date", form.getPricedate());
			return "TransitionDayInput.jsp";
		}catch (FormBeanException e) {
			errors.add(e.toString());
			return "TransitionDay.jsp";
		} catch (RollbackException e1) {
			errors.add(e1.toString());
			return "TransitionDay.jsp";
		} catch (ParseException e) {
			errors.add("Parse Exception");
			return "TransitionDay.jsp";
		}

	}

}
