package com.databean;

/**
 * @author faisalshahnewaz (andrew id: sfaisal)
 */
import org.genericdao.PrimaryKey;

@PrimaryKey("transaction id")
public class Transaction {
	private int customer_id;
	private int fund_id;
	private String execute_date;
	private int shares;
	private String transaction_type;
	private long amount;
	
	public Transaction() {
		
	}

	public int getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}

	public int getFund_id() {
		return fund_id;
	}

	public void setFund_id(int fund_id) {
		this.fund_id = fund_id;
	}

	public String getExecute_date() {
		return execute_date;
	}

	public void setExecute_date(String execute_date) {
		this.execute_date = execute_date;
	}

	public int getShares() {
		return shares;
	}

	public void setShares(int shares) {
		this.shares = shares;
	}

	public String getTransaction_type() {
		return transaction_type;
	}

	public void setTransaction_type(String transaction_type) {
		this.transaction_type = transaction_type;
	}

	public long getAmount() {
		return amount;
	}

	public void setAmount(long amount) {
		this.amount = amount;
	}
	
}
