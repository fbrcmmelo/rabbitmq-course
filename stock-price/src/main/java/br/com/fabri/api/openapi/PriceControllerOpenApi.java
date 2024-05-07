package br.com.fabri.api.openapi;

import org.springframework.http.ResponseEntity;

import br.com.fabri.dto.PriceDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "ProductPrice")
public interface PriceControllerOpenApi {

	@Operation(summary = "Update product's price")
	@ApiResponses({
			@ApiResponse(responseCode = "200", description = "OK"),
			@ApiResponse(responseCode = "500", description = "Erro interno"),
	})
	ResponseEntity<Void> updatePrice(@Parameter(required = true) PriceDTO dto);
}
