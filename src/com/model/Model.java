package com.model;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;

import org.genericdao.ConnectionPool;
import org.genericdao.DAOException;
import org.genericdao.RollbackException;


public class Model {
	private EmployeeDAO employeeDAO;
	private CustomerDAO customerDAO;

	public Model(ServletConfig config) throws ServletException {
		try {
			String jdbcDriverName = config.getInitParameter("jdbcDriverName");
			String jdbcURL    = config.getInitParameter("jdbcURL");
			
			ConnectionPool pool = new ConnectionPool(jdbcDriverName,jdbcURL);
	        
			employeeDAO = new EmployeeDAO(pool, "task7_employee");
            customerDAO = new CustomerDAO(pool,  "task7_customer");
            
            if(employeeDAO.getCount()==0) new DataLoader(employeeDAO);
		} catch (DAOException e) {
			throw new ServletException(e);
        } catch (RollbackException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public EmployeeDAO getEmployeeDAO()  { return employeeDAO; }
	public CustomerDAO getCustomerDAO()  { return customerDAO; }
	
}
