package org.javaacademy.coin_calc.dto;

import lombok.Value;

import java.math.BigDecimal;

@Value
public class CurrencyDtoRq {
	String toCurrencyName; // to rub
	BigDecimal amountUsd; // курс битка
}
