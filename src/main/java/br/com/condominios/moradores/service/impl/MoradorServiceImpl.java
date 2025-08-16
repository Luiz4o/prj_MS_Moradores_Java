package br.com.condominios.moradores.service.impl;

import br.com.condominios.moradores.dto.MoradorAdminResponseDTO;
import br.com.condominios.moradores.dto.MoradorRequestDTO;
import br.com.condominios.moradores.dto.MoradorResponseDTO;
import br.com.condominios.moradores.dto.MoradorUpdateDTO;
import br.com.condominios.moradores.exception.MoradorNotFoundException;
import br.com.condominios.moradores.model.Morador;
import br.com.condominios.moradores.repository.MoradorRepository;
import br.com.condominios.moradores.service.MoradorService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MoradorServiceImpl implements MoradorService {

    private final MoradorRepository moradorRepository;

    public MoradorServiceImpl(MoradorRepository moradorRepository) {
        this.moradorRepository = moradorRepository;
    }

    @Override
    public List<MoradorResponseDTO> getAllMoradores(){
        return moradorRepository.findAll().stream()
                .map(MoradorResponseDTO::new)
                .toList();
    }

    @Override
    public MoradorResponseDTO getById(long id) {
        var morador = moradorRepository.findById(id)
                .orElseThrow(() -> new MoradorNotFoundException());

        return new MoradorResponseDTO(morador);
    }

    @Override
    public Morador saveMorador(MoradorRequestDTO moradorRequestDTO) {
        var morador = moradorRepository.save(new Morador(moradorRequestDTO));

        return  morador;
    }

    @Override
    public MoradorResponseDTO updateMorador(long id, MoradorUpdateDTO moradorUpdateDTO) {
        Morador morador = moradorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Morador não encontrado"));

        System.out.println(moradorUpdateDTO);

        if (moradorUpdateDTO.nome() != null) {
            morador.setNome(moradorUpdateDTO.nome());
        }
        if (moradorUpdateDTO.apartamento() != null) {
            morador.setApartamento(moradorUpdateDTO.apartamento());
        }
        if (moradorUpdateDTO.bloco() != null ) {
            morador.setBloco(moradorUpdateDTO.bloco());
        }

        Morador salvo = moradorRepository.save(morador);
        return new MoradorResponseDTO(salvo);
    }

    @Override
    public MoradorResponseDTO deleteMorador(long id) {
        var moradorOptional = moradorRepository.findById(id);
        var morador = moradorOptional.orElseThrow(() -> new MoradorNotFoundException());
        moradorRepository.delete(morador);

        return new MoradorResponseDTO(morador);
    }

    @Override
    public List<MoradorAdminResponseDTO> getAllAdminMoradores(){
        return moradorRepository.findAll().stream()
                .map(MoradorAdminResponseDTO::new)
                .toList();
    }
}
