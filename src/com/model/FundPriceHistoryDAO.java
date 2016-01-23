package com.model;

import org.genericdao.ConnectionPool;
import org.genericdao.DAOException;
import org.genericdao.GenericDAO;

import com.databean.FundPriceHistoryBean;

public class FundPriceHistoryDAO extends GenericDAO<FundPriceHistoryBean> {
	public FundPriceHistoryDAO(ConnectionPool cp, String tablename) throws DAOException{
		super(FundPriceHistoryBean.class,tablename, cp);
	}
}
