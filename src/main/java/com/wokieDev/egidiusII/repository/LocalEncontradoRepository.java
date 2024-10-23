package com.wokieDev.egidiusII.repository;

import com.wokieDev.egidiusII.model.LocalEncontrado;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LocalEncontradoRepository extends JpaRepository<LocalEncontrado, Long> {

    Optional<LocalEncontrado>  findByNomeContainingIgnoreCase (String nome);
}
