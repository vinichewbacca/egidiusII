package com.wokieDev.egidiusII.model.dto;

import com.wokieDev.egidiusII.model.Atendimento;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.List;

public record DadosCadastroUsuario(

         @NotBlank
         String nome,
         String mae,
         String pai,

         @NotNull
         LocalDate dataNascimento,
         String cpf,
         String sexo,

         @NotBlank
         String localEncontrado,

         @NotNull
         LocalDate dataAbordagem,
         List<Atendimento> atendimentos
) {
}
