package com.wokieDev.egidiusII.service;

import com.wokieDev.egidiusII.model.LocalEncontrado;
import com.wokieDev.egidiusII.model.dto.DadosCadastroLocalEncontrado;
import com.wokieDev.egidiusII.model.dto.DadosExibirLocalEncontrado;
import com.wokieDev.egidiusII.repository.LocalEncontradoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LocalEncontradoService {

    @Autowired
    private LocalEncontradoRepository repository;

    public void cadastrar(DadosCadastroLocalEncontrado dados) {
        repository.save(new LocalEncontrado(dados));
    }

    public List<DadosExibirLocalEncontrado> listarTudo() {
        return convertList(repository.findAll());
    }

    /*--Metodos Privados--*/
    private List<DadosExibirLocalEncontrado> convertList(List<LocalEncontrado> localEncontradoList){
        return localEncontradoList.stream()
                .sorted(Comparator.comparing(LocalEncontrado::getNome))
                .map(le -> new DadosExibirLocalEncontrado(le.getId(),le.getNome()))
                .collect(Collectors.toList());
    }
}
