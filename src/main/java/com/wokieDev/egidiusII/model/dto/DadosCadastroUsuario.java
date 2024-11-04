package com.wokieDev.egidiusII.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record DadosCadastroUsuario(

         @NotBlank
         String nome,
         String mae,
         String pai,

         @NotNull
         LocalDate dataNascimento,
         String cpf,
         String sexo,

         @NotNull
         Long localEncontrado,

         @NotNull
         LocalDate dataAbordagem
) {
}
