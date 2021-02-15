package za.co.bank.discovery.domain;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModel;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@ApiModel
@Table(name = "client_account", schema = "discovery_bank_schema")
public class ClientAccount implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = -4875790909577285012L;
	private String clientAccountNumber;
    private BigDecimal displayBalance;
    private Client clientByClientId;
    private AccountType accountTypeByAccountTypeCode;
    private Currency currencyByCurrencyCode;
    private CreditCardLimit creditCardLimitByClientAccountNumber;

    @Id
    @Column(name = "CLIENT_ACCOUNT_NUMBER")
    public String getClientAccountNumber() {
        return clientAccountNumber;
    }

    public void setClientAccountNumber(String clientAccountNumber) {
        this.clientAccountNumber = clientAccountNumber;
    }

    @Basic
    @Column(name = "DISPLAY_BALANCE")
    public BigDecimal getDisplayBalance() {
        return displayBalance;
    }

    public void setDisplayBalance(BigDecimal displayBalance) {
        this.displayBalance = displayBalance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClientAccount that = (ClientAccount) o;
        return Objects.equals(clientAccountNumber, that.clientAccountNumber) &&
                Objects.equals(displayBalance, that.displayBalance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(clientAccountNumber, displayBalance);
    }

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "CLIENT_ID", referencedColumnName = "CLIENT_ID", nullable = false)
    public Client getClientByClientId() {
        return clientByClientId;
    }

    public void setClientByClientId(Client clientByClientId) {
        this.clientByClientId = clientByClientId;
    }

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "ACCOUNT_TYPE_CODE", referencedColumnName = "ACCOUNT_TYPE_CODE", nullable = false)
    public AccountType getAccountTypeByAccountTypeCode() {
        return accountTypeByAccountTypeCode;
    }

    public void setAccountTypeByAccountTypeCode(AccountType accountTypeByAccountTypeCode) {
        this.accountTypeByAccountTypeCode = accountTypeByAccountTypeCode;
    }

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "CURRENCY_CODE", referencedColumnName = "CURRENCY_CODE", nullable = false)
    public Currency getCurrencyByCurrencyCode() {
        return currencyByCurrencyCode;
    }

    public void setCurrencyByCurrencyCode(Currency currencyByCurrencyCode) {
        this.currencyByCurrencyCode = currencyByCurrencyCode;
    }

    @JsonIgnore
    @OneToOne(mappedBy = "clientAccountByClientAccountNumber")
    public CreditCardLimit getCreditCardLimitByClientAccountNumber() {
        return creditCardLimitByClientAccountNumber;
    }

    public void setCreditCardLimitByClientAccountNumber(CreditCardLimit creditCardLimitByClientAccountNumber) {
        this.creditCardLimitByClientAccountNumber = creditCardLimitByClientAccountNumber;
    }
}
