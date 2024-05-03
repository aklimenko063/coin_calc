package org.javaacademy.coin_calc.service;

import lombok.RequiredArgsConstructor;
import org.javaacademy.coin_calc.config.FreeCurrencyProperties;
import org.javaacademy.coin_calc.dto.free_currency.CurrencyDtoRq;
import org.javaacademy.coin_calc.dto.coin.CurrencyDtoRs;
import org.javaacademy.coin_calc.dto.free_currency.FreeCurrencyDtoRs;
import org.javaacademy.coin_calc.exception.ServiceException;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
@RequiredArgsConstructor
public class FreeCurrencyClientService {
	private static final String POSTFIX_URL_GET_RUB_TEMPLATE = "/latest?currencies=%s";
	private final FreeCurrencyProperties freeCurrencyProperties;

	public CurrencyDtoRs convertCurrency(RestTemplate restTemplate, CurrencyDtoRq currencyDtoRq) {
		String postfixUrl = POSTFIX_URL_GET_RUB_TEMPLATE.formatted(currencyDtoRq.getToCurrencyName());
		RequestEntity<Void> request = RequestEntity
				.get(freeCurrencyProperties.getBaseUrl() + postfixUrl)
				.header(freeCurrencyProperties.getHeaderTokenName(), freeCurrencyProperties.getToken())
				.build();
		ResponseEntity<FreeCurrencyDtoRs> response;
		try {
			response = restTemplate.exchange(request, FreeCurrencyDtoRs.class);
		} catch (Throwable throwable) {
			throw new ServiceException("Сервис получения курса валют недоступен!");
		}
		FreeCurrencyDtoRs freeCurrencyDtoRs = response.getBody();
		BigDecimal rubRate = freeCurrencyDtoRs.getData().get(currencyDtoRq.getToCurrencyName());
		BigDecimal rubAmount = currencyDtoRq.getAmountUsd().multiply(rubRate).setScale(2, RoundingMode.CEILING);
		return new CurrencyDtoRs(currencyDtoRq.getToCurrencyName(), rubAmount, currencyDtoRq.getAmountUsd(), rubRate);
	}
}
