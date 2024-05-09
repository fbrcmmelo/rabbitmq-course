package br.com.fabri.stockconsumer.config;

import java.util.List;

import org.springframework.amqp.support.converter.SimpleMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMqConsumerConfig {

	@Bean("methodConverter")
	public SimpleMessageConverter methodMessageConverter() {
		SimpleMessageConverter converter = new SimpleMessageConverter();
		converter.setAllowedListPatterns(List.of("br.com.fabri.dto.StockDTO"));
		return converter;
	}
}
