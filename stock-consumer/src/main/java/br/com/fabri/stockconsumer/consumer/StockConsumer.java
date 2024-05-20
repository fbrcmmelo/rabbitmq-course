package br.com.fabri.stockconsumer.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import br.com.fabri.consts.QueueConstants;

@Component
public class StockConsumer {

	private final Logger log = LoggerFactory.getLogger(StockConsumer.class);

	public void consume(String message) {
		log.info("Cosuming new message from queue: {}", QueueConstants.STOCK);
		log.info("message: {}", message);
	}
}
