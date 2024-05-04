package br.com.fabri.api.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fabri.api.dto.StockDTO;
import br.com.fabri.api.openapi.StockControllerOpenApi;
import br.com.fabri.core.services.RabbitMqStockService;

@RestController
@RequestMapping(value = "/stock", produces = MediaType.APPLICATION_JSON_VALUE)
public class StockController implements StockControllerOpenApi {

	private final RabbitMqStockService service;

	public StockController(RabbitMqStockService service) {
		this.service = service;
	}

	@Override
	@PutMapping
	public ResponseEntity<Void> updateStock(@RequestBody StockDTO dto) {
		this.service.update(dto);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
