package com.app.bank.service;

import java.util.List;

import com.app.bank.model.Account;

public interface AccountService {
	
	public Account createAccount(Account acount);
	public Account getAccountDetailsByAccountNumber(Long accountNumber);
	public List<Account> getAllAccountDetails();
	public Account depositAmount(Long accountNumber, Double amount);
	public Account withdrawAmount(Long accountNumber, Double amount);
	public void closeAccount(Long accountNumber);

}
