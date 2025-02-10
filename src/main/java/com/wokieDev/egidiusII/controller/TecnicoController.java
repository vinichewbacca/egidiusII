package com.wokieDev.egidiusII.controller;

import com.wokieDev.egidiusII.model.dto.DadosCadastroTecnico;
import com.wokieDev.egidiusII.model.dto.DadosExibirTecnico;
import com.wokieDev.egidiusII.service.TecnicoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("tecnico")
public class TecnicoController {

    @Autowired
    private TecnicoService service;

    @PostMapping("/cadastrar")
    @Transactional
    public ResponseEntity<DadosExibirTecnico> cadastrarTecnico (@RequestBody @Valid DadosCadastroTecnico dados, UriComponentsBuilder builder){
        var tecnico = service.cadastrar(dados);
        var uri = builder.path("/tecnico/{id}").buildAndExpand(tecnico.id()).toUri();
        return ResponseEntity.created(uri).body(tecnico);
    }

    @PutMapping
    @Transactional
    public ResponseEntity<DadosExibirTecnico> atualizarTecnico(@RequestBody DadosExibirTecnico dados){
        var tecnico = service.atualizar(dados);
        return ResponseEntity.ok(tecnico);
    }

    @GetMapping
    public ResponseEntity<List<DadosExibirTecnico>> listarTodos(){
        var lista = service.listarTodos();
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/nome={nome}")
    public ResponseEntity<List<DadosExibirTecnico>> listarPorNome(@PathVariable String nome){
        var lista = service.listarPorNome(nome);
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DadosExibirTecnico> detalheTecnico(@PathVariable Long id){
        var tecnico = service.buscarId(id);
        return ResponseEntity.ok(tecnico);
    }
}
