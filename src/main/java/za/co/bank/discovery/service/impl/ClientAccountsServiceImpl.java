package za.co.bank.discovery.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import za.co.bank.discovery.repository.IClientAccount;
import za.co.bank.discovery.service.ClientAccountsService;
import za.co.bank.discovery.service.dto.ClientAccountsDto;

@Service
public class ClientAccountsServiceImpl implements ClientAccountsService {

	@Autowired
	private IClientAccount clientAccountRepo;

	@Override
	public List<ClientAccountsDto> findTransactionalAccountById(Integer id, boolean transactional) throws Exception {
		// TODO Auto-generated method stub
		return clientAccountRepo.findTransactionalAccountsByClientId(id, transactional);
	}

}
