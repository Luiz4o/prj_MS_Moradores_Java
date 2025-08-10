package br.com.condominios.moradores.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class MoradorNotFoundException extends RuntimeException {
    public MoradorNotFoundException() {
        super("Morador não encontrado!");
    }
}
