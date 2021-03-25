package br.com.cariuska.financialAPI.service;

import java.math.BigDecimal;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cariuska.financialAPI.entity.Account;
import br.com.cariuska.financialAPI.exception.NotFoundException;
import br.com.cariuska.financialAPI.repository.AccountRepository;

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

}
