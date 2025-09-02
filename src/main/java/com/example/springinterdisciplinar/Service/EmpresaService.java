package com.example.springinterdisciplinar.Service;

import com.example.springinterdisciplinar.Dto.AdminRequestDTO;
import com.example.springinterdisciplinar.Dto.AdminResponseDTO;
import com.example.springinterdisciplinar.Dto.EmpresaRequestDTO;
import com.example.springinterdisciplinar.Dto.EmpresaResponseDTO;
import com.example.springinterdisciplinar.Model.Admin;
import com.example.springinterdisciplinar.Model.Empresa;
import com.example.springinterdisciplinar.Repository.EmpresaRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmpresaService {
    private final EmpresaRepository empresaRepository;
    private final ObjectMapper objectMapper;

    public EmpresaService(EmpresaRepository empresaRepository, ObjectMapper objectMapper) {
        this.empresaRepository = empresaRepository;
        this.objectMapper = objectMapper;
    }


    private Empresa fromRequestDTO(EmpresaRequestDTO dto){
        Empresa empresa = new Empresa();
        empresa.setId(dto.getId());
        empresa.setNome(dto.getNome());
        empresa.setId_localizacao(dto.getId_localizacao());
        empresa.setId_categoria_empresa(dto.getId_categoria_empresa());
        return empresa;
    }


    private EmpresaResponseDTO toResponseDTO(Empresa empresa) {
        return new EmpresaResponseDTO(
                empresa.getId(),
                empresa.getNome(),
                empresa.getId_localizacao(),
                empresa.getId_categoria_empresa()
        );
    }

    public List<EmpresaResponseDTO> listar(){
        return empresaRepository.findAll()
                .stream()
                .map(this::toResponseDTO)
                .collect(Collectors.toList());
    }

}
