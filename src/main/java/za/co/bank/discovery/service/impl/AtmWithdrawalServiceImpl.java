package za.co.bank.discovery.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import za.co.bank.discovery.domain.ClientAccount;
import za.co.bank.discovery.repository.IAtmAllocation;
import za.co.bank.discovery.repository.IClientAccount;
import za.co.bank.discovery.service.AtmWithdrawalService;
import za.co.bank.discovery.service.dto.AtmAllocationDto;
import za.co.bank.discovery.service.dto.AtmDenominationDto;
import za.co.bank.discovery.service.dto.WithdrawalRequestDto;
import za.co.bank.discovery.web.rest.utils.RestExceptionUtil;

@Service
@Transactional
public class AtmWithdrawalServiceImpl implements AtmWithdrawalService {

	@Autowired
	private IClientAccount clientAccountRepo;

	@Autowired
	private IAtmAllocation atmAllocationRepo;

	@Override
	public List<AtmDenominationDto> executeWithdrawal(WithdrawalRequestDto withdrawalRequestDto, Integer id)
			throws RestExceptionUtil {
		List<AtmDenominationDto> atmDenominationDtos;
		BigDecimal withdrawalBalance;
		ClientAccount clientAccountInfo = clientAccountRepo
				.findByClientAccountNumber(withdrawalRequestDto.getAccountNumber());

		if (clientAccountInfo.getAccountTypeByAccountTypeCode().getAccountTypeCode().equals("CHQ")) {
			int i = clientAccountInfo.getDisplayBalance().subtract(withdrawalRequestDto.getWithdrawalAmt()).intValue();
			if (clientAccountInfo.getDisplayBalance().compareTo(new BigDecimal(-10000)) == -1 || i < -10000) {
				throw new RestExceptionUtil("Your cheque account has insufficient funds.");
			}
			atmDenominationDtos = findDispensableAtm(withdrawalRequestDto.getAtmId(),
					withdrawalRequestDto.getWithdrawalAmt());
			withdrawalBalance = clientAccountInfo.getDisplayBalance().subtract(withdrawalRequestDto.getWithdrawalAmt());
			updateRemainingAccountBalance(clientAccountInfo.getClientAccountNumber(), withdrawalBalance);
		} else {
			if (clientAccountInfo.getDisplayBalance().compareTo(withdrawalRequestDto.getWithdrawalAmt()) == -1) {
				throw new RestExceptionUtil("Your account has insufficient funds");
			}
			atmDenominationDtos = findDispensableAtm(withdrawalRequestDto.getAtmId(),
					withdrawalRequestDto.getWithdrawalAmt());
			withdrawalBalance = clientAccountInfo.getDisplayBalance().subtract(withdrawalRequestDto.getWithdrawalAmt());
			updateRemainingAccountBalance(clientAccountInfo.getClientAccountNumber(), withdrawalBalance);
		}
		return atmDenominationDtos;
	}

	@Override
	public List<AtmDenominationDto> findDispensableAtm(Integer atmId, BigDecimal amountRequest)
			throws RestExceptionUtil {
		List<AtmAllocationDto> atmAllocations = atmAllocationRepo.findAllocationsById(atmId);

		int atmAllocationSum = 0;
		for (AtmAllocationDto atmAllocationDto : atmAllocations) {
			atmAllocationSum += atmAllocationSum + atmAllocationDto.getDenominationSum();
		}

		if (amountRequest.compareTo(new BigDecimal(atmAllocationSum)) == 1) {
			throw new RestExceptionUtil(
					String.format("Amount not available, would you like to withdraw R %d", atmAllocationSum));
		}

		List<AtmDenominationDto> atmDenominationDtos = new ArrayList<>();
		int countNotes = 0;
		BigDecimal tempDispensableBalance = amountRequest;
		for (AtmAllocationDto allocDto : atmAllocations) {
			if (allocDto.getCount() > 0) {
				if (tempDispensableBalance.remainder(new BigDecimal(allocDto.getValue()))
						.compareTo(BigDecimal.ZERO) == 0) {
					countNotes = tempDispensableBalance.divide(new BigDecimal(allocDto.getValue())).intValue();
					if (allocDto.getCount() >= countNotes) {
						int bal = allocDto.getCount() - countNotes;
						atmDenominationDtos.add(new AtmDenominationDto(allocDto.getValue(), bal));
						tempDispensableBalance = BigDecimal.ZERO;
						break;
					} else {
						atmDenominationDtos.add(new AtmDenominationDto(allocDto.getValue(), allocDto.getCount()));
						allocDto.getCount().equals(0);
						tempDispensableBalance = tempDispensableBalance
								.subtract(new BigDecimal(allocDto.getDenominationSum()));
					}
				} else if (tempDispensableBalance.divide(new BigDecimal(allocDto.getValue())).intValue() >= 1) {
					countNotes = tempDispensableBalance.divide(new BigDecimal(allocDto.getValue())).intValue();
					atmDenominationDtos.add(new AtmDenominationDto(atmAllocationSum, countNotes));
					int bal = allocDto.getCount() - countNotes;
					tempDispensableBalance = tempDispensableBalance.subtract(new BigDecimal(bal * allocDto.getValue()));
				}
			}
		}
		return atmDenominationDtos;
	}

	@Override
	public void updateRemainingAccountBalance(String accountNumber, BigDecimal balance) {
		clientAccountRepo.updateClientAccountBalance(accountNumber, balance);
	}
}
