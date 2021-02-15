package za.co.bank.discovery.domain;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "client_type", schema = "discovery_bank_schema")
public class ClientType implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = -8661674328501399278L;
	private String clientTypeCode;
    private String description;
    private Collection<ClientSubType> clientSubTypesByClientTypeCode;

    @Id
    @Column(name = "CLIENT_TYPE_CODE")
    public String getClientTypeCode() {
        return clientTypeCode;
    }

    public void setClientTypeCode(String clientTypeCode) {
        this.clientTypeCode = clientTypeCode;
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
        ClientType that = (ClientType) o;
        return Objects.equals(clientTypeCode, that.clientTypeCode) &&
                Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(clientTypeCode, description);
    }

    @JsonIgnore
    @OneToMany(mappedBy = "clientTypeByClientTypeCode")
    public Collection<ClientSubType> getClientSubTypesByClientTypeCode() {
        return clientSubTypesByClientTypeCode;
    }

    public void setClientSubTypesByClientTypeCode(Collection<ClientSubType> clientSubTypesByClientTypeCode) {
        this.clientSubTypesByClientTypeCode = clientSubTypesByClientTypeCode;
    }
}
