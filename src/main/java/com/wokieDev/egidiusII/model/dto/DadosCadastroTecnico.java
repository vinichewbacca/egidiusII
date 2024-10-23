package com.wokieDev.egidiusII.model.dto;

import com.wokieDev.egidiusII.model.Atendimento;
import com.wokieDev.egidiusII.model.enumerate.Funcao;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDate;
import java.util.List;

public record DadosCadastroTecnico(

        @NotBlank
        String nome,

        @CPF
        String cpf,
        LocalDate dataNascimento,

        @NotBlank
        @Email
        String email,

        @NotBlank
        String telefone,

        @NotBlank
        @Pattern(regexp = "\\d{6}")
        String matricula,
        Funcao funcao,
        List<Atendimento> atendimentos
) {
}
