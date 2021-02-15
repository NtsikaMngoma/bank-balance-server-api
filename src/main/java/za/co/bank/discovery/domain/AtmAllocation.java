package za.co.bank.discovery.domain;

import javax.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "atm_allocation", schema = "discovery_bank_schema")
public class AtmAllocation implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int atmAllocationId;
    private int count;
    private Atm atmByAtmId;
    private Denomination denominationByDenominationId;

    @Id
    @Column(name = "ATM_ALLOCATION_ID")
    public int getAtmAllocationId() {
        return atmAllocationId;
    }

    public void setAtmAllocationId(int atmAllocationId) {
        this.atmAllocationId = atmAllocationId;
    }

    @Basic
    @Column(name = "COUNT")
    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AtmAllocation that = (AtmAllocation) o;
        return atmAllocationId == that.atmAllocationId &&
                count == that.count;
    }

    @Override
    public int hashCode() {
        return Objects.hash(atmAllocationId, count);
    }

    @ManyToOne
    @JoinColumn(name = "ATM_ID", referencedColumnName = "ATM_ID", nullable = false)
    public Atm getAtmByAtmId() {
        return atmByAtmId;
    }

    public void setAtmByAtmId(Atm atmByAtmId) {
        this.atmByAtmId = atmByAtmId;
    }

    @ManyToOne
    @JoinColumn(name = "DENOMINATION_ID", referencedColumnName = "DENOMINATION_ID", nullable = false)
    public Denomination getDenominationByDenominationId() {
        return denominationByDenominationId;
    }

    public void setDenominationByDenominationId(Denomination denominationByDenominationId) {
        this.denominationByDenominationId = denominationByDenominationId;
    }
}
