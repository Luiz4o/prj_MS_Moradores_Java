package br.com.condominios.moradores.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record MoradorRequestDTO(
        @NotBlank(message = "O nome é obrigatório")
        String nome,
        @NotNull(message = "O apartamento é obrigatório")
        int apartamento,
        @NotNull(message = "O bloco é obrigatório")
        int bloco
) {
}
