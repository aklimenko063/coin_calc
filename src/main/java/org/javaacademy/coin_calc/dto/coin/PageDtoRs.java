package org.javaacademy.coin_calc.dto.coin;

import lombok.Data;
import lombok.NonNull;

@Data
public class PageDtoRs<T> {
	@NonNull
	private Integer size;
	@NonNull
	private T content;
}
