package br.com.fabri.core.usecases;

public interface SendQueueMessageUseCase {

	void send(String queueName, Object message);
}
