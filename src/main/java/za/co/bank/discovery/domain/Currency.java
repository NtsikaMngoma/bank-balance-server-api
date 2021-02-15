package za.co.bank.discovery.domain;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Currency implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = -5470404314202440145L;
	private String currencyCode;
    private int decimalPlaces;
    private String description;
    private Collection<ClientAccount> clientAccountsByCurrencyCode;
    private CurrencyConversionRate currencyConversionRateByCurrencyCode;

    @Id
    @Column(name = "CURRENCY_CODE")
    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    @Basic
    @Column(name = "DECIMAL_PLACES")
    public int getDecimalPlaces() {
        return decimalPlaces;
    }

    public void setDecimalPlaces(int decimalPlaces) {
        this.decimalPlaces = decimalPlaces;
    }

    @Basic
    @Column(name = "DESCRIPTION")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Currency currency = (Currency) o;
        return decimalPlaces == currency.decimalPlaces &&
                Objects.equals(currencyCode, currency.currencyCode) &&
                Objects.equals(description, currency.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(currencyCode, decimalPlaces, description);
    }

    @JsonIgnore
    @OneToMany(mappedBy = "currencyByCurrencyCode")
    public Collection<ClientAccount> getClientAccountsByCurrencyCode() {
        return clientAccountsByCurrencyCode;
    }

    public void setClientAccountsByCurrencyCode(Collection<ClientAccount> clientAccountsByCurrencyCode) {
        this.clientAccountsByCurrencyCode = clientAccountsByCurrencyCode;
    }

    @JsonIgnore
    @OneToOne(mappedBy = "currencyByCurrencyCode")
    public CurrencyConversionRate getCurrencyConversionRateByCurrencyCode() {
        return currencyConversionRateByCurrencyCode;
    }

    public void setCurrencyConversionRateByCurrencyCode(CurrencyConversionRate currencyConversionRateByCurrencyCode) {
        this.currencyConversionRateByCurrencyCode = currencyConversionRateByCurrencyCode;
    }
}
