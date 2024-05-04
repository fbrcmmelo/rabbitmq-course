package br.com.fabri.core.service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import br.com.fabri.api.dto.PriceDTO;
import br.com.fabri.core.consts.QueueConstants;
import br.com.fabri.core.usecase.UpdatePriceUseCase;

@Service
public class RabbitMqPriceService implements UpdatePriceUseCase {

	private final RabbitTemplate rabbitMQ;

	public RabbitMqPriceService(RabbitTemplate rTemplate) {
		this.rabbitMQ = rTemplate;
	}

	@Override
	public void update(PriceDTO dto) {
		this.rabbitMQ.convertAndSend(QueueConstants.PRICE, dto);
	}

}
