package com.databean;

public class FundInfoBean {
	String ticker;
	String fundname;
	double share;
	public FundInfoBean(String ticker, String fundname, double share) {
		this.ticker = ticker;
		this.fundname = fundname;getClass();
		this.share = share;
	}
	public void setTicker(String ticker) {
		ticker = ticker; 
	}
	public String getTicker() {
		return ticker;
	}
	public void setFundname(String fundname) {
		fundname = fundname;
	}
	public String getFundname() {
		return fundname;
	}
	public void setShare(double share) {
		share = share;
	}
	public double getShare() {
		return share;
	}
}
