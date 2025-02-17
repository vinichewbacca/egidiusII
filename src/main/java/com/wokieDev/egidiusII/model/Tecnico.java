package com.wokieDev.egidiusII.model;

import com.wokieDev.egidiusII.model.dto.DadosCadastroTecnico;
import com.wokieDev.egidiusII.model.dto.DadosExibirTecnico;
import com.wokieDev.egidiusII.model.enumerate.Funcao;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Entity
@Table(name = "TB_TECNICO")
public class Tecnico implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String cpf;
    private LocalDate dataNascimento;
    private String email;
    private String telefone;
    private String matricula;
    private String login;
    private String senha;

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
        this.telefone = dados.telefone();
        this.matricula = dados.matricula();
        this.funcao = dados.funcao();
        this.login = dados.email();
        this.senha = dados.senha();
    }

    /*Métodos*/
    public void atualizar (DadosExibirTecnico dados){
        if (dados.nome() != null)
            this.nome = dados.nome();

        if (dados.cpf() != null)
            this.cpf = dados.cpf();

        if (dados.dataNascimento() != null)
            this.dataNascimento = dados.dataNascimento();

        if(dados.email() != null){
            this.email = dados.email();
            this.login = dados.email();
        }

        if (dados.telefone() != null)
            this.telefone = dados.telefone();

        if (dados.matricula() != null)
            this.matricula = dados.matricula();

        if (dados.funcao() != null)
            this.funcao = dados.funcao();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public String getPassword() {
        return senha;
    }

    @Override
    public String getUsername() {
        return login;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
