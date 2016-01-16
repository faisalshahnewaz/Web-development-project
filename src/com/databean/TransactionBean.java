package com.databean;

/**
 * @author faisalshahnewaz (andrew id: sfaisal)
 */
import org.genericdao.PrimaryKey;

@PrimaryKey("transaction id")
public class TransactionBean {
	private int customerid;
	private int fundid;
	private String executedate;
	private int shares;
	private String transactiontype;
	private long amount;
	
	public TransactionBean() {
		
	}

	public int getCustomerid() {
		return customerid;
	}

	public void setCustomerid(int customerid) {
		this.customerid = customerid;
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

	public int getShares() {
		return shares;
	}

	public void setShares(int shares) {
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
	
}
