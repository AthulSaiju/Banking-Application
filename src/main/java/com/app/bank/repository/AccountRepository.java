package com.app.bank.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.bank.model.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {

}
