package com.wokieDev.egidiusII.controller;

import com.wokieDev.egidiusII.model.DadosCadastroAtendimento;
import com.wokieDev.egidiusII.model.dto.DadosExibirAtendimento;
import com.wokieDev.egidiusII.service.AtendimentoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("atendimento")
public class AtendimentoController {

    @Autowired
    private AtendimentoService atendimentoService;

    @PostMapping("/cadastrar")
    @Transactional
    public void cadastrar (@RequestBody @Valid DadosCadastroAtendimento dados){
        atendimentoService.cadastrar(dados);
    }

    @GetMapping
    public List<DadosExibirAtendimento> listarTodos(){
        return atendimentoService.buscarTodos();
    }

    @GetMapping("/data={dataAtendimento}")
    public List<DadosExibirAtendimento> listarData(@PathVariable LocalDate dataAtendimento){
        return atendimentoService.buscarDataAtendimento(dataAtendimento);
    }

    @GetMapping("/usr={idUsuario}")
    public List<DadosExibirAtendimento> listarPorUsuario(@PathVariable Long idUsuario){
        return atendimentoService.buscarPorUsuario(idUsuario);
    }

    @GetMapping("/tcn={idTecnico}")
    public List<DadosExibirAtendimento> listarPorTecnico(@PathVariable Long idTecnico){
        return atendimentoService.buscarPorTecnico(idTecnico);
    }
}
