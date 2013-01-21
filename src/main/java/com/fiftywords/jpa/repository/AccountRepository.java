package com.fiftywords.jpa.repository;

import com.fiftywords.domain.Account;


public interface AccountRepository {
	
	void createAccount(Account account) throws UsernameAlreadyInUseException;

	Account findAccountByUsername(String username);
	
}
