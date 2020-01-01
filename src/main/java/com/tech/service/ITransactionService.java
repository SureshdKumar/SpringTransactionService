package com.tech.service;

import java.util.List;

import com.tech.model.ParsedTransactions;
import com.tech.model.Transaction;

public interface ITransactionService {
	
	void AddTransaction(Transaction tnx);
	
	List<Object> getParsedTransactions();
	
	int getDepositAmount(String accountId);

}
