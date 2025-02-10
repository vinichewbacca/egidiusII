package com.wokieDev.egidiusII.controller;

import com.wokieDev.egidiusII.model.DadosCadastroAtendimento;
import com.wokieDev.egidiusII.model.dto.DadosExibirAtendimento;
import com.wokieDev.egidiusII.service.AtendimentoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("atendimento")
public class AtendimentoController {

    @Autowired
    private AtendimentoService atendimentoService;

    @PostMapping("/cadastrar")
    @Transactional
    public ResponseEntity<DadosExibirAtendimento> cadastrar (@RequestBody @Valid DadosCadastroAtendimento dados, UriComponentsBuilder builder){
        var atendimento = atendimentoService.cadastrar(dados);
        var uri = builder.path("/atendimento/{id}").buildAndExpand(atendimento.id()).toUri();
        return ResponseEntity.created(uri).body(atendimento);
    }

    @GetMapping
    public ResponseEntity<List<DadosExibirAtendimento>> listarTodos(){
        var lista = atendimentoService.buscarTodos();
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DadosExibirAtendimento> buscaId(@PathVariable Long id){
        var atendimento = atendimentoService.bucaPorId(id);
        return ResponseEntity.ok(atendimento);
    }

    @GetMapping("/data={dataAtendimento}")
    public ResponseEntity<List<DadosExibirAtendimento>> listarData(@PathVariable LocalDate dataAtendimento){
        var lista = atendimentoService.buscarDataAtendimento(dataAtendimento);
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/usr={idUsuario}")
    public ResponseEntity<List<DadosExibirAtendimento>> listarPorUsuario(@PathVariable Long idUsuario){
        var lista = atendimentoService.buscarPorUsuario(idUsuario);
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/tcn={idTecnico}")
    public ResponseEntity<List<DadosExibirAtendimento>> listarPorTecnico(@PathVariable Long idTecnico){
        var lista = atendimentoService.buscarPorTecnico(idTecnico);
        return ResponseEntity.ok(lista);
    }
}
