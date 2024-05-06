package br.com.fabri.core.services;

import org.springframework.stereotype.Service;

import br.com.fabri.consts.QueueConstants;
import br.com.fabri.core.adapters.RabbitMqServiceAdapter;
import br.com.fabri.core.usecases.UpdateStockUseCase;
import br.com.fabri.dto.StockDTO;

@Service
public class RabbitMqStockService implements UpdateStockUseCase {

	private final RabbitMqServiceAdapter rabbitMQ;

	public RabbitMqStockService(RabbitMqServiceAdapter rabbitMQ) {
		this.rabbitMQ = rabbitMQ;
	}

	@Override
	public void update(StockDTO dto) {
		this.rabbitMQ.send(QueueConstants.STOCK, dto);
	}

}
