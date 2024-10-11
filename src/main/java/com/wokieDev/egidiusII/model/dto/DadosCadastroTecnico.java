package com.wokieDev.egidiusII.model.dto;

import com.wokieDev.egidiusII.model.Atendimento;
import com.wokieDev.egidiusII.model.enumerate.Funcao;

import java.time.LocalDate;
import java.util.List;

public record DadosCadastroTecnico(
        String nome,
        String cpf,
        LocalDate dataNascimento,
        String email,
        String matricula,
        Funcao funcao,
        List<Atendimento> atendimentos
) {
}
