package br.com.condominios.moradores.controller;

import br.com.condominios.moradores.dto.MoradorRequestDTO;
import br.com.condominios.moradores.dto.MoradorResponseDTO;
import br.com.condominios.moradores.service.MoradorService;
import br.com.condominios.moradores.service.impl.MoradorServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.RestController;


import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/moradores")
public class MoradorController {

    private final MoradorServiceImpl moradorServiceImpl;

    public MoradorController(MoradorServiceImpl moradorServiceImpl) {
        this.moradorServiceImpl = moradorServiceImpl;
    }

    @GetMapping
    public ResponseEntity<List<MoradorResponseDTO>> getAllMoradores(){
        var moradores = moradorServiceImpl.getAllMoradores();

        return  ResponseEntity.ok(moradores);
    }

    @PostMapping
    public ResponseEntity<MoradorResponseDTO> saveMorador(@Valid @RequestBody MoradorRequestDTO moradorRequestDTO){
        var moradorCreated = moradorServiceImpl.saveMorador(moradorRequestDTO);

        URI location = URI.create("/morador/" + moradorCreated.getId());


        return  ResponseEntity
                .created(location)
                .body(new MoradorResponseDTO(moradorCreated));
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<MoradorResponseDTO> getMoradorById(@PathVariable long id){
        return ResponseEntity.ok(new MoradorResponseDTO(moradorServiceImpl.getById(id)));
    }
}
