package com.wokieDev.egidiusII.controller;

import com.wokieDev.egidiusII.model.dto.DadosCadastroUsuario;
import com.wokieDev.egidiusII.model.dto.DadosExibirUsuario;
import com.wokieDev.egidiusII.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService service;

    @PostMapping("/cadastrar")
    @Transactional
    public ResponseEntity<DadosExibirUsuario> cadastrarUsuario (@RequestBody @Valid DadosCadastroUsuario dados, UriComponentsBuilder builder){
        var usuario = service.cadastrar(dados);
        var uri = builder.path("/usuario/{id}").buildAndExpand(usuario.id()).toUri();
        return ResponseEntity.created(uri).body(usuario);
    }

    @GetMapping("/lista")
    public ResponseEntity<List<DadosExibirUsuario>> listarTodos(){
        var lista = service.buscarTodos();
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/buscaCpf/{cpf}")
    public ResponseEntity<DadosExibirUsuario> buscaCpf (@PathVariable String cpf){
        var usuario = service.buscarCpf(cpf);
        return ResponseEntity.ok(usuario);
    }

    @GetMapping("/buscaNome/{nome}")
    public ResponseEntity<List<DadosExibirUsuario>> buscaNome (@PathVariable String nome){
        var lista = service.buscarNome(nome);
        return ResponseEntity.ok(lista);
    }

    @PutMapping
    @Transactional
    public ResponseEntity<DadosExibirUsuario> atualizar (@RequestBody DadosExibirUsuario dados) {
        var usuario = service.atualizar(dados);
        return ResponseEntity.ok(usuario);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DadosExibirUsuario> detalheUsuario (@PathVariable Long id){
        var usuario = service.buscarId(id);
        return ResponseEntity.ok(usuario);
    }
}
