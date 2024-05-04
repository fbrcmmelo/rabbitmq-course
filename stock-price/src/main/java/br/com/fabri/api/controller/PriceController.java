package br.com.fabri.api.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fabri.api.dto.PriceDTO;
import br.com.fabri.api.openapi.PriceControllerOpenApi;
import br.com.fabri.core.service.RabbitMqPriceService;

@RestController
@RequestMapping(value = "/price", produces = MediaType.APPLICATION_JSON_VALUE)
public class PriceController implements PriceControllerOpenApi {

	private final RabbitMqPriceService service;

	public PriceController(RabbitMqPriceService service) {
		this.service = service;
	}

	@Override
	@PutMapping
	public ResponseEntity<Void> updatePrice(@RequestBody PriceDTO dto) {
		this.service.update(dto);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
