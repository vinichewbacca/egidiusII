package com.wokieDev.egidiusII.controller;

import com.wokieDev.egidiusII.model.dto.DadosCadastroTecnico;
import com.wokieDev.egidiusII.model.dto.DadosExibirTecnico;
import com.wokieDev.egidiusII.service.TecnicoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("tecnico")
public class TecnicoController {

    @Autowired
    private TecnicoService service;

    @PostMapping("/cadastrar")
    @Transactional
    public void cadastrarTecnico (@RequestBody @Valid DadosCadastroTecnico dados){

        service.cadastrar(dados);
    }

    @GetMapping
    public List<DadosExibirTecnico> listarTodos(){
        return service.listarTodos();
    }

    @GetMapping("/{nome}")
    public List<DadosExibirTecnico> listarPorNome(@PathVariable String nome){
        return service.listarPorNome(nome);
    }
}
