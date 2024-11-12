package com.wokieDev.egidiusII.model;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "TB_ATENDIMENTO")
public class Atendimento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate dataAtendimento;
    private String descricaoAtendimento;

    @ManyToOne
    private LocalEncontrado localAtendimento;

    @ManyToOne
    private Usuario usuario;

    @ManyToOne
    private Tecnico tecnico;

    public Atendimento( DadosCadastroAtendimento dados) {
        this.dataAtendimento = dados.dataAtendimento();
        this.descricaoAtendimento = dados.descricaoAtendimento().toUpperCase();
    }
}
