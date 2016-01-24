package com.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.genericdao.RollbackException;

import com.databean.CustomerBean;
import com.databean.FundPriceHistoryBean;
import com.databean.ViewCustomerAccountBean;
import com.model.CustomerDAO;
import com.model.FundPriceHistoryDAO;
import com.model.Model;

public class ViewCustomerAccountAction extends Action {

	private CustomerDAO cDAO;
	private FundPriceHistoryDAO fundPriceHistoryDAO;

	public ViewCustomerAccountAction(Model model) {
		cDAO = model.getCustomerDAO();
		fundPriceHistoryDAO = model.getFundPriceHistoryDAO();
	}

	@Override
	public String getName() {

		return "ViewCustomerAccount.do";
	}

	@Override
	public String perform(HttpServletRequest request) {

		/*
		 * 1.get the list of customers from CustomerDAO 2. create a list of View
		 * customer account to hold the objects of view customer acc.bean. 3.
		 * load data from different table to each view cus acc bean. 4. add the
		 * beans to the list. 5. pass the bean list to jsp. 6. return the jsp
		 * name.
		 */
		CustomerBean[] customerBeans;
		List<ViewCustomerAccountBean> customerList = new ArrayList<ViewCustomerAccountBean>();

		try {
			customerBeans = cDAO.getCustomerList();
			request.setAttribute("customerList", customerList);

			if (customerBeans.length > 0) {
				for (CustomerBean customerBean : customerBeans) {

					ViewCustomerAccountBean viewCusBean = new ViewCustomerAccountBean();

					// load data to bean
					viewCusBean.setCid(customerBean.getCid());
					viewCusBean.setUsername(customerBean.getUsername());
					viewCusBean.setFirstname(customerBean.getFirstname());
					viewCusBean.setLastname(customerBean.getLastname());
					viewCusBean.setAddrline1(customerBean.getAddrline1());
					viewCusBean.setAddrline2(customerBean.getAddrline2());
					viewCusBean.setCity(customerBean.getCity());
					viewCusBean.setState(customerBean.getState());
					viewCusBean.setZip(customerBean.getZip());
					viewCusBean.setCash(customerBean.getCash());

					// other data load

					System.out.println("User Name:" + customerBean.getUsername());

					// add the bean to the List
					customerList.add(viewCusBean);
				}
			}
			FundPriceHistoryBean[] fundHistoryBean = fundPriceHistoryDAO.match();
			int i = 1;
			SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
			SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
			if (fundHistoryBean.length != 0) {
				Date maxdate = sdf1.parse(fundHistoryBean[0].getPricedate());
				while (i < fundHistoryBean.length) {
					Date temp = sdf1.parse(fundHistoryBean[i].getPricedate());
					if (maxdate.compareTo(temp) > 0) {
						maxdate = temp;
					}
					i++;
				}
				request.setAttribute("Date", sdf.format(maxdate));
			}

			return "ViewCustomerAccount.jsp";

		} catch (RollbackException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "error.jsp";
	}

}
