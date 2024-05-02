package org.javaacademy.coin_calc.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "integration.coindesk")
@Getter
@Setter
public class CoinDeskProperties {
	private String baseUrl;
}
