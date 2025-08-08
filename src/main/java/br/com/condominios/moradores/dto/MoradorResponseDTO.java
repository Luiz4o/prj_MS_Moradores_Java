package br.com.condominios.moradores.dto;

import br.com.condominios.moradores.model.Morador;

public record MoradorResponseDTO(
        String nome,
        int apartamento,
        int bloco
) {

    public MoradorResponseDTO(Morador morador) {
        this(morador.getNome(),morador.getApartamento(), morador.getBloco());
    }


}
