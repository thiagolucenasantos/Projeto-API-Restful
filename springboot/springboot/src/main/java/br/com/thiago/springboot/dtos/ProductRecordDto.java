package br.com.thiago.springboot.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

/**
 *
 * Record é imutável, uma vez criado não podemos alterar os valores
 * já possue diversos métodos com getters
 */

public record ProductRecordDto(@NotBlank String name, @NotNull BigDecimal value) {

}
