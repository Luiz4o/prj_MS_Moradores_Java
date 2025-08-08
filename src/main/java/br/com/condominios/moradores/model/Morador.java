package br.com.condominios.moradores.model;

import br.com.condominios.moradores.dto.MoradorRequestDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Morador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private int apartamento;
    private int bloco;

    public Morador(MoradorRequestDTO moradorRequestDTO) {
        this.nome = moradorRequestDTO.nome();
        this.apartamento = moradorRequestDTO.apartamento();
        this.bloco = moradorRequestDTO.bloco();
    }

    public Morador() {
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getApartamento() {
        return apartamento;
    }

    public void setApartamento(int apartamento) {
        this.apartamento = apartamento;
    }

    public int getBloco() {
        return bloco;
    }

    public void setBloco(int bloco) {
        this.bloco = bloco;
    }
}
