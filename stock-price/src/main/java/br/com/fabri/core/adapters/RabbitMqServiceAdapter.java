package br.com.fabri.core.adapters;

import org.springframework.amqp.AmqpException;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.fabri.core.exceptions.RabbitMqException;
import br.com.fabri.core.usecases.SendQueueMessageUseCase;

@Component
public class RabbitMqServiceAdapter implements SendQueueMessageUseCase {

	private final RabbitTemplate service;
	private final ObjectMapper mapper;

	public RabbitMqServiceAdapter(RabbitTemplate service, ObjectMapper mapper) {
		this.service = service;
		this.mapper = mapper;
	}

	@Override
	public void send(String queueName, Object message) {
		try {
			this.service.convertAndSend(queueName, mapper.writeValueAsString(message));
		} catch (AmqpException | JsonProcessingException e) {
			throw new RabbitMqException();
		}
	}

}
