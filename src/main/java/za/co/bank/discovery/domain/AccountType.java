package za.co.bank.discovery.domain;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "account_type", schema = "discovery_bank_schema")
public class AccountType implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3293295080065671376L;
	private String accountTypeCode;
	private String description;
	private Boolean transactional;
	private Collection<ClientAccount> clientAccountsByAccountTypeCode;

	@Id
	@Column(name = "ACCOUNT_TYPE_CODE")
	public String getAccountTypeCode() {
		return accountTypeCode;
	}

	public void setAccountTypeCode(String accountTypeCode) {
		this.accountTypeCode = accountTypeCode;
	}

	@Basic
	@Column(name = "DESCRIPTION")
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Basic
	@Column(name = "TRANSACTIONAL")
	public Boolean getTransactional() {
		return transactional;
	}

	public void setTransactional(Boolean transactional) {
		this.transactional = transactional;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		AccountType that = (AccountType) o;
		return Objects.equals(accountTypeCode, that.accountTypeCode) && Objects.equals(description, that.description)
				&& Objects.equals(transactional, that.transactional);
	}

	@Override
	public int hashCode() {
		return Objects.hash(accountTypeCode, description, transactional);
	}

	@JsonIgnore
	@OneToMany(mappedBy = "accountTypeByAccountTypeCode")
	public Collection<ClientAccount> getClientAccountsByAccountTypeCode() {
		return clientAccountsByAccountTypeCode;
	}

	public void setClientAccountsByAccountTypeCode(Collection<ClientAccount> clientAccountsByAccountTypeCode) {
		this.clientAccountsByAccountTypeCode = clientAccountsByAccountTypeCode;
	}
}
