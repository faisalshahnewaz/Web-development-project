package com.model;

import org.genericdao.ConnectionPool;
import org.genericdao.DAOException;
import org.genericdao.GenericDAO;
import org.genericdao.MatchArg;
import org.genericdao.RollbackException;

import com.databean.FundBean;

public class FundDAO extends GenericDAO<FundBean>{
	public FundDAO(ConnectionPool cp, String tableName)throws DAOException{
		super(FundBean.class,tableName,cp);
	}
	
	public FundBean[] getFundList() throws RollbackException{
		FundBean[] fundList = match();
		return fundList;
	}
	
	public FundBean[] getFundListBySearch(String ticker) throws RollbackException {
		FundBean[] fundList = match(MatchArg.contains("ticker", ticker));
		return fundList;
	}
}