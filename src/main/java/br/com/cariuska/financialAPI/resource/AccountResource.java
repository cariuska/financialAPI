package br.com.cariuska.financialAPI.resource;

import java.util.List;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.cariuska.financialAPI.entity.Account;
import br.com.cariuska.financialAPI.exception.BusinessException;
import br.com.cariuska.financialAPI.exception.NotFoundException;
import br.com.cariuska.financialAPI.response.AccountResponse;
import br.com.cariuska.financialAPI.service.AccountService;
import br.com.cariuska.financialAPI.util.GenericResponse;
import br.com.cariuska.financialAPI.util.ModelConvert;
import br.com.cariuska.financialAPI.util.PageFinacial;
import br.com.cariuska.financialAPI.util.ValidationResponse;

/**
 * REST Resources
 * @author Thiago Cariuska
 */
@RestController
@RequestMapping(value="/accounts")
public class AccountResource {

	@Autowired
	private AccountService accountService;
	
	
	private static final Logger logger = LogManager.getLogger();

	@GetMapping("{accountId}")
	public ResponseEntity<?> getAccount(@Valid @PathVariable Integer accountId) throws NotFoundException {
		Account account = accountService.get(accountId);

		AccountResponse accountResponse = ModelConvert.convertModelMapper(account, AccountResponse.class);
		
		return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(accountResponse);			
	}

	@GetMapping()
	public ResponseEntity<?> getAccountList(
			@RequestHeader(name = "token", required=true) String token,
			@RequestParam(name = "page", required = false, defaultValue = "0") int page,
			@RequestParam(name = "size", required = false, defaultValue = "10") int size
			) throws NotFoundException {
				
		Page<Account> accounts = accountService.list(page, size);
		
		PageFinacial<AccountResponse> pageFinacial = ModelConvert.convertModelMapper(accounts, PageFinacial.class);
				
		//List<AccountResponse> accountResponse = ModelConvert.convertModelMapper(accounts, new TypeToken<List<AccountResponse>>() {}.getType());		
		//Page<AccountResponse> page = new Page<AccountResponse>();
		//page.content = accountResponse;
		
		return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(pageFinacial);			
	}
	

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ValidationResponse handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {
		ValidationResponse response = new ValidationResponse();
	    ex.getBindingResult().getAllErrors().forEach((error) -> {
	        response.add(error.getDefaultMessage());
	    });
	    return response;
	}
	
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(NotFoundException.class)
	public GenericResponse handleNotFoundException(NotFoundException e) {
		logger.info(e.getMessage());
		return new GenericResponse(e.getMessage());
	};
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(BusinessException.class)
	public GenericResponse handleBusinessException(BusinessException e) {
		logger.info(e.getMessage());
		return new GenericResponse(e.getMessage());
	}
	
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(Exception.class)
	public ValidationResponse handleExceptions(Exception e) {
		logger.error(e);
		ValidationResponse response = new ValidationResponse();
		response.add(e.getMessage());
	    return response;
	}
}
