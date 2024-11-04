package com.wokieDev.egidiusII.model;

import com.wokieDev.egidiusII.model.dto.DadosCadastroUsuario;
import com.wokieDev.egidiusII.model.dto.DadosExibirUsuario;
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
    }

    public void atualizarDados(DadosExibirUsuario dados) { //o local encontrado e a data da primeira abordagem
        if (dados.nome() != null)                          //não podem ser alterados
            this.nome = dados.nome();

        if (dados.mae() != null)
            this.mae = dados.mae();

        if (dados.pai() != null)
            this.pai = dados.pai();

        if (dados.dataNascimento() != null)
            this.dataNascimento = dados.dataNascimento();

        if (dados.cpf() != null)
            this.cpf = dados.cpf();

        if (dados.sexo() != null)
            this.sexo = dados.sexo();
    }
}
