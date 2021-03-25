package br.com.cariuska.financialAPI.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class AccountResponse {

	@JsonProperty(value = "accountId")
	private Integer id;
	
	@JsonProperty(value = "name")
	private String name;
	
}
