package com.form;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author faisalshahnewaz
 *
 */
public class CreateCustomerForm {
	
	private String username;
	private String firstname;
	private String lastname;
	private String password;
	private String confirmpassword;
	private String addrline1;
	private String addrline2;
	private String city;
	private String state;
	private String zip;
	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAddrline1() {
		return addrline1;
	}
	public void setAddrline1(String addrline1) {
		this.addrline1 = addrline1;
	}
	public String getAddrline2() {
		return addrline2;
	}
	public void setAddrline2(String addrline2) {
		this.addrline2 = addrline2;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	public String getConfirmpassword() {
		return confirmpassword;
	}
	public void setConfirmpassword(String confirmpassword) {
		this.confirmpassword = confirmpassword;
	}
	
	public List<String> getValidationErrors() {
		List<String> errors = new ArrayList<String>();

		if (firstname == null || firstname.length() == 0) {
			errors.add("First Name is required");
		}

		if (lastname == null || lastname.length() == 0) {
			errors.add("Last Name is required");
		}

		if (username == null || username.length() == 0) {
			errors.add("Username is required");
		}

		if (password == null || password.length() == 0) {
			errors.add("Password is required");
		}
		
		if ( confirmpassword == null || confirmpassword.length() == 0) {
			errors.add("Confirm Password is required");
		}
		
		if ( addrline1 == null || addrline1.length() == 0) {
			errors.add("Addrline1 is required");
		}
		
//		if ( addrline2 == null || addrline1.length() == 0) {
//			errors.add("addrline2 is required");
//		}
		
		if ( city == null || city.length() == 0) {
			errors.add("City is required");
		}
		
		if ( state == null || state.length() == 0) {
			errors.add("State is required");
		}
		if ( zip == null || zip.length() == 0) {
			errors.add("Zip is required");
		}
		
		return errors;
	}
	
}
