package za.co.bank.discovery.service.dto;

import java.io.Serializable;
import java.math.BigDecimal;

public class WithdrawalRequestDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String accountNumber;
    private String accountType;
    private BigDecimal withdrawalAmt;
    private int atmId;
    private int clientId;
    
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public BigDecimal getWithdrawalAmt() {
		return withdrawalAmt;
	}
	public void setWithdrawalAmt(BigDecimal withdrawalAmt) {
		this.withdrawalAmt = withdrawalAmt;
	}
	public int getAtmId() {
		return atmId;
	}
	public void setAtmId(int atmId) {
		this.atmId = atmId;
	}
	public int getClientId() {
		return clientId;
	}
	public void setClientId(int clientId) {
		this.clientId = clientId;
	}
	
}
