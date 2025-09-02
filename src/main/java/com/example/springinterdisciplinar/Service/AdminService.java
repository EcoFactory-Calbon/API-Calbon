package com.example.springinterdisciplinar.Service;

import com.example.springinterdisciplinar.Dto.AdminRequestDTO;
import com.example.springinterdisciplinar.Dto.AdminResponseDTO;
import com.example.springinterdisciplinar.Exception.AdminNaoEncontradoException;
import com.example.springinterdisciplinar.Model.Admin;
import com.example.springinterdisciplinar.Repository.AdminRepository;
import com.example.springinterdisciplinar.Validation.AdminPatchValidation;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class AdminService {

    private final AdminRepository adminRepository;
    private final AdminPatchValidation adminPatchValidation;
    private final ObjectMapper objectMapper;

    public AdminService(AdminRepository adminRepository, ObjectMapper objectMapper, AdminPatchValidation adminPatchValidation) {
        this.adminRepository = adminRepository;
        this.adminPatchValidation = adminPatchValidation;
        this.objectMapper = objectMapper;
    }

    private Admin fromRequestDTO(AdminRequestDTO dto){
        Admin admin = new Admin();
        admin.setEmail(dto.getEmail());
        admin.setNome(dto.getNome());
        admin.setSenha(dto.getSenha());
        return admin;
    }


    private AdminResponseDTO toResponseDTO(Admin admin) {
        return new AdminResponseDTO(
                admin.getEmail(),
                admin.getNome()
        );
    }

    public List<AdminResponseDTO> listar() {
        return adminRepository.findAll()
                .stream()
                .map(this::toResponseDTO)
                .collect(Collectors.toList());
    }

    public AdminResponseDTO inserirAdmin(AdminRequestDTO dto) {
        Admin admin = fromRequestDTO(dto);
        Admin salvo = adminRepository.save(admin);
        return toResponseDTO(salvo);
    }

    public void excluirAdmin(String email) {
        Admin admin = adminRepository.findByEmail(email)
                .orElseThrow(() -> new AdminNaoEncontradoException("Admin "+ email +" não encontrado"));
        adminRepository.delete(admin);
    }

    public AdminResponseDTO atualizarAdmin(@Valid AdminRequestDTO adminAtualizado, String email) {
        Admin existente = adminRepository.findByEmail(email)
                .orElseThrow(() -> new AdminNaoEncontradoException("Admin com o Email " + email + " não encontrado"));
        existente.setEmail(adminAtualizado.getEmail());
        existente.setNome(adminAtualizado.getNome());
        existente.setSenha(adminAtualizado.getSenha());

        Admin atualizado = adminRepository.save(existente);
        return toResponseDTO(atualizado);

    }


    public AdminResponseDTO atualizarAdminParcialmente(Map<String, Object> updates, String email) {
        Admin existente = adminRepository.findByEmail(email)
                .orElseThrow(() -> new AdminNaoEncontradoException("Admin com o Email " + email+ " não foi encontrado"));
        adminPatchValidation.validar(updates);

        if(updates.containsKey("email")){
            existente.setEmail(updates.get("email").toString());
        }
        if (updates.containsKey("nome")) {
            existente.setNome(updates.get("nome").toString());
        }
        if (updates.containsKey("senha")) {
            existente.setSenha(updates.get("senha").toString());
        }

        Admin atualizado = adminRepository.save(existente);
        return toResponseDTO(atualizado);
    }

    }
