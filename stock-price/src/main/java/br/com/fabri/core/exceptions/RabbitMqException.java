package br.com.fabri.core.exceptions;

public class RabbitMqException extends RuntimeException {

	public RabbitMqException() {
		super("Erro ao tentar acessar o servico do RabbitMQ");
	}
}
