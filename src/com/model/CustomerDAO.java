package com.model;

import org.genericdao.ConnectionPool;
import org.genericdao.DAOException;
import org.genericdao.GenericDAO;
import org.genericdao.MatchArg;
import org.genericdao.RollbackException;
import org.genericdao.Transaction;

import com.databean.CustomerBean;

public class CustomerDAO extends GenericDAO<CustomerBean> {
	public CustomerDAO(ConnectionPool cp, String tableName) throws DAOException {
		super(CustomerBean.class, tableName, cp);
	}
	
	public void changePassword(String username, String password)throws RollbackException{
		try{
			Transaction.begin();
			CustomerBean[] customer = match(MatchArg.and(MatchArg.equals("username", username)),MatchArg.equals("password",password));
			if(customer.length == 0){
				throw new RollbackException("Username and password don't match");
			}
			customer[0].setPassword(password);
			update(customer[0]);
			Transaction.commit();
		}
		finally{
			if(Transaction.isActive())
				Transaction.rollback();
		}
	}
}
