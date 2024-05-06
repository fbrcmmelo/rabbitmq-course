package br.com.fabri.dto;

import java.io.Serializable;

public record StockDTO(String productCode, Integer quantity) implements Serializable {
}