package com.wokieDev.egidiusII.model;

import com.wokieDev.egidiusII.model.enumerate.Funcao;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class Tecnico {
    private Long id;
    private String nome;
    private String cpf;
    private LocalDate dataNascimento;
    private String email;
    private String matricula;
    private Funcao funcao;
}
