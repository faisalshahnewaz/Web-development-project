package com.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.genericdao.ConnectionPool;
import org.genericdao.DAOException;
import org.genericdao.GenericDAO;
import org.genericdao.RollbackException;

import com.databean.FundPriceHistoryBean;

public class FundPriceHistoryDAO extends GenericDAO<FundPriceHistoryBean> {
	public FundPriceHistoryDAO(ConnectionPool cp, String tablename) throws DAOException {
		super(FundPriceHistoryBean.class, tablename, cp);
	}

	public String getMaxDate() throws ParseException, RollbackException {
		FundPriceHistoryBean[] fundHistoryBean = match();
		int i = 1;
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		if (fundHistoryBean.length != 0) {
			Date maxdate = sdf.parse(fundHistoryBean[0].getPricedate());
			while (i < fundHistoryBean.length) {
				Date temp = sdf.parse(fundHistoryBean[i].getPricedate());
				if (maxdate.compareTo(temp) > 0) {
					maxdate = temp;
				}
				i++;
			}
			return sdf.format(maxdate);
		}
		return null;
	}
}