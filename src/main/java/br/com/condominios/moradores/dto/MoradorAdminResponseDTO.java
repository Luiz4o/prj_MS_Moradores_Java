package br.com.condominios.moradores.dto;

import br.com.condominios.moradores.model.Morador;

public record MoradorAdminResponseDTO(
        long id,
        String nome,
        int apartamento,
        int bloco
) {
    public MoradorAdminResponseDTO(Morador morador) {
        this(morador.getId(), morador.getNome(), morador.getApartamento(), morador.getBloco());

    }
}
