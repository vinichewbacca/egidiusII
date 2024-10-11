package com.wokieDev.egidiusII.service;

import com.wokieDev.egidiusII.model.LocalEncontrado;
import com.wokieDev.egidiusII.model.dto.DadosCadastroLocalEncontrado;
import com.wokieDev.egidiusII.repository.LocalEncontradoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LocalEncontradoService {

    @Autowired
    private LocalEncontradoRepository repository;

    public void cadastrar(DadosCadastroLocalEncontrado dados) {
        repository.save(new LocalEncontrado(dados));
    }
}
