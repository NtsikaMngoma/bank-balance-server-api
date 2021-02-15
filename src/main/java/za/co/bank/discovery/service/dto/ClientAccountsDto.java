package za.co.bank.discovery.service.dto;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonProperty;

public interface ClientAccountsDto {

	@JsonProperty("account_number")
	String getClientAccountNumber();
	
	@JsonProperty("balance")
    BigDecimal getDisplayBalance();
	
	@JsonProperty("account_type")
	String getDescription();
}
