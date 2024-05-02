package org.javaacademy.coin_calc.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class CoinDeskDtoRs {
	@JsonProperty("bpi")
	private BpiDtoRs bpiDtoRs;
}
