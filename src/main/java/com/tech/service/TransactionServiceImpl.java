package com.tech.service;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.tech.dao.InMemoryTransactions;
import com.tech.model.ParsedTransactions;
import com.tech.model.Transaction;

public class TransactionServiceImpl implements ITransactionService{

	
	
	@Override
	public void AddTransaction(Transaction tnx) {
		InMemoryTransactions.transactions.add(tnx);
		
	}

	@Override
	public List<Object> getParsedTransactions() {
		List<Object> parsedTransactions = InMemoryTransactions.transactions.stream().collect(Collectors.groupingBy( p -> Arrays.asList(p.createdDate, p.accountId)))
				.entrySet().stream().collect(Collectors.toMap(tnx -> {
					int depositAmount = tnx.getValue().stream().filter(t -> t.getAmount() > 0).collect(Collectors.summingInt(Transaction::getAmount));
					int withdrawAmount = tnx.getValue().stream().filter(t -> t.getAmount() < 0).collect(Collectors.summingInt(Transaction::getAmount));
					Date transactionDate = (Date)tnx.getKey().get(0);
					String date = new SimpleDateFormat("yyyy-MM-dd").format(transactionDate);
					String accountId = (String)tnx.getKey().get(1);
					return new ParsedTransactions(accountId, depositAmount, withdrawAmount, date);
				}, Map.Entry::getValue)).entrySet().stream().map(Map.Entry::getKey).collect(Collectors.toList());

			parsedTransactions.stream().forEach(ad -> {
				ParsedTransactions pad = (ParsedTransactions) ad;
				System.out.println("Account Id: "+pad.getAccountId() + " Credit Amount: "+pad.getDepositAmount() + " Debit Amount: "+pad.getDepositAmount() + "Date: "+pad.getTransactionDate());
			});
		return parsedTransactions;
	}

	@Override
	public int getDepositAmount(String accountId) {
		int da = 0;
		  da = InMemoryTransactions.transactions.stream().filter(t ->  accountId.equals(t.getAccountId())).filter(t -> t.getAmount() > 0).collect(Collectors.summingInt(Transaction::getAmount));
		  
		  return da;
	}

}
