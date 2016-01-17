package com.model;

import org.genericdao.ConnectionPool;
import org.genericdao.DAOException;
import org.genericdao.GenericDAO;

import com.databean.FundBean;

public class FundDAO extends GenericDAO<FundBean>{
	public FundDAO(ConnectionPool cp, String tableName)throws DAOException{
		super(FundBean.class,tableName,cp);
	}
}
