package br.com.fabri.core.configs;

import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.Binding.DestinationType;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Configuration;

import br.com.fabri.consts.ExchangeConstants;
import br.com.fabri.consts.QueueConstants;
import jakarta.annotation.PostConstruct;

@Configuration
public class RabbitMqConnectionConfig {

	private final AmqpAdmin amqpAdmin;

	public RabbitMqConnectionConfig(AmqpAdmin amqpAdmin) {
		this.amqpAdmin = amqpAdmin;
	}

	private Queue queue(String queueName) {
		return new Queue(queueName, true, false, false);
	}

	private DirectExchange exchange(String exchangeName) {
		return new DirectExchange(exchangeName);
	}

	private Binding binding(Queue queue, DirectExchange exchange) {
		return new Binding(queue.getName(), DestinationType.QUEUE, exchange.getName(), queue.getName(), null);
	}

	@PostConstruct
	void setUpQueuesAndExchanges() {
		amqpAdmin.declareQueue(queue(QueueConstants.PRICE));
		amqpAdmin.declareQueue(queue(QueueConstants.STOCK));

		amqpAdmin.declareExchange(exchange(ExchangeConstants.DIRECT));

		amqpAdmin.declareBinding(binding(queue(QueueConstants.PRICE), exchange(ExchangeConstants.DIRECT)));
		amqpAdmin.declareBinding(binding(queue(QueueConstants.STOCK), exchange(ExchangeConstants.DIRECT)));
	}

}
