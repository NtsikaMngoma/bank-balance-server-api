package za.co.bank.discovery.service.dto;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Value;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public interface AccountReportAggregationDto {

	@Value("#{target.title + ' ' + target.name + ' ' + target.surname}")
	@JsonProperty("client")
	String getClient();

	BigDecimal getTransactionalBalance();

	BigDecimal getLoanBalance();

	@Value("#{target.loanBalance + target.transactionalBalance}")
	@JsonProperty("net_position")
	BigDecimal getNetPosition();
}
