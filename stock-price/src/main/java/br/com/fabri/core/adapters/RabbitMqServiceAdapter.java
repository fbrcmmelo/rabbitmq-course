package br.com.fabri.core.adapters;

import org.springframework.amqp.AmqpException;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

import br.com.fabri.core.exceptions.RabbitMqException;
import br.com.fabri.core.usecases.SendQueueMessageUseCase;

@Component
public class RabbitMqServiceAdapter implements SendQueueMessageUseCase {

	private final RabbitTemplate service;

	public RabbitMqServiceAdapter(RabbitTemplate service) {
		this.service = service;
	}

	@Override
	public void send(String queueName, Object message) {
		try {
			this.service.convertAndSend(queueName, message);
		} catch (AmqpException e) {
			throw new RabbitMqException();
		}
	}

}
