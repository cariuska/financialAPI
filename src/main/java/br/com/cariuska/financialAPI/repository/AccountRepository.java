package br.com.cariuska.financialAPI.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import br.com.cariuska.financialAPI.entity.Account;

public interface AccountRepository extends PagingAndSortingRepository<Account, Integer>  {
		
    //List<Account> findAllPageable(Pageable pageable);


}
