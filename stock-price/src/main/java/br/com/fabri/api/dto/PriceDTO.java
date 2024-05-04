package br.com.fabri.api.dto;

import java.io.Serializable;

public record PriceDTO(String codeProduct, Double price) implements Serializable {
}