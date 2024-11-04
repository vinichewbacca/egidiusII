package com.wokieDev.egidiusII.repository;

import com.wokieDev.egidiusII.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Optional<Usuario> findByCpf(String cpf);
    List<Usuario> findByNomeContainingIgnoreCase(String nome);
}
