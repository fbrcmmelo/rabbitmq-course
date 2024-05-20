package br.com.fabri.stockconsumer.config;

import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.fabri.consts.QueueConstants;
import br.com.fabri.stockconsumer.consumer.StockConsumer;

@Configuration
public class RabbitMqConsumerConfig {

	@Bean
	SimpleMessageListenerContainer simpleMessageListenerContainer(ConnectionFactory connectionFactory,
			MessageListenerAdapter messageListenerAdapter) {
		SimpleMessageListenerContainer simpleMessageListenerContainer = new SimpleMessageListenerContainer();
		simpleMessageListenerContainer.setConnectionFactory(connectionFactory);
		simpleMessageListenerContainer.setQueueNames(QueueConstants.STOCK);
		simpleMessageListenerContainer.setMessageListener(messageListenerAdapter);
		return simpleMessageListenerContainer;
	}

	@Bean
	MessageListenerAdapter messageListenerAdapter(StockConsumer consumer) {
		return new MessageListenerAdapter(consumer, "consume");
	}
}
