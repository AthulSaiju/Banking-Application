package com.app.bank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.bank.model.Account;
import com.app.bank.service.AccountService;

@RestController
@RequestMapping("/account")
public class AccountController {
	
	@Autowired
	AccountService service;
	
	@PostMapping("/create")
	public ResponseEntity<Account> createAccount(@RequestBody Account account) {
		
		Account createAccount=service.createAccount(account);	
		
		return ResponseEntity.status(HttpStatus.CREATED).body( createAccount);
		
	}
	
	@GetMapping("/{id}")
	public Account getaccountDetails(@PathVariable("id") Long accountNumber) {
		
		Account accountDetails =service.getAccountDetailsByAccountNumber(accountNumber);
		return accountDetails;
	}
	
	
	@GetMapping("/getallaccounts")
	
	public List<Account> getAllAccountDetails() {
		
		List<Account> getAllAccount = service.getAllAccountDetails();
		
		return getAllAccount;
		
	}
	
	@PutMapping("/deposit/{accountNumber}/{amount}")
	public Account depositAccount(@PathVariable Long accountNumber,@PathVariable double amount) {
		
		Account depositAmount= service.depositAmount(accountNumber, amount);
		return depositAmount;
		
	}
	
	@PutMapping("/withdraw/{accountNumber}/{amount}")
	public Account withdrawAmount(@PathVariable Long accountNumber,@PathVariable Double amount) {
		Account account = service.withdrawAmount(accountNumber, amount);
		return account;
		
	}
	
	@DeleteMapping("/delete/{accountNumber}")
	public ResponseEntity<String> deleteAccount(@PathVariable Long accountNumber){
		
		service.closeAccount(accountNumber);
		
		return ResponseEntity.ok("Account closed");
		
	}
	
	
	
	

}
