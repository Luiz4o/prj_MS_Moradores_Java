package br.com.condominios.moradores.repository;

import br.com.condominios.moradores.model.Morador;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MoradorRepository extends JpaRepository<Morador,Long> {
}
