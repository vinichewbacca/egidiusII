package com.wokieDev.egidiusII.model.dto;

import java.time.LocalDate;

public record DadosExibirAtendimento(
        Long id,
        LocalDate dataAtendimento,
        String descricaoAtendimento,
        String localEncontrado,
        String tecnico,
        String usuario
) {
}
