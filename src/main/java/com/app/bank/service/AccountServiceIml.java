package com.app.bank.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.bank.model.Account;
import com.app.bank.repository.AccountRepository;


@Service
public class AccountServiceIml implements AccountService {
	
	@Autowired
	AccountRepository repo;

	@Override
	public Account createAccount(Account account) {
		Account account_saved=repo.save(account);
		return account_saved;
	}

	@Override
	public Account getAccountDetailsByAccountNumber(Long accountNumber) {
		Optional<Account> get_account= repo.findById(accountNumber);
		if (get_account.isEmpty()) {
			throw new RuntimeException("Account does not exist");
			
		}
		
		Account account_found= get_account.get();
		
		return account_found;
	}

	@Override
	public List<Account> getAllAccountDetails() {
		List<Account> getAllDetails=repo.findAll();
		return getAllDetails;
	}

	@Override
	public Account depositAmount(Long accountNumber, Double amount) {
		Optional<Account> account = repo.findById(accountNumber);
		if (account.isEmpty()) {
			
			throw new RuntimeException("Account not found");
			
		}
		
		Account accountPresent = account.get();
		Double totalBalance= accountPresent.getAccount_balance()+amount;
		accountPresent.setAccount_balance(totalBalance);
		repo.save(accountPresent);
		
		
		return accountPresent;
	}

	@Override
	public Account withdrawAmount(Long accountNumber, Double amount) {
		Optional<Account> account =repo.findById(accountNumber);
		if (account.isEmpty()) {
			
			throw new RuntimeException("Account not found");
		}
		Account presentAccount= account.get();
		double totalBalance= presentAccount.getAccount_balance()-amount;
		
		presentAccount.setAccount_balance(totalBalance);
		repo.save(presentAccount);
		return presentAccount;
	}

	@Override
	public void closeAccount(Long accountNumber) {
		
		getAccountDetailsByAccountNumber(accountNumber);
		repo.deleteById(accountNumber);
		
		
	}

}
