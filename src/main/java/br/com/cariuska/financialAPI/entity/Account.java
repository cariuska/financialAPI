package br.com.cariuska.financialAPI.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;

import lombok.Data;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Accounts POJO
 * @author Thiago Cariuska
 */
@Entity
@Data
public class Account {

	@JsonProperty(value = "accountId")
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@NotNull(message = "Name cannot be null")
	private String name;

	@JsonProperty(value = "documentNumber")
	@DecimalMin(value = "1", message = "documentNumber must be equal or greater than zero")
	@NotNull(message = "documentNumber cannot be null")
	private Integer documentNumber;

	@JsonProperty(value = "totalCreditLimit")
	@DecimalMin(value = "0", message = "totalCreditLimit must be equal or greater than zero")
	@NotNull(message = "totalCreditLimit cannot be null")
	private Float totalCreditLimit;

	@JsonProperty(value = "availableCreditLimit")
	@DecimalMin(value = "0", message = "availableCreditLimit must be equal or greater than zero")
	@NotNull(message = "availableCreditLimit cannot be null")
	private Float availableCreditLimit;
		
}
