package com.wokieDev.egidiusII.model;

import com.wokieDev.egidiusII.model.dto.DadosCadastroUsuario;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "TB_USUARIO")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String mae;
    private String pai;
    private LocalDate dataNascimento;
    private String cpf;
    private String sexo;

    @ManyToOne
    private LocalEncontrado localEncontrado;//representa o local onde o usuario foi encontrado pela primeira vez
    private LocalDate dataAbordagem;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Atendimento> atendimentos = new ArrayList<>();

    public Usuario(DadosCadastroUsuario dados) {
        this.nome = dados.nome();
        this.mae = dados.mae();
        this.pai = dados.pai();
        this.dataNascimento = dados.dataNascimento();
        this.cpf = dados.cpf();
        this.sexo = dados.sexo();
        this.dataAbordagem = dados.dataAbordagem();
        this.atendimentos = dados.atendimentos();
    }
}
