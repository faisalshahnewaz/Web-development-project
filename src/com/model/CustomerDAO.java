package com.model;

import org.genericdao.ConnectionPool;
import org.genericdao.DAOException;
import org.genericdao.GenericDAO;

import com.databean.CustomerBean;



/**
 * 08-672 J2EE Web Application Development.
 * @author Xuesong Zhang (Andrew ID: xuesongz)
 * December 14th, 2015
 */
public class CustomerDAO extends GenericDAO<CustomerBean> {
	public CustomerDAO(ConnectionPool cp, String tableName) throws DAOException {
		super(CustomerBean.class, tableName, cp);
	}
    
}
