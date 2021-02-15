package za.co.bank.discovery.domain;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "client_sub_type", schema = "discovery_bank_schema")
public class ClientSubType implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = -2983928728455313631L;
	private String clientSubTypeCode;
    private String description;
    private Collection<Client> clientsByClientSubTypeCode;
    private ClientType clientTypeByClientTypeCode;

    @Id
    @Column(name = "CLIENT_SUB_TYPE_CODE")
    public String getClientSubTypeCode() {
        return clientSubTypeCode;
    }

    public void setClientSubTypeCode(String clientSubTypeCode) {
        this.clientSubTypeCode = clientSubTypeCode;
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
        ClientSubType that = (ClientSubType) o;
        return Objects.equals(clientSubTypeCode, that.clientSubTypeCode) &&
                Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(clientSubTypeCode, description);
    }

    @JsonIgnore
    @OneToMany(mappedBy = "clientSubTypeByClientSubTypeCode")
    public Collection<Client> getClientsByClientSubTypeCode() {
        return clientsByClientSubTypeCode;
    }

    public void setClientsByClientSubTypeCode(Collection<Client> clientsByClientSubTypeCode) {
        this.clientsByClientSubTypeCode = clientsByClientSubTypeCode;
    }

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "CLIENT_TYPE_CODE", referencedColumnName = "CLIENT_TYPE_CODE", nullable = false)
    public ClientType getClientTypeByClientTypeCode() {
        return clientTypeByClientTypeCode;
    }

    public void setClientTypeByClientTypeCode(ClientType clientTypeByClientTypeCode) {
        this.clientTypeByClientTypeCode = clientTypeByClientTypeCode;
    }
}
