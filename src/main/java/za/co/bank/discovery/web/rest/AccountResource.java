package za.co.bank.discovery.web.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import za.co.bank.discovery.service.AccountsReportsService;
import za.co.bank.discovery.service.AtmWithdrawalService;
import za.co.bank.discovery.service.ClientAccountsService;
import za.co.bank.discovery.service.ExchangeAccountsService;
import za.co.bank.discovery.service.dto.AccountReportAggregationDto;
import za.co.bank.discovery.service.dto.AccountReportsDto;
import za.co.bank.discovery.service.dto.AtmDenominationDto;
import za.co.bank.discovery.service.dto.ClientAccountsDto;
import za.co.bank.discovery.service.dto.ExchangeAccountsDto;
import za.co.bank.discovery.service.dto.WithdrawalRequestDto;
import za.co.bank.discovery.web.rest.utils.RestConstants;

import java.util.List;

@RestController
@RequestMapping(RestConstants.BASE_ADDRESS)
public class AccountResource {

	private static final Logger log = LoggerFactory.getLogger(AccountResource.class);

	@Autowired
	private ClientAccountsService accountService;

	@Autowired
	private ExchangeAccountsService currencyAccountService;

	@Autowired
	private AccountsReportsService accountsReportsService;

	@Autowired
	private AtmWithdrawalService withdrawalService;

	@GetMapping(value = "/accounts/{clientId}/check", produces = "application/json")
	public List<ClientAccountsDto> getAccountByCriteria(@PathVariable Integer clientId,
			@RequestParam boolean transactional) throws Exception {
		log.debug("REST reuqest to search account by :id - " + clientId);
		return accountService.findTransactionalAccountById(clientId, transactional);
	}

	@GetMapping(value = "/currency-accounts/{clientId}/validate", produces = "application/json")
	public List<ExchangeAccountsDto> getAccountWithCurrencyCriteria(@PathVariable Integer clientId,
			@RequestParam boolean transactional) throws Exception {
		log.debug("REST reuqest to search currency account by :id - " + clientId);
		return currencyAccountService.searchTransactionalAccountsByCurrencyValue(clientId, transactional);
	}

	@GetMapping(value = "/account/withdraw", produces = "application/json")
	public List<AtmDenominationDto> accountWithdrawal(@RequestParam Integer clientId, @RequestBody WithdrawalRequestDto withdrawalRequestDto) {
		return withdrawalService.executeWithdrawal(withdrawalRequestDto, clientId);
	}

	@GetMapping(value = "/reports/max-bal", produces = "application/json")
	public List<AccountReportsDto> findAllHighestBalances() {
		log.debug("REST request to search highest balances");
		return accountsReportsService.findAllAccountsWithHighestBalance();
	}

	@GetMapping(value = "/report/aggregates/financial-standing", produces = "application/json")
	public AccountReportAggregationDto recieveAllAccountReports(@RequestParam Integer clientId) {
		return accountsReportsService.findFinancialStandingById(clientId);
	}
}
