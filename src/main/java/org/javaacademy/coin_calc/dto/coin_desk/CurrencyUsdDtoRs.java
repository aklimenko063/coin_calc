package org.javaacademy.coin_calc.dto.coin_desk;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class CurrencyUsdDtoRs {
	@JsonProperty("rate_float")
	private BigDecimal rateUsd;
}
