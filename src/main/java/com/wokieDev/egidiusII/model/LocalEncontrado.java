package com.wokieDev.egidiusII.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "TB_LOCAL_ENCONTRADO")
public class LocalEncontrado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;

    @OneToMany(mappedBy = "localEncontrado", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Usuario> usuarios = new ArrayList<>();

    @OneToMany(mappedBy = "localAtendimento", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Atendimento> atendimentos = new ArrayList<>();
}
