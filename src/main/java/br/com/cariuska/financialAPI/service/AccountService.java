package br.com.cariuska.financialAPI.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.cariuska.financialAPI.entity.Account;
import br.com.cariuska.financialAPI.exception.NotFoundException;
import br.com.cariuska.financialAPI.repository.AccountRepository;
import org.springframework.data.domain.Page;

/**
 * Account Service class
 * @author Thiago Cariuska
 */
@Service
public class AccountService {

	@Autowired
	private AccountRepository accountRepository;
	
	public Account get(Integer accountId) throws NotFoundException {
			
		Optional<Account>  account = accountRepository.findById(accountId);
		if (account.isEmpty()) {
			throw new NotFoundException("Account not found");
		}
		return account.orElseThrow();
	}

	public Page<Account> list(int page, int size) throws NotFoundException {
			
		Pageable pageable = PageRequest.of(page, size);
		
		Page<Account>  accounts = accountRepository.findAll(pageable);
		if (accounts.isEmpty()) {
			throw new NotFoundException("Accounts not found");
		}
		return accounts;
	}
	
	

}
