package za.co.bank.discovery.domain;

import javax.persistence.*;

import java.io.Serializable;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "denomination_type", schema = "discovery_bank_schema")
public class DenominationType implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = -3943060830329209690L;
	private String denominationTypeCode;
    private String description;
    private Collection<Denomination> denominationsByDenominationTypeCode;

    @Id
    @Column(name = "DENOMINATION_TYPE_CODE")
    public String getDenominationTypeCode() {
        return denominationTypeCode;
    }

    public void setDenominationTypeCode(String denominationTypeCode) {
        this.denominationTypeCode = denominationTypeCode;
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
        DenominationType that = (DenominationType) o;
        return Objects.equals(denominationTypeCode, that.denominationTypeCode) &&
                Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(denominationTypeCode, description);
    }

    @OneToMany(mappedBy = "denominationTypeByDenominationTypeCode")
    public Collection<Denomination> getDenominationsByDenominationTypeCode() {
        return denominationsByDenominationTypeCode;
    }

    public void setDenominationsByDenominationTypeCode(Collection<Denomination> denominationsByDenominationTypeCode) {
        this.denominationsByDenominationTypeCode = denominationsByDenominationTypeCode;
    }
}
