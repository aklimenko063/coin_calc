package org.javaacademy.coin_calc.controller;

import lombok.RequiredArgsConstructor;
import org.javaacademy.coin_calc.dto.coin.CoinAverageDtoRs;
import org.javaacademy.coin_calc.dto.coin.CoinHistoryDtoRs;
import org.javaacademy.coin_calc.dto.coin.PageDtoRs;
import org.javaacademy.coin_calc.service.CoinService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rate")
@RequiredArgsConstructor
public class CoinController {
	private final CoinService coinService;

	@GetMapping("/now")
	public ResponseEntity getCurrentRate() {
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(coinService.getCurrentRateRub());
	}

	@GetMapping("/history")
	public PageDtoRs<List<CoinHistoryDtoRs>> getHistoryRate() {
		return coinService.getHistoryRate();
	}

	@GetMapping("/average")
	public CoinAverageDtoRs getAverageRate() {
		return coinService.getAverageRate();
	}
}
