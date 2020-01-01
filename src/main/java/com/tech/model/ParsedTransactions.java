package com.tech.model;

import java.util.Date;

public class ParsedTransactions {
	
	private String accountId;
	private int depositAmount;
	private int withdrawAmount;
	private String transactionDate;
	
	public ParsedTransactions(String accountId, int depositAmount, int withdrawAmount, String transactionDate){
		this.accountId = accountId;
		this.depositAmount = depositAmount;
		this.withdrawAmount = withdrawAmount;
		this.transactionDate = transactionDate;
	}
	
	public String getAccountId() {
		return accountId;
	}
	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}
	public int getDepositAmount() {
		return depositAmount;
	}
	public void setDepositAmount(int depositAmount) {
		this.depositAmount = depositAmount;
	}
	public int getWithdrawAmount() {
		return withdrawAmount;
	}
	public void setWithdrawAmount(int withdrawAmount) {
		this.withdrawAmount = withdrawAmount;
	}
	public String getTransactionDate() {
		return transactionDate;
	}
	public void setTransactionDate(String transactionDate) {
		this.transactionDate = transactionDate;
	}
	

}
