package com.wokieDev.egidiusII.model.dto;

import com.wokieDev.egidiusII.model.enumerate.Funcao;

import java.time.LocalDate;

public record DadosExibirTecnico(

        Long id,
        String nome,
        String cpf,
        LocalDate dataNascimento,
        String email,
        String telefone,
        String matricula,
        Funcao funcao
) {
}
