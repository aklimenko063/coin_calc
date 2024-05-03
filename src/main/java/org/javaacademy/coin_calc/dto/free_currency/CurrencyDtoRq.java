package org.javaacademy.coin_calc.dto.free_currency;

import lombok.Value;

import java.math.BigDecimal;

@Value
public class CurrencyDtoRq {
	String toCurrencyName;
	BigDecimal amountUsd;
}
