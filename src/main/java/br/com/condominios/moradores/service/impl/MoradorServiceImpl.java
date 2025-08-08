package br.com.condominios.moradores.service.impl;

import br.com.condominios.moradores.dto.MoradorRequestDTO;
import br.com.condominios.moradores.dto.MoradorResponseDTO;
import br.com.condominios.moradores.dto.MoradorUpdateDTO;
import br.com.condominios.moradores.model.Morador;
import br.com.condominios.moradores.repository.MoradorRepository;
import br.com.condominios.moradores.service.MoradorService;
import org.springframework.stereotype.Service;

import java.util.List;

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
        return null;
    }

    @Override
    public Morador saveMorador(MoradorRequestDTO moradorRequestDTO) {
        var optionalMorador = moradorRepository.save(new Morador(moradorRequestDTO));

        return  optionalMorador;
    }

    @Override
    public Morador updateMorador(MoradorUpdateDTO moradorUpdateDTO) {
        return null;
    }

    @Override
    public Morador deleteMorador(long id) {
        return null;
    }
}
