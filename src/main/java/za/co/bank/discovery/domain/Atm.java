package za.co.bank.discovery.domain;

import javax.persistence.*;

import java.io.Serializable;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Atm implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = -2958417484911946659L;
	private int atmId;
    private String name;
    private String location;
    private Collection<AtmAllocation> atmAllocationsByAtmId;

    @Id
    @Column(name = "ATM_ID")
    public int getAtmId() {
        return atmId;
    }

    public void setAtmId(int atmId) {
        this.atmId = atmId;
    }

    @Basic
    @Column(name = "NAME")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "LOCATION")
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Atm atm = (Atm) o;
        return atmId == atm.atmId &&
                Objects.equals(name, atm.name) &&
                Objects.equals(location, atm.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(atmId, name, location);
    }

    @OneToMany(mappedBy = "atmByAtmId")
    public Collection<AtmAllocation> getAtmAllocationsByAtmId() {
        return atmAllocationsByAtmId;
    }

    public void setAtmAllocationsByAtmId(Collection<AtmAllocation> atmAllocationsByAtmId) {
        this.atmAllocationsByAtmId = atmAllocationsByAtmId;
    }
}
