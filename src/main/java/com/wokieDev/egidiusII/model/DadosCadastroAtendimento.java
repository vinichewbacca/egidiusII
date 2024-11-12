package com.wokieDev.egidiusII.model;

import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;

public record DadosCadastroAtendimento(
                    LocalDate dataAtendimento,

                    @NotBlank
                    String descricaoAtendimento,
                    Long localAtendimento,
                    Long usuario,
                    Long tecnico
) {}
