package br.com.fabri.core.service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import br.com.fabri.api.dto.StockDTO;
import br.com.fabri.core.consts.QueueConstants;
import br.com.fabri.core.usecase.UpdateStockUseCase;

@Service
public class RabbitMqStockService implements UpdateStockUseCase {

	private final RabbitTemplate rabbitMQ;

	public RabbitMqStockService(RabbitTemplate rTemplate) {
		this.rabbitMQ = rTemplate;
	}

	@Override
	public void update(StockDTO dto) {
		this.rabbitMQ.convertAndSend(QueueConstants.STOCK, dto);
	}

}
