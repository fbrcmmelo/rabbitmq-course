package br.com.fabri.api.openapi;

import org.springframework.http.ResponseEntity;

import br.com.fabri.dto.StockDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "ProductStock")
public interface StockControllerOpenApi {

	@Operation(summary = "Update stock's quantity")
	@ApiResponses({
			@ApiResponse(responseCode = "200", description = "OK"),
			@ApiResponse(responseCode = "500", description = "Erro interno"),
	})
	ResponseEntity<Void> updateStock(StockDTO dto);
}
