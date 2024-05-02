package org.javaacademy.coin_calc.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@ConfigurationProperties(prefix = "integration.freecurrency")
@Getter
@Configuration
@Setter
public class FreeCurrencyProperties {
	private String baseUrl;
	private String headerTokenName;
	private String token;
}
