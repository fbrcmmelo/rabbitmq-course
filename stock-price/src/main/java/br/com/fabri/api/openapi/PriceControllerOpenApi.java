package br.com.fabri.api.openapi;

import org.springframework.http.ResponseEntity;

import br.com.fabri.api.dto.PriceDTO;

public interface PriceControllerOpenApi {

	ResponseEntity<Void> updatePrice(PriceDTO dto);
}
