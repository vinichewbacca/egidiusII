package com.wokieDev.egidiusII.repository;

import com.wokieDev.egidiusII.model.Tecnico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

public interface TecnicoRepository extends JpaRepository<Tecnico, Long> {

    List<Tecnico>findByNomeContainingIgnoreCase(String nome);

    UserDetails findByLogin(String login);
}
