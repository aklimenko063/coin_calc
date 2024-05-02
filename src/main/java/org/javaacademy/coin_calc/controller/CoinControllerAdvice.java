package org.javaacademy.coin_calc.controller;

import org.javaacademy.coin_calc.exception.ServiceException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CoinControllerAdvice {

	@ExceptionHandler(ServiceException.class)
	public ResponseEntity<String> handleServerException(Exception e) {
		return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE)
				.body(e.getMessage());
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> handleException(Exception e) {
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
				.body("На сайте наблюдаются проблемы, приходите позже!");
	}
}
