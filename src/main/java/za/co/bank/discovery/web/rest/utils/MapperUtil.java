package za.co.bank.discovery.web.rest.utils;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import za.co.bank.discovery.service.dto.AccountTypeDto;
import za.co.bank.discovery.service.dto.CurrencyConversionRateDto;

@Component
public class MapperUtil {
	
	public AccountTypeDto buildAccountTypeDto(String description) {
		AccountTypeDto accountType = new AccountTypeDto();
		accountType.setDescription(description);
		return accountType;
	}
	
	public CurrencyConversionRateDto buildCurrencyConversionDto(String conversionIndicator, 
			String currencyCode, BigDecimal rate) {
		CurrencyConversionRateDto currencyConversion = new CurrencyConversionRateDto();
		currencyConversion.setConversionIndicator(conversionIndicator);
		currencyConversion.setCurrencyCode(currencyCode);
		currencyConversion.setRate(rate);
		return currencyConversion;
	}
}
