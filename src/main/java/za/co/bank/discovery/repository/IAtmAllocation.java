package za.co.bank.discovery.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import za.co.bank.discovery.domain.AtmAllocation;
import za.co.bank.discovery.service.dto.AtmAllocationDto;

@Repository
public interface IAtmAllocation extends JpaRepository<AtmAllocation, Integer>{

	@Query(name = "atmAllocation.withdrawal", nativeQuery = true)
	List<AtmAllocationDto> findAllocationsById(@Param("atmId") Integer atmId);
}
