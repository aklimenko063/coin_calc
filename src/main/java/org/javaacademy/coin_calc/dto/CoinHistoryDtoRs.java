package org.javaacademy.coin_calc.dto;

import lombok.Data;
import lombok.NonNull;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class CoinHistoryDtoRs {
	@NonNull
	private LocalDateTime localDateTime;
	@NonNull
	private BigDecimal amountRub;
}
