package com.wokieDev.egidiusII.repository;

import com.wokieDev.egidiusII.model.Tecnico;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TecnicoRepository extends JpaRepository<Tecnico, Long> {

    List<Tecnico>findByNomeContainingIgnoreCase(String nome);
}
