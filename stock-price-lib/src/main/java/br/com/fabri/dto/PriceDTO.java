package br.com.fabri.dto;

import java.io.Serializable;

public record PriceDTO(String productCode, Double price) implements Serializable {
}