package br.com.fabri.core.services;

import org.springframework.stereotype.Service;

import br.com.fabri.api.dto.PriceDTO;
import br.com.fabri.core.adapters.RabbitMqServiceAdapter;
import br.com.fabri.core.consts.QueueConstants;
import br.com.fabri.core.usecases.UpdatePriceUseCase;

@Service
public class RabbitMqPriceService implements UpdatePriceUseCase {

	private final RabbitMqServiceAdapter rabbitMQ;

	public RabbitMqPriceService(RabbitMqServiceAdapter rabbitMQ) {
		this.rabbitMQ = rabbitMQ;
	}

	@Override
	public void update(PriceDTO dto) {
		this.rabbitMQ.send(QueueConstants.PRICE, dto);
	}

}
