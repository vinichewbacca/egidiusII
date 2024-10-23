package com.wokieDev.egidiusII.service;

import com.wokieDev.egidiusII.model.Usuario;
import com.wokieDev.egidiusII.model.dto.DadosCadastroUsuario;
import com.wokieDev.egidiusII.repository.LocalEncontradoRepository;
import com.wokieDev.egidiusII.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;
    @Autowired
    private LocalEncontradoRepository localEncontradoRepository;

    public void cadastrar(DadosCadastroUsuario dados) {
        Usuario usuario = new Usuario(dados);
        var local = localEncontradoRepository.findByNomeContainingIgnoreCase(dados.localEncontrado());

        if (local.isPresent()) {
            var l = local.get();
            usuario.setLocalEncontrado(l);
        }

        repository.save(usuario);
    }

    public List<DadosCadastroUsuario> buscarTodos(){
        return  conversorDados(repository.findAll());
    }

    private List<DadosCadastroUsuario>conversorDados(List<Usuario> usuarioList){
        return usuarioList
                .stream()
                .sorted(Comparator.comparing(Usuario::getNome))
                .map(usuario -> new DadosCadastroUsuario(usuario.getNome(), usuario.getMae(), usuario.getPai()
                                                        , usuario.getDataNascimento(), usuario.getCpf(), usuario.getSexo()
                                                        , usuario.getLocalEncontrado().getNome(),usuario.getDataAbordagem(),usuario.getAtendimentos()))
                .collect(Collectors.toList());
    }
}
