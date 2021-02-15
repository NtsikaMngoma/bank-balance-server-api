package za.co.bank.discovery.domain;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.sql.Date;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Client implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = -5540877767590826568L;
	private int clientId;
    private String title;
    private String name;
    private String surname;
    private Date dob;
    private ClientSubType clientSubTypeByClientSubTypeCode;
    private Collection<ClientAccount> clientAccountsByClientId;

    @Id
    @Column(name = "CLIENT_ID")
    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    @Basic
    @Column(name = "TITLE")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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
    @Column(name = "SURNAME")
    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Basic
    @Column(name = "DOB")
    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return clientId == client.clientId &&
                Objects.equals(title, client.title) &&
                Objects.equals(name, client.name) &&
                Objects.equals(surname, client.surname) &&
                Objects.equals(dob, client.dob);
    }

    @Override
    public int hashCode() {
        return Objects.hash(clientId, title, name, surname, dob);
    }

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "CLIENT_SUB_TYPE_CODE", referencedColumnName = "CLIENT_SUB_TYPE_CODE", nullable = false)
    public ClientSubType getClientSubTypeByClientSubTypeCode() {
        return clientSubTypeByClientSubTypeCode;
    }

    public void setClientSubTypeByClientSubTypeCode(ClientSubType clientSubTypeByClientSubTypeCode) {
        this.clientSubTypeByClientSubTypeCode = clientSubTypeByClientSubTypeCode;
    }

    @OneToMany(mappedBy = "clientByClientId")
    @JsonIgnore
    public Collection<ClientAccount> getClientAccountsByClientId() {
        return clientAccountsByClientId;
    }

    public void setClientAccountsByClientId(Collection<ClientAccount> clientAccountsByClientId) {
        this.clientAccountsByClientId = clientAccountsByClientId;
    }
}
