package com.wokieDev.egidiusII.controller;

import com.wokieDev.egidiusII.model.dto.DadosCadastroTecnico;
import com.wokieDev.egidiusII.service.TecnicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("tecnico")
public class TecnicoController {

    @Autowired
    private TecnicoService service;

    @PostMapping("/cadastrar")
    public void cadastrarTecnico (@RequestBody DadosCadastroTecnico dados){

        service.cadastrar(dados);
    }
}
