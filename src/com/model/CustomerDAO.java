package com.model;

import java.util.Arrays;

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
	
	public void changePassword(String username, String newPassword)throws RollbackException{
		try{
			Transaction.begin();
			
			System.out.println("Change Pwd in DAO: username:" + username);
			
			CustomerBean[] customer = match(MatchArg.equals("username", username));
			if(customer.length == 0){
				throw new RollbackException("Not found");
			}
			customer[0].setPassword(newPassword);
			update(customer[0]);
			Transaction.commit();
		}
		finally{
			if(Transaction.isActive())
				Transaction.rollback();
		}
	}
	
	public CustomerBean[] getCustomerList() throws RollbackException{
		
		CustomerBean[] customerList = match();
		//Arrays.sort(customerList);
		return customerList;
	}
}
