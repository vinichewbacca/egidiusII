package com.wokieDev.egidiusII.service;

import com.wokieDev.egidiusII.model.Atendimento;
import com.wokieDev.egidiusII.model.Usuario;
import com.wokieDev.egidiusII.model.dto.DadosCadastroUsuario;
import com.wokieDev.egidiusII.model.dto.DadosExibirAtendimento;
import com.wokieDev.egidiusII.model.dto.DadosExibirUsuario;
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
    private UsuarioRepository usuarioRepository;
    @Autowired
    private LocalEncontradoRepository localEncontradoRepository;

    public void cadastrar(DadosCadastroUsuario dados) {
        Usuario usuario = new Usuario(dados);
        var local = localEncontradoRepository.findById(dados.localEncontrado());

        if (local.isPresent()) {
            var l = local.get();
            usuario.setLocalEncontrado(l);
        }

        usuarioRepository.save(usuario);
    }

    public void atualizar(DadosExibirUsuario dados) {
        var usuario = usuarioRepository.getReferenceById(dados.id());
        usuario.atualizarDados(dados);
    }

    public List<DadosExibirUsuario> buscarTodos(){
        return  conversorDadosList(usuarioRepository.findAll());
    }

    public DadosExibirUsuario buscarCpf(String cpf){
        var u = usuarioRepository.findByCpf(cpf);

        if (u.isPresent()){
            var usuario = u.get();
            return conversorDados(usuario);
        }
        return null;
    }

    public List<DadosExibirUsuario> buscarNome (String nome){
        return  conversorDadosList(usuarioRepository.findByNomeContainingIgnoreCase(nome));
    }

    /*---Métodos Privados de uso apenas da Classe---*/
    private List<DadosExibirUsuario> conversorDadosList(List<Usuario> usuarioList){
        return usuarioList
                .stream()
                .sorted(Comparator.comparing(Usuario::getNome))
                .map(usuario -> new DadosExibirUsuario(usuario.getId(), usuario.getNome(), usuario.getMae(), usuario.getPai()
                                                        , usuario.getDataNascimento(), usuario.getCpf(), usuario.getSexo()
                                                        , usuario.getLocalEncontrado().getNome(),usuario.getDataAbordagem(),
                        usuario.getAtendimentos()
                                .stream().sorted(Comparator.comparing(Atendimento::getDataAtendimento)).map(atendimento -> new DadosExibirAtendimento(atendimento.getDataAtendimento(),atendimento.getDescricaoAtendimento(),atendimento.getLocalAtendimento().getNome()
                                ,atendimento.getTecnico().getNome(), atendimento.getUsuario().getNome()))
                                .collect(Collectors.toList())))
                .collect(Collectors.toList());
    }
    private DadosExibirUsuario conversorDados(Usuario usuario){
        return new DadosExibirUsuario(usuario.getId(),usuario.getNome(), usuario.getMae(), usuario.getPai()
                , usuario.getDataNascimento(), usuario.getCpf(), usuario.getSexo()
                , usuario.getLocalEncontrado().getNome(),usuario.getDataAbordagem(),usuario.getAtendimentos()
                .stream().map(atendimento -> new DadosExibirAtendimento(atendimento.getDataAtendimento(),atendimento.getDescricaoAtendimento(),atendimento.getLocalAtendimento().getNome()
                        ,atendimento.getTecnico().getNome(), atendimento.getUsuario().getNome()))
                .collect(Collectors.toList()));
    }

}
