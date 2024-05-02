package org.javaacademy.coin_calc.service;

import lombok.RequiredArgsConstructor;
import org.javaacademy.coin_calc.config.CoinDeskProperties;
import org.javaacademy.coin_calc.dto.CoinDeskDtoRs;
import org.javaacademy.coin_calc.exception.ServiceException;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class CoinDeskClientService {
	private final static String POSTFIX_URL_GET_USD_TEMPLATE = "/bpi/currentprice/USD.json";
	private final CoinDeskProperties coinDeskProperties;

	public CoinDeskDtoRs getCurrentRateUSD(RestTemplate restTemplate) {
		RequestEntity<Void> requestCoinDesk = RequestEntity
				.get(coinDeskProperties.getBaseUrl() + POSTFIX_URL_GET_USD_TEMPLATE)
				.build();
		ResponseEntity<CoinDeskDtoRs> responseCoinDesk;
		try {
			responseCoinDesk = restTemplate.exchange(requestCoinDesk, CoinDeskDtoRs.class);
		} catch (Throwable throwable) {
			throw new ServiceException("Сервис получения курса биткоина недоступен!");
		}
		CoinDeskDtoRs coinDeskDtoRs = responseCoinDesk.getBody();
		return coinDeskDtoRs;
	}
}
