package com.example.springinterdisciplinar.Service;

import com.example.springinterdisciplinar.Exception.AdminNaoEncontradoException;
import com.example.springinterdisciplinar.Model.Admin;
import com.example.springinterdisciplinar.Repository.AdminRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {

    private final AdminRepository adminRepository;
    public AdminService(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    public List<Admin> listar() {
        return adminRepository.findAll();
    }

    public Admin inserirAdmin(Admin admin) {
        return adminRepository.save(admin);
    }

    public void excluirAdmin(String email) {
        Admin admin = adminRepository.findByEmail(email)
                .orElseThrow(() -> new AdminNaoEncontradoException("Admin "+ email +" não encontrado"));
        adminRepository.delete(admin);
    }

    //    public Admin atualizarProduto(Admin adminAtualizado, String email) {
    //        Admin existente = adminRepository.findByEmail(email)
    //                .orElseThrow(() -> new AdminNaoEncontradoException("Admin com o Email " + email + " não encontrado"));
    //        if (adminAtualizado.getNome().equals(existente.getNome())) {
    //            existente.setNome(adminAtualizado.getNome());
    //        }
    //        if (adminAtualizado.getSenha().equals(existente.getSenha())) {
    //            existente.setSenha(adminAtualizado.getSenha());
    //        }
    //        validarProduto(existente);
    //        return produtoRepository.save(existente);
    //    }

    }
