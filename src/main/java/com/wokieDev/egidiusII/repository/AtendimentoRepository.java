package com.wokieDev.egidiusII.repository;

import com.wokieDev.egidiusII.model.Atendimento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface AtendimentoRepository extends JpaRepository<Atendimento, Long> {

    List<Atendimento> findAllByDataAtendimento(LocalDate dataAtendimento);
    List<Atendimento> findAllByUsuarioId (Long id);
    List<Atendimento> findAllByTecnicoId (Long id);
}
