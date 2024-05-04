package br.com.fabri.api.openapi;

import org.springframework.http.ResponseEntity;

import br.com.fabri.api.dto.StockDTO;

public interface StockControllerOpenApi {

	ResponseEntity<Void> updateStock(StockDTO dto);
}
