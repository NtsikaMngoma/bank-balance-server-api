package za.co.bank.discovery.domain;

import javax.persistence.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "credit_card_limit", schema = "discovery_bank_schema")
public class CreditCardLimit implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = -6951871256526268554L;
	private String clientAccountNumber;
    private BigDecimal accountLimit;
    private ClientAccount clientAccountByClientAccountNumber;

    @Id
    @Column(name = "CLIENT_ACCOUNT_NUMBER")
    public String getClientAccountNumber() {
        return clientAccountNumber;
    }

    public void setClientAccountNumber(String clientAccountNumber) {
        this.clientAccountNumber = clientAccountNumber;
    }

    @Basic
    @Column(name = "ACCOUNT_LIMIT")
    public BigDecimal getAccountLimit() {
        return accountLimit;
    }

    public void setAccountLimit(BigDecimal accountLimit) {
        this.accountLimit = accountLimit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CreditCardLimit that = (CreditCardLimit) o;
        return Objects.equals(clientAccountNumber, that.clientAccountNumber) &&
                Objects.equals(accountLimit, that.accountLimit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(clientAccountNumber, accountLimit);
    }

    @OneToOne
    @JoinColumn(name = "CLIENT_ACCOUNT_NUMBER", referencedColumnName = "CLIENT_ACCOUNT_NUMBER", nullable = false)
    public ClientAccount getClientAccountByClientAccountNumber() {
        return clientAccountByClientAccountNumber;
    }

    public void setClientAccountByClientAccountNumber(ClientAccount clientAccountByClientAccountNumber) {
        this.clientAccountByClientAccountNumber = clientAccountByClientAccountNumber;
    }
}
