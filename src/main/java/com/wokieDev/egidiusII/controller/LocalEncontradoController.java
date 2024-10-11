package com.wokieDev.egidiusII.controller;

import com.wokieDev.egidiusII.model.dto.DadosCadastroLocalEncontrado;
import com.wokieDev.egidiusII.service.LocalEncontradoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("local")
public class LocalEncontradoController {

    @Autowired
    private LocalEncontradoService service;

    @PostMapping("/cadastrar")
    public void cadastrarLocal (@RequestBody DadosCadastroLocalEncontrado dados){
        service.cadastrar(dados);
    }
}
