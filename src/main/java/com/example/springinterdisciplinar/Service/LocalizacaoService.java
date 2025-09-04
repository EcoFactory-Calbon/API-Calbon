package com.example.springinterdisciplinar.Service;

import com.example.springinterdisciplinar.Dto.FuncionarioRequestDTO;
import com.example.springinterdisciplinar.Dto.FuncionarioResponseDTO;
import com.example.springinterdisciplinar.Dto.LocalizacaoRequestDTO;
import com.example.springinterdisciplinar.Dto.LocalizacaoResponseDTO;
import com.example.springinterdisciplinar.Exception.AdminNaoEncontradoException;
import com.example.springinterdisciplinar.Exception.FuncionarioNaoEncontradoException;
import com.example.springinterdisciplinar.Exception.LocalizacaoNaoEncontradaException;
import com.example.springinterdisciplinar.Model.Funcionario;
import com.example.springinterdisciplinar.Model.Localizacao;
import com.example.springinterdisciplinar.Repository.FuncionarioRepository;
import com.example.springinterdisciplinar.Repository.LocalizacaoRepository;
import com.example.springinterdisciplinar.Validation.LocalizacaoPatchValidation;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class LocalizacaoService {

    private final LocalizacaoRepository localizacaoRepository;
    private final LocalizacaoPatchValidation localizacaoPatchValidation;
    private final ObjectMapper objectMapper;

    public LocalizacaoService(LocalizacaoRepository localizacaoRepository, LocalizacaoPatchValidation localizacaoPatchValidation, ObjectMapper objectMapper) {
        this.localizacaoRepository = localizacaoRepository;
        this.objectMapper = objectMapper;
        this.localizacaoPatchValidation = localizacaoPatchValidation;
    }

    private Localizacao fromRequestDTO(LocalizacaoRequestDTO dto){
        Localizacao localizacao = new Localizacao();
        localizacao.setEstado(dto.getEstado());
        localizacao.setCidade(dto.getCidade());
        return localizacao;
    }


    private LocalizacaoResponseDTO toResponseDTO(Localizacao localizacao){
        return new LocalizacaoResponseDTO(
                localizacao.getId(),
                localizacao.getEstado(),
                localizacao.getCidade()
        );
    }


    public List<LocalizacaoResponseDTO> listar(){
        return localizacaoRepository.findAll()
                .stream()
                .map(this::toResponseDTO)
                .collect(Collectors.toList());
    }



    public LocalizacaoResponseDTO inserirLocalizacao(LocalizacaoRequestDTO dto){
        Localizacao localizacao = fromRequestDTO(dto);
        Localizacao salvo = localizacaoRepository.save(localizacao);
        return toResponseDTO(salvo);
    }

    public void excluirLocalizacao(Long id){
        Localizacao localizacao = localizacaoRepository.findById(id)
                .orElseThrow( () -> new LocalizacaoNaoEncontradaException("Localização com id: " + id + " não foi encontrada"));
        localizacaoRepository.delete(localizacao);

    }


    public LocalizacaoResponseDTO atualizarParcialmenteLocalizacao(Map<String, Object> updates, Long id){
        Localizacao existente = localizacaoRepository.findById(id)
                .orElseThrow(() -> new LocalizacaoNaoEncontradaException("Localização com o id: "+id+" não foi encontrado"));
        localizacaoPatchValidation.validar(updates);
        if (updates.containsKey("estado")) {
            existente.setEstado(updates.get("estado").toString());
        }
        if (updates.containsKey("cidade")) {
            existente.setCidade(updates.get("cidade").toString());
        }

        Localizacao atualizado = localizacaoRepository.save(existente);
        return toResponseDTO(atualizado);

    }
}
