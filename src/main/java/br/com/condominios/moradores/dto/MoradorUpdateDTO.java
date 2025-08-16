package br.com.condominios.moradores.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record MoradorUpdateDTO(
        String nome,
        Integer apartamento,
        Integer bloco
) {
}
