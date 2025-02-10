package com.wokieDev.egidiusII.service;

import com.wokieDev.egidiusII.model.Tecnico;
import com.wokieDev.egidiusII.model.dto.DadosCadastroTecnico;
import com.wokieDev.egidiusII.model.dto.DadosExibirTecnico;
import com.wokieDev.egidiusII.repository.TecnicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TecnicoService {

    @Autowired
    private TecnicoRepository repository;

    public DadosExibirTecnico cadastrar(DadosCadastroTecnico dados) {
        Tecnico t = new Tecnico(dados);
        repository.save(t);
        return converterDados(t);
    }

    public DadosExibirTecnico atualizar(DadosExibirTecnico dados){
        var tecnico = repository.getReferenceById(dados.id());
        tecnico.atualizar(dados);
        return converterDados(tecnico);
    }

    public List<DadosExibirTecnico> listarTodos(){

        return convertList(repository.findAll());
    }

    public List<DadosExibirTecnico> listarPorNome(String nome){
        return convertList(repository.findByNomeContainingIgnoreCase(nome));
    }

    public DadosExibirTecnico buscarId(Long id) {
        return converterDados(repository.getReferenceById(id));
    }

    /*--Métodos Privados--*/
    private List<DadosExibirTecnico> convertList(List<Tecnico> tecnicoList){
        return tecnicoList.stream().sorted(Comparator.comparing(Tecnico::getNome))
                .map(t -> new DadosExibirTecnico(t.getId(), t.getNome(), t.getCpf(),
                        t.getDataNascimento(), t.getEmail(), t.getTelefone(), t.getMatricula(), t.getFuncao()))
                .collect(Collectors.toList());
    }

    private DadosExibirTecnico converterDados(Tecnico t){
        return new DadosExibirTecnico(t.getId(), t.getNome(), t.getCpf(),
                t.getDataNascimento(), t.getEmail(), t.getTelefone(), t.getMatricula(), t.getFuncao());
    }


}
