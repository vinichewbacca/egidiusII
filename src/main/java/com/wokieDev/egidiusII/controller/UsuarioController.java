package com.wokieDev.egidiusII.controller;

import com.wokieDev.egidiusII.model.dto.DadosCadastroUsuario;
import com.wokieDev.egidiusII.model.dto.DadosExibirUsuario;
import com.wokieDev.egidiusII.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService service;

    @PostMapping("/cadastrar")
    @Transactional
    public void cadastrarUsuario (@RequestBody @Valid DadosCadastroUsuario dados){
        service.cadastrar(dados);
    }

    @GetMapping("/lista")
    public List<DadosExibirUsuario> listarTodos(){
        return service.buscarTodos();
    }

    @GetMapping("/buscaCpf/{cpf}")
    public DadosExibirUsuario buscaCpf (@PathVariable String cpf){
        return service.buscarCpf(cpf);
    }

    @GetMapping("/buscaNome/{nome}")
    public List<DadosExibirUsuario> buscaNome (@PathVariable String nome){
        return service.buscarNome(nome);
    }

    @PutMapping
    @Transactional
    public void atualizar (@RequestBody DadosExibirUsuario dados) {
        service.atualizar(dados);
    }
}
