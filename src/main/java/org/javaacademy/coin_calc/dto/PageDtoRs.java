package org.javaacademy.coin_calc.dto;

import lombok.Data;
import lombok.NonNull;

@Data
public class PageDtoRs<T> {
	@NonNull
	private Integer size;
	@NonNull
	private T content;
}
