package br.com.cariuska.financialAPI.repository;

import org.springframework.data.repository.CrudRepository;
import br.com.cariuska.financialAPI.entity.Account;

public interface AccountRepository extends CrudRepository<Account, Integer>  {
		

}
