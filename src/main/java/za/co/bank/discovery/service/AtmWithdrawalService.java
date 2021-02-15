package za.co.bank.discovery.service;

import java.math.BigDecimal;
import java.util.List;

import za.co.bank.discovery.service.dto.AtmDenominationDto;
import za.co.bank.discovery.service.dto.WithdrawalRequestDto;
import za.co.bank.discovery.web.rest.utils.RestExceptionUtil;

public interface AtmWithdrawalService {
	List<AtmDenominationDto> executeWithdrawal(WithdrawalRequestDto withdrawalRequestDto, Integer id)
			throws RestExceptionUtil;

	List<AtmDenominationDto> findDispensableAtm(Integer atmId, BigDecimal amountRequest) throws RestExceptionUtil;

	void updateRemainingAccountBalance(String accountNumber, BigDecimal balance);
}
