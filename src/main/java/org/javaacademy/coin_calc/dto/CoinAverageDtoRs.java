package org.javaacademy.coin_calc.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CoinAverageDtoRs {
	private BigDecimal averageRub;
}
