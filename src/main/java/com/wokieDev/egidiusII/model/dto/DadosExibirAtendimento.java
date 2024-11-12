package com.wokieDev.egidiusII.model.dto;

import java.time.LocalDate;

public record DadosExibirAtendimento(
        LocalDate dataAtendimento,
        String descricaoAtendimento,
        String localEncontrado,
        String tecnico,
        String usuario
) {
}
