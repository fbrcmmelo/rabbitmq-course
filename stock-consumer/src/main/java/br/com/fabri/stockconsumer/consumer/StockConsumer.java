package br.com.fabri.stockconsumer.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import br.com.fabri.consts.QueueConstants;
import br.com.fabri.dto.StockDTO;

@Component
public class StockConsumer {

	private final Logger log = LoggerFactory.getLogger(StockConsumer.class);

	@RabbitListener(queues = QueueConstants.STOCK, messageConverter = "methodConverter")
	public void consume(StockDTO dto) {
		log.info("Cosuming new message from queue: {}", QueueConstants.STOCK);
		log.info("message: {}", dto.toString());
	}
}
