package com.model;

import org.genericdao.ConnectionPool;
import org.genericdao.DAOException;
import org.genericdao.GenericDAO;

import com.databean.EmployeeBean;



/**
 * 08-672 J2EE Web Application Development.
 * @author Xuesong Zhang (Andrew ID: xuesongz)
 * December 14th, 2015
 */
public class EmployeeDAO extends GenericDAO<EmployeeBean> {
	public EmployeeDAO(ConnectionPool cp, String tableName) throws DAOException {
		super(EmployeeBean.class, tableName, cp);
	}
    
}