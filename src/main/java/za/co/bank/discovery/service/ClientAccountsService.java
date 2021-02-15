package za.co.bank.discovery.service;

import java.util.List;

import za.co.bank.discovery.service.dto.ClientAccountsDto;

public interface ClientAccountsService {

	List<ClientAccountsDto> findTransactionalAccountById(Integer id, boolean transactional) throws Exception;

}
