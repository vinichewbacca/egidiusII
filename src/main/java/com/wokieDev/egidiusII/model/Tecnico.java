package com.wokieDev.egidiusII.model;

import com.wokieDev.egidiusII.model.dto.DadosCadastroTecnico;
import com.wokieDev.egidiusII.model.enumerate.Funcao;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Entity
@Table(name = "TB_TECNICO")
public class Tecnico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String cpf;
    private LocalDate dataNascimento;
    private String email;
    private String matricula;

    @Enumerated(EnumType.STRING)
    private Funcao funcao;

    @OneToMany(mappedBy = "tecnico", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Atendimento> atendimentos = new ArrayList<>();

    /*Construtores*/
    public Tecnico(DadosCadastroTecnico dados) {
        this.nome = dados.nome();
        this.cpf = dados.cpf();
        this.dataNascimento = dados.dataNascimento();
        this.email = dados.email();
        this.matricula = dados.matricula();
        this.funcao = dados.funcao();
        this.atendimentos = dados.atendimentos();
    }
}
