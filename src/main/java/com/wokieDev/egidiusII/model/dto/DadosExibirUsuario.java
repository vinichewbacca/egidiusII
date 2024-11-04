package com.wokieDev.egidiusII.model.dto;

import com.wokieDev.egidiusII.model.Atendimento;

import java.time.LocalDate;
import java.util.List;

public record DadosExibirUsuario(
         Long id,
         String nome,
         String mae,
         String pai,
         LocalDate dataNascimento,
         String cpf,
         String sexo,
         String localEncontrado,
         LocalDate dataAbordagem,
         List<Atendimento> atendimentos
) {
}
