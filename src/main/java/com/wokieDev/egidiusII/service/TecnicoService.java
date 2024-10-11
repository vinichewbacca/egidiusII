package com.wokieDev.egidiusII.service;

import com.wokieDev.egidiusII.model.Tecnico;
import com.wokieDev.egidiusII.model.dto.DadosCadastroTecnico;
import com.wokieDev.egidiusII.repository.TecnicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TecnicoService {

    @Autowired
    private TecnicoRepository repository;

    public void cadastrar(DadosCadastroTecnico dados) {
        repository.save(new Tecnico(dados));
    }
}
