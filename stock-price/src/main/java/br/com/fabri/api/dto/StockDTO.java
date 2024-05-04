package br.com.fabri.api.dto;

import java.io.Serializable;

public record StockDTO(String codeProduct, Integer quantity) implements Serializable {
}