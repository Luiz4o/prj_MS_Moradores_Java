package br.com.condominios.moradores.controller;

import br.com.condominios.moradores.dto.MoradorAdminResponseDTO;
import br.com.condominios.moradores.dto.MoradorRequestDTO;
import br.com.condominios.moradores.dto.MoradorResponseDTO;
import br.com.condominios.moradores.dto.MoradorUpdateDTO;
import br.com.condominios.moradores.service.MoradorService;
import br.com.condominios.moradores.service.impl.MoradorServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

    @GetMapping("/admin")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<List<MoradorAdminResponseDTO>> getAllMoradoresAdmin() {
        return ResponseEntity.ok(moradorServiceImpl.getAllAdminMoradores());
    }

    @PostMapping
    public ResponseEntity<MoradorResponseDTO> saveMorador(@Valid @RequestBody MoradorRequestDTO moradorRequestDTO){
        var moradorCreated = moradorServiceImpl.saveMorador(moradorRequestDTO);

        URI location = URI.create("/moradores/" + moradorCreated.getId());


        return  ResponseEntity
                .created(location)
                .body(new MoradorResponseDTO(moradorCreated));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<MoradorResponseDTO> getMoradorById(@PathVariable long id){
        return ResponseEntity.ok(moradorServiceImpl.getById(id));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<MoradorResponseDTO> deleteMorador(@PathVariable long id){
        return  ResponseEntity.ok(moradorServiceImpl.deleteMorador(id));
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<MoradorResponseDTO> updateMorador(@PathVariable long id, @RequestBody MoradorUpdateDTO moradorUpdateDTO){
        return  ResponseEntity.ok(moradorServiceImpl.updateMorador(id, moradorUpdateDTO));
    }
}
