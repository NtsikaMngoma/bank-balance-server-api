package za.co.bank.discovery.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import za.co.bank.discovery.domain.Denomination;

@Repository
public interface IDenomination extends JpaRepository<Denomination, Integer> {
	@Query(value = "select * from denomination where DENOMINATION_TYPE_CODE = :typeCode", nativeQuery = true)
	List<Denomination> findAllByDenominationType(@Param("typeCode") String typeCode);
}
