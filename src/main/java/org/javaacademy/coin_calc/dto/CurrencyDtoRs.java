package org.javaacademy.coin_calc.dto;

import lombok.Value;

import java.math.BigDecimal;

@Value
public class CurrencyDtoRs {
	String currencyName;
	BigDecimal amountRub;
	BigDecimal amountUsd;
	BigDecimal rateRub;
}
