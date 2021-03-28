package br.com.cariuska.financialAPI.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class AccountResponse {

	@JsonProperty(value = "accountId")
	private Integer id;
	
	@JsonProperty(value = "name")
	private String name;
	
	@JsonProperty(value = "documentNumber")
	private Integer documentNumber;
	
	@JsonProperty(value = "totalCreditLimit")
	private Float totalCreditLimit;
	
	@JsonProperty(value = "availableCreditLimit")
	private Float availableCreditLimit;
	
}


