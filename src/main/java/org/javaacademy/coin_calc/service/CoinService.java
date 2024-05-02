package org.javaacademy.coin_calc.service;

import lombok.RequiredArgsConstructor;
import org.javaacademy.coin_calc.dto.*;
import org.javaacademy.coin_calc.repository.CoinServiceRepository;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
@CacheConfig(cacheNames = "coin")
public class CoinService {
	private static final String CURRENCY_NAME = "RUB";
	private final RestTemplate restTemplate;
	private final CoinDeskClientService coinDeskClientService;
	private final FreeCurrencyClientService freeCurrencyClientService;
	private final CoinServiceRepository coinServiceRepository;

	@CacheEvict(cacheNames = "coin", allEntries = true)
	public CurrencyDtoRs getCurrentRateRub() {
		CoinDeskDtoRs currentRateUSD = coinDeskClientService.getCurrentRateUSD(restTemplate);
		BigDecimal coinRate = currentRateUSD.getBpiDtoRs().getUsdDtoRs().getRateUsd();
		CurrencyDtoRq currencyDtoRq = new CurrencyDtoRq(CURRENCY_NAME, coinRate);
		CurrencyDtoRs currencyDtoRs = freeCurrencyClientService.convertCurrency(restTemplate, currencyDtoRq);
		coinServiceRepository.addValue(currencyDtoRs.getAmountRub());
		return currencyDtoRs;
	}

	@Cacheable(cacheNames = "coin")
	public PageDtoRs<List<CoinHistoryDtoRs>> getHistoryRate() {
		List<CoinHistoryDtoRs> coinHistoryDtoRs = coinServiceRepository.getAllData();
		return new PageDtoRs<>(coinHistoryDtoRs.size(),
				coinHistoryDtoRs);
	}

	@Cacheable(cacheNames = "coin")
	public CoinAverageDtoRs getAverageRate() {
		List<CoinHistoryDtoRs> coinHistoryDtoRs = coinServiceRepository.getAllData();
		int sizeList = coinHistoryDtoRs.size();
		BigDecimal totalAmount = coinHistoryDtoRs
				.stream()
				.map(e -> e.getAmountRub())
				.reduce((a, b) -> a.add(b))
				.orElseThrow();
		BigDecimal divide = totalAmount.divide(BigDecimal.valueOf(sizeList));
		return new CoinAverageDtoRs(divide);
	}
}
