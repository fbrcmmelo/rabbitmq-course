package br.com.fabri.dto;

import java.io.Serializable;

import org.json.JSONPropertyName;

public record StockDTO(@JSONPropertyName("productCode") String productCode,
		@JSONPropertyName("quantity") Integer quantity) implements Serializable {
}