package com.wokieDev.egidiusII.service;

import com.wokieDev.egidiusII.model.Atendimento;
import com.wokieDev.egidiusII.model.DadosCadastroAtendimento;
import com.wokieDev.egidiusII.model.dto.DadosExibirAtendimento;
import com.wokieDev.egidiusII.repository.AtendimentoRepository;
import com.wokieDev.egidiusII.repository.LocalEncontradoRepository;
import com.wokieDev.egidiusII.repository.TecnicoRepository;
import com.wokieDev.egidiusII.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AtendimentoService {

    @Autowired
    private AtendimentoRepository atendimentoRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private TecnicoRepository tecnicoRepository;
    @Autowired
    private LocalEncontradoRepository localEncontradoRepository;

    public DadosExibirAtendimento cadastrar(DadosCadastroAtendimento dados) {
        var usuario = usuarioRepository.getReferenceById(dados.usuario());
        var tecnico = tecnicoRepository.getReferenceById(dados.tecnico());
        var localAtendimento = localEncontradoRepository.getReferenceById(dados.localAtendimento());

        Atendimento atendimento = new Atendimento(dados);
        List<Atendimento> atendimentoList = new ArrayList<>();

        atendimento.setLocalAtendimento(localAtendimento);
        atendimento.setUsuario(usuario);
        atendimento.setTecnico(tecnico);
        atendimentoList.add(atendimento);

        usuario.setAtendimentos(atendimentoList);
        tecnico.setAtendimentos(atendimentoList);
        atendimentoRepository.save(atendimento);
        return convertDados(atendimento);
    }

    public List<DadosExibirAtendimento> buscarTodos() {
        return convertList(atendimentoRepository.findAll());
    }

    public List<DadosExibirAtendimento> buscarDataAtendimento(LocalDate dataAtendimento){
        return convertList(atendimentoRepository.findAllByDataAtendimento(dataAtendimento));
    }

    public List<DadosExibirAtendimento> buscarPorUsuario(Long idUsuario){
        return convertList(atendimentoRepository.findAllByUsuarioId(idUsuario));
    }

    public List<DadosExibirAtendimento> buscarPorTecnico(Long idTecnico){
        return convertList(atendimentoRepository.findAllByTecnicoId(idTecnico));
    }

    public DadosExibirAtendimento bucaPorId(Long id){
        return convertDados(atendimentoRepository.getReferenceById(id));
    }

    /*--Métodos Privados--*/
    private List<DadosExibirAtendimento> convertList(List<Atendimento> atendimentoList){
        return atendimentoList.stream().sorted(Comparator.comparing(Atendimento::getDataAtendimento).reversed())
                .map(a -> new DadosExibirAtendimento(a.getId(),a.getDataAtendimento(), a.getDescricaoAtendimento(),a.getLocalAtendimento().getNome()
                ,a.getTecnico().getNome(), a.getUsuario().getNome())).collect(Collectors.toList());
    }

    private DadosExibirAtendimento convertDados(Atendimento atendimento){
        return new DadosExibirAtendimento(atendimento.getId(), atendimento.getDataAtendimento(), atendimento.getDescricaoAtendimento(), atendimento.getLocalAtendimento().getNome(),
                atendimento.getTecnico().getNome(), atendimento.getUsuario().getNome());
    }
}
