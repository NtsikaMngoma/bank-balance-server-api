package za.co.bank.discovery.service.dto;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public interface AccountReportsDto {
	
	Integer getClientId();
	
	@JsonProperty("account_description")
	String getDescription();

	String getSurname();
	
	String getClientAccountNumber();
	
	@JsonProperty("account_balance")
	BigDecimal getDisplayBalance();
}
