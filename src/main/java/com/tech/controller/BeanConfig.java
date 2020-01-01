package com.tech.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.tech.service.ITransactionService;
import com.tech.service.TransactionServiceImpl;

@Configuration
public class BeanConfig {
	
	@Bean(name = "ITransactionService")
	public ITransactionService transactionService() {
		final ITransactionService service = new TransactionServiceImpl();
		return service;
	}

}
