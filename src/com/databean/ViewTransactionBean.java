package com.databean;


public class ViewTransactionBean {
	private int transactionid;
	private int cid;
	private int fundid;
	private String executedate;
	private long shares;
	private String transactiontype;
	private long amount;
	private String fundname;
	
	public ViewTransactionBean() {
		
	}

	public int getTransactionid() {
		return transactionid;
	}

	public void setTransactionid(int transactionid) {
		this.transactionid = transactionid;
	}
	
	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public int getFundid() {
		return fundid;
	}

	public void setFundid(int fundid) {
		this.fundid = fundid;
	}

	public String getExecutedate() {
		return executedate;
	}

	public void setExecutedate(String executedate) {
		this.executedate = executedate;
	}

	public long getShares() {
		return shares;
	}

	public void setShares(long shares) {
		this.shares = shares;
	}

	public String getTransactiontype() {
		return transactiontype;
	}

	public void setTransactiontype(String transactiontype) {
		this.transactiontype = transactiontype;
	}

	public long getAmount() {
		return amount;
	}

	public void setAmount(long amount) {
		this.amount = amount;
	}

	public String getFundname() {
		return fundname;
	}

	public void setFundname(String fundname) {
		this.fundname = fundname;
	}
	
}
