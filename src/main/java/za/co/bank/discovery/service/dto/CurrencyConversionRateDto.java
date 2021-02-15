package za.co.bank.discovery.service.dto;

import java.io.Serializable;
import java.math.BigDecimal;

public class CurrencyConversionRateDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String conversionIndicator;
	public String currencyCode;
	public BigDecimal rate;
	
	public String getConversionIndicator() {
		return conversionIndicator;
	}
	public void setConversionIndicator(String conversionIndicator) {
		this.conversionIndicator = conversionIndicator;
	}
	public String getCurrencyCode() {
		return currencyCode;
	}
	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}
	public BigDecimal getRate() {
		return rate;
	}
	public void setRate(BigDecimal rate) {
		this.rate = rate;
	}
}
