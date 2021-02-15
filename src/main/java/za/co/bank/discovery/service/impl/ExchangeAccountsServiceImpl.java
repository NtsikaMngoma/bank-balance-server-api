package za.co.bank.discovery.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import za.co.bank.discovery.repository.IClientAccount;
import za.co.bank.discovery.service.ExchangeAccountsService;
import za.co.bank.discovery.service.dto.ExchangeAccountsDto;
import za.co.bank.discovery.web.rest.utils.RestExceptionUtil;

@Service
public class ExchangeAccountsServiceImpl implements ExchangeAccountsService {

	@Autowired
	private IClientAccount currencyAccountRepository;

	@Override
	public List<ExchangeAccountsDto> searchTransactionalAccountsByCurrencyValue(Integer id, boolean transactional)
			throws RestExceptionUtil {
		// TODO Auto-generated method stub
		List<ExchangeAccountsDto> currencyAccountList = currencyAccountRepository
				.searchTransactionalAccountsByCurrencyValue(id, transactional);
		if (currencyAccountList.size() == 0) {
			throw new RestExceptionUtil(String
					.format("Seems like #client := %d, has no " + "Exchange Currency as a transactional account!", id));
		}
		return currencyAccountList;
	}
}
