package org.javaacademy.coin_calc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class CoinCalcApplication {

	public static void main(String[] args) {
		SpringApplication.run(CoinCalcApplication.class, args);
	}

}
