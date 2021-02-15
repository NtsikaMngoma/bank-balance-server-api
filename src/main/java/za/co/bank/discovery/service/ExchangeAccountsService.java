package za.co.bank.discovery.service;

import java.util.List;

import za.co.bank.discovery.service.dto.ExchangeAccountsDto;
import za.co.bank.discovery.web.rest.utils.RestExceptionUtil;

public interface ExchangeAccountsService {

	List<ExchangeAccountsDto> searchTransactionalAccountsByCurrencyValue(Integer id, boolean transactional)
			throws RestExceptionUtil;
}
