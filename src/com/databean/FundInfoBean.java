package com.databean;

public class FundInfoBean {
	int fundid;
	String ticker;
	String fundname;
	double share;
	public FundInfoBean(int fundid, String ticker, String fundname, double share) {
		this.fundid = fundid;
		this.ticker = ticker;
		this.fundname = fundname;getClass();
		this.share = share;
	}
	public void setFundid(int fundid) {
		fundid = fundid;
	}
	public int getFundid() {
		return fundid;
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
