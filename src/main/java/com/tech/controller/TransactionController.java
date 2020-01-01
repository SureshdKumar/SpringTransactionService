package com.tech.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tech.model.Transaction;
import com.tech.service.ITransactionService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class TransactionController {
	
	@Autowired
	private ITransactionService service;
	
	public void setService(ITransactionService service) {
		this.service = service;
	}

	private static void setResponseHeaders(HttpServletResponse response) {
		if(response != null) {
			response.setHeader("Access-Control-Allow-Origin", "*");
			response.setHeader("Allow", "*");
			response.setHeader("Access-Control-Allow-Methods", "POST,GET");
			response.setHeader("X-Frame-Options", "SAMEORIGIN");
		}
	}
	
	@PostMapping("/api/v1/transactionService/addTransaction")
	public ResponseEntity addTransaction(@RequestBody Transaction transaction, HttpServletResponse response) {
		setResponseHeaders(response);
		service.AddTransaction(transaction);
		return ResponseEntity.status(HttpStatus.OK).build();
		
	}
	
	@GetMapping("/api/v1/transactionService/getTransactions")
	public ResponseEntity depositAmount(HttpServletResponse response) {
		setResponseHeaders(response);
		List<Object> parsedTransactions = service.getParsedTransactions();
		return new ResponseEntity(parsedTransactions, HttpStatus.OK);
		
	}
	
	@GetMapping("/api/v1/transactionService/getDepositAmount/{accountId}")
	public ResponseEntity getDepositAmount(@PathVariable String accountId, HttpServletResponse response) {
		setResponseHeaders(response);
		int depositAmount = service.getDepositAmount(accountId);
		return new ResponseEntity(depositAmount, HttpStatus.OK);
		
	}
	
	

}
