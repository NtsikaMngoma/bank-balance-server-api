package za.co.bank.discovery.domain;

import javax.persistence.*;

import java.io.Serializable;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Denomination implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = -7492308161409566832L;
	private int denominationId;
    private int value;
    private Collection<AtmAllocation> atmAllocationsByDenominationId;
    private DenominationType denominationTypeByDenominationTypeCode;

    @Id
    @Column(name = "DENOMINATION_ID")
    public int getDenominationId() {
        return denominationId;
    }

    public void setDenominationId(int denominationId) {
        this.denominationId = denominationId;
    }

    @Basic
    @Column(name = "VALUE")
    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Denomination that = (Denomination) o;
        return denominationId == that.denominationId &&
                value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(denominationId, value);
    }

    @OneToMany(mappedBy = "denominationByDenominationId")
    public Collection<AtmAllocation> getAtmAllocationsByDenominationId() {
        return atmAllocationsByDenominationId;
    }

    public void setAtmAllocationsByDenominationId(Collection<AtmAllocation> atmAllocationsByDenominationId) {
        this.atmAllocationsByDenominationId = atmAllocationsByDenominationId;
    }

    @ManyToOne
    @JoinColumn(name = "DENOMINATION_TYPE_CODE", referencedColumnName = "DENOMINATION_TYPE_CODE")
    public DenominationType getDenominationTypeByDenominationTypeCode() {
        return denominationTypeByDenominationTypeCode;
    }

    public void setDenominationTypeByDenominationTypeCode(DenominationType denominationTypeByDenominationTypeCode) {
        this.denominationTypeByDenominationTypeCode = denominationTypeByDenominationTypeCode;
    }
}
