package br.com.condominios.moradores.service;

import br.com.condominios.moradores.dto.MoradorRequestDTO;
import br.com.condominios.moradores.dto.MoradorResponseDTO;
import br.com.condominios.moradores.dto.MoradorUpdateDTO;
import br.com.condominios.moradores.model.Morador;
import br.com.condominios.moradores.repository.MoradorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface MoradorService {

    List<MoradorResponseDTO> getAllMoradores();

    MoradorResponseDTO getById(long id);

    Morador saveMorador(MoradorRequestDTO moradorRequestDTO);

    Morador updateMorador(MoradorUpdateDTO moradorUpdateDTO);

    Morador deleteMorador(long id);

}
