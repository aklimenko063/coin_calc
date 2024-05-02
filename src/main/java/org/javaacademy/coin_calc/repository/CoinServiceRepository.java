package org.javaacademy.coin_calc.repository;

import org.javaacademy.coin_calc.dto.CoinHistoryDtoRs;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class CoinServiceRepository {
	private final Map<LocalDateTime, BigDecimal> coinServiceDb = new HashMap<>();

	public void addValue(BigDecimal amountRub) {
		coinServiceDb.put(LocalDateTime.now(), amountRub);
	}

	public List<CoinHistoryDtoRs> getAllData() {
		return coinServiceDb.entrySet()
				.stream()
				.map(e -> new CoinHistoryDtoRs(e.getKey(), e.getValue())).toList();
	}
}
