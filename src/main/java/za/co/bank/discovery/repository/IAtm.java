package za.co.bank.discovery.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import za.co.bank.discovery.domain.Atm;

@Repository
public interface IAtm extends JpaRepository<Atm, Integer>{
	
}
