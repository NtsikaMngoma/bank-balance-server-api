package za.co.bank.discovery.service.dto;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonProperty;

public interface ExchangeAccountsDto {
	
	@JsonProperty("exchange_indicator")
	String getConversionIndicator();
	
	@JsonProperty("currency_code")
	String getCurrencyCode();
	
	@JsonProperty("currency_description")
	String getCurrencyDescription();
	
	@JsonProperty("exchange_rate")
	BigDecimal getRate();
	
	@JsonProperty("account_number")
	String getClientAccountNumber();
	
	@JsonProperty("account_balance")
	BigDecimal getDisplayBalance();
	
	@JsonProperty("exchange_currnecy_code")
	String getExchangeCurrencyCode();
	
	@JsonProperty("exchange_account_balance")
	BigDecimal getExchangeAccountBalance();
	
//	@Value("#{@mapperUtil.buildCurrencyConversionDto(target.conversionIndicator, target.currencyCode, target.rate)}")
//	CurrencyConversionRateDto getCurrencyConversionRateDto();
}
