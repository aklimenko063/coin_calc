package org.javaacademy.coin_calc.exception;

import lombok.experimental.StandardException;

@StandardException
public class ServiceException extends RuntimeException {
	public ServiceException(String message) {
		super(message);
	}
}
