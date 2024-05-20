package br.com.fabri.dto;

import java.io.Serializable;

import org.json.JSONPropertyName;

public record PriceDTO(@JSONPropertyName("productCode") String productCode, @JSONPropertyName("price") Double price)
		implements Serializable {
}