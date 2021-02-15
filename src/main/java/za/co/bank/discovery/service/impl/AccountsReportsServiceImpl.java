package za.co.bank.discovery.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import za.co.bank.discovery.repository.IClientAccount;
import za.co.bank.discovery.service.AccountsReportsService;
import za.co.bank.discovery.service.dto.AccountReportAggregationDto;
import za.co.bank.discovery.service.dto.AccountReportsDto;

@Service
public class AccountsReportsServiceImpl implements AccountsReportsService {

	@Autowired 
	private IClientAccount accountsReportsRepo;
	
	@Override
	public List<AccountReportsDto> findAllAccountsWithHighestBalance() {
		// TODO Auto-generated method stub
		return accountsReportsRepo.searchAllAccountsByBalanceCount();
	}

	@Override
	public AccountReportAggregationDto findFinancialStandingById(Integer clientId) {
		// TODO Auto-generated method stub
		return accountsReportsRepo.findFinancialStandingById(clientId);
	}
}
