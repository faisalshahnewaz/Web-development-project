package com.form;

import org.mybeans.form.FormBean;

public class CreateFundForm extends FormBean {
	private String fundName;
	private String ticker;
	
	public String getFundName() {
		return fundName;
	}
	public void setFundName(String fundName) {
		this.fundName = fundName;
	}
	public String getTicker() {
		return ticker;
	}
	public void setTicker(String ticker) {
		this.ticker = ticker;
	}
	
}
