package za.co.bank.discovery.domain;

import javax.persistence.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "currency_conversion_rate", schema = "discovery_bank_schema")
public class CurrencyConversionRate implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 6046470571315903518L;
	private String currencyCode;
    private String conversionIndicator;
    private BigDecimal rate;
    private Currency currencyByCurrencyCode;

    @Id
    @Column(name = "CURRENCY_CODE")
    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    @Basic
    @Column(name = "CONVERSION_INDICATOR")
    public String getConversionIndicator() {
        return conversionIndicator;
    }

    public void setConversionIndicator(String conversionIndicator) {
        this.conversionIndicator = conversionIndicator;
    }

    @Basic
    @Column(name = "RATE")
    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CurrencyConversionRate that = (CurrencyConversionRate) o;
        return Objects.equals(currencyCode, that.currencyCode) &&
                Objects.equals(conversionIndicator, that.conversionIndicator) &&
                Objects.equals(rate, that.rate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(currencyCode, conversionIndicator, rate);
    }

    @OneToOne
    @JoinColumn(name = "CURRENCY_CODE", referencedColumnName = "CURRENCY_CODE", nullable = false)
    public Currency getCurrencyByCurrencyCode() {
        return currencyByCurrencyCode;
    }

    public void setCurrencyByCurrencyCode(Currency currencyByCurrencyCode) {
        this.currencyByCurrencyCode = currencyByCurrencyCode;
    }
}
