package za.co.bank.discovery.service;

import java.util.List;

import za.co.bank.discovery.service.dto.AccountReportAggregationDto;
import za.co.bank.discovery.service.dto.AccountReportsDto;

public interface AccountsReportsService {

	List<AccountReportsDto> findAllAccountsWithHighestBalance();
	AccountReportAggregationDto findFinancialStandingById(Integer clientId);
	
}
