package com.wokieDev.egidiusII.controller;

import com.wokieDev.egidiusII.model.dto.DadosCadastroLocalEncontrado;
import com.wokieDev.egidiusII.model.dto.DadosExibirLocalEncontrado;
import com.wokieDev.egidiusII.service.LocalEncontradoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("local")
public class LocalEncontradoController {

    @Autowired
    private LocalEncontradoService service;

    @PostMapping("/cadastrar")
    @Transactional
    public void cadastrarLocal (@RequestBody DadosCadastroLocalEncontrado dados){
        service.cadastrar(dados);
    }

    @GetMapping
    public List<DadosExibirLocalEncontrado> listarTudo (){
        return service.listarTudo();
    }
}
