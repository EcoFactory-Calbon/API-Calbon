package com.example.springinterdisciplinar.Service;

import com.example.springinterdisciplinar.Dto.AdminRequestDTO;
import com.example.springinterdisciplinar.Dto.AdminResponseDTO;
import com.example.springinterdisciplinar.Dto.FuncionarioRequestDTO;
import com.example.springinterdisciplinar.Dto.FuncionarioResponseDTO;
import com.example.springinterdisciplinar.Exception.AdminNaoEncontradoException;
import com.example.springinterdisciplinar.Exception.FuncionarioNaoEncontradoException;
import com.example.springinterdisciplinar.Model.Admin;
import com.example.springinterdisciplinar.Model.Funcionario;
import com.example.springinterdisciplinar.Repository.FuncionarioRepository;
import com.example.springinterdisciplinar.Validation.FuncionarioPatchValidation;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class FuncionarioService {

    private final FuncionarioRepository funcionarioRepository;
    private final ObjectMapper objectMapper;
    private final FuncionarioPatchValidation funcionarioPatchValidation;


    public FuncionarioService(FuncionarioRepository funcionarioRepository, ObjectMapper objectMapper, FuncionarioPatchValidation funcionarioPatchValidation) {
        this.funcionarioRepository = funcionarioRepository;
        this.objectMapper = objectMapper;
        this.funcionarioPatchValidation = funcionarioPatchValidation;
    }

    private Funcionario fromRequestDTO(FuncionarioRequestDTO dto){
        Funcionario funcionario = new Funcionario();
        funcionario.setNome(dto.getNome());
        funcionario.setSobrenome(dto.getSobrenome());
        funcionario.setEmail(dto.getEmail());
        funcionario.setNumero_cracha(dto.getNumero_cracha());
        funcionario.setId_cargo(dto.getId_cargo());
        funcionario.setIs_gestor(dto.getIs_gestor());
        return funcionario;
    }


    private FuncionarioResponseDTO toResponseDTO(Funcionario funcionario) {
        return new FuncionarioResponseDTO(
                funcionario.getId(),
                funcionario.getNome(),
                funcionario.getSobrenome(),
                funcionario.getEmail(),
                funcionario.getNumero_cracha(),
                funcionario.getIs_gestor()
        );
    }


    public List<FuncionarioResponseDTO> listar(){
        return funcionarioRepository.findAll()
                .stream()
                .map(this::toResponseDTO)
                .collect(Collectors.toList());
    }


    public FuncionarioResponseDTO inserirFuncionario(FuncionarioRequestDTO dto){
        Funcionario funcionario = fromRequestDTO(dto);
        Funcionario salvo = funcionarioRepository.save(funcionario);
        return toResponseDTO(salvo);    }

    public void excluirFuncionario(Long id) {
        Funcionario funcionario = funcionarioRepository.findById(id)
                .orElseThrow(() -> new FuncionarioNaoEncontradoException("Funcionário não encontrado com ID "+ id + " não foi encontrado"));
        funcionarioRepository.delete(funcionario);
    }



    public FuncionarioResponseDTO atualizarFuncionario(@Valid FuncionarioRequestDTO funcionarioAtualizado, Long id) {
        Funcionario existente = funcionarioRepository.findById(id)
                .orElseThrow(() -> new AdminNaoEncontradoException("Funcionario com o id " + id + " não encontrado"));
        existente.setNome(funcionarioAtualizado.getNome());
        existente.setSobrenome(funcionarioAtualizado.getSobrenome());
        existente.setEmail(funcionarioAtualizado.getEmail());
        existente.setNumero_cracha(funcionarioAtualizado.getNumero_cracha());
        existente.setId_cargo(funcionarioAtualizado.getId_cargo());
        existente.setIs_gestor(funcionarioAtualizado.getIs_gestor());

        Funcionario atualizado = funcionarioRepository.save(existente);
        return toResponseDTO(atualizado);

    }


    public FuncionarioResponseDTO atualizarFuncionarioParcialmente(Map<String, Object> updates, Long id) {
        Funcionario existente = funcionarioRepository.findById(id)
                .orElseThrow(() -> new AdminNaoEncontradoException("Funcionario com o id " + id+ " não foi encontrado"));
        funcionarioPatchValidation.validar(updates);

        if(updates.containsKey("nome")){
            existente.setNome(updates.get("nome").toString());
        }
        if (updates.containsKey("sobrenome")) {
            existente.setSobrenome(updates.get("sobrenome").toString());
        }
        if (updates.containsKey("email")) {
            existente.setEmail(updates.get("email").toString());
        }
        if (updates.containsKey("numero_cracha")) {
            existente.setNumero_cracha(updates.get("numero_cracha").toString());
        }
        if (updates.containsKey("id_cargo")) {
            existente.setId_cargo(Long.parseLong(updates.get("id_cargo").toString()));
        }
        if (updates.containsKey("is_gestor")) {
            existente.setIs_gestor(Boolean.parseBoolean(updates.get("is_gestor").toString()));
        }
        Funcionario atualizado = funcionarioRepository.save(existente);
        return toResponseDTO(atualizado);
    }

}
