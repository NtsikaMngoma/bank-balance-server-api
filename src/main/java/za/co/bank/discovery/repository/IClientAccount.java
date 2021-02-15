package za.co.bank.discovery.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import za.co.bank.discovery.domain.ClientAccount;
import za.co.bank.discovery.service.dto.AccountReportAggregationDto;
import za.co.bank.discovery.service.dto.AccountReportsDto;
import za.co.bank.discovery.service.dto.ClientAccountsDto;
import za.co.bank.discovery.service.dto.ExchangeAccountsDto;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface IClientAccount extends JpaRepository<ClientAccount, String> {

	@Query(name = "clientAccount.searchTransactionalAccountsByClientId", nativeQuery = true)
	List<ClientAccountsDto> findTransactionalAccountsByClientId(@Param("clientId") Integer clientId,
			@Param("transactional") boolean transactional);

	@Query(name = "currencyAccount.searchTransactionalAccountsByCurrencyValue", nativeQuery = true)
	List<ExchangeAccountsDto> searchTransactionalAccountsByCurrencyValue(@Param("clientId") Integer clientId,
			@Param("transactional") boolean transactional);

	@Query(name = "reporting.searchAllAccountsByBalanceCount", nativeQuery = true)
	List<AccountReportsDto> searchAllAccountsByBalanceCount();

	@Query(name = "aggregationQuery.findFinancialStandingById", nativeQuery = true)
	AccountReportAggregationDto findFinancialStandingById(@Param("clientId") Integer clientId);

	@Query(name = "transactionalQuery.isTransactionalAccount", nativeQuery = true)
	Boolean isTransactionalAccount(@Param("accountNumber") String accountNumber);

	@Query(name = "clientAccount.findAccountTypeCode", nativeQuery = true)
	String getAccountTypeCode(@Param("accountNumber") String accountNumber);

	ClientAccount findByClientAccountNumber(String accountNumber);

	@Modifying
	@Transactional
	@Query(name = "updateClientAccountBalance", nativeQuery = true)
	void updateClientAccountBalance(@Param("accountNumber") String accountNumber,
			@Param("remainingBalance") BigDecimal remainingBalance);
}
