package com.example.springinterdisciplinar.Controller;

import com.example.springinterdisciplinar.Dto.AdminRequestDTO;
import com.example.springinterdisciplinar.Dto.AdminResponseDTO;
import com.example.springinterdisciplinar.Model.Admin;
import com.example.springinterdisciplinar.Model.Funcionario;
import com.example.springinterdisciplinar.Service.AdminService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    private final AdminService adminService;
    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @GetMapping("/listar")
    public ResponseEntity<List<AdminResponseDTO>> listarAdmin() {
        List<AdminResponseDTO> admins = adminService.listar()
                .stream()
                .map(a -> new AdminResponseDTO(a.getEmail(), a.getNome()))
                .toList();
        return ResponseEntity.ok(admins);
    }

    @PostMapping("/adicionar")
    public ResponseEntity<AdminResponseDTO> adicionarAdmin(@RequestBody @Valid AdminRequestDTO dto) {
        Admin novo = adminService.inserirAdmin(new Admin(dto.getEmail(), dto.getNome(), dto.getSenha()));
        AdminResponseDTO response = new AdminResponseDTO(novo.getEmail(), novo.getNome());
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @DeleteMapping("/excluir/{email}")
    public ResponseEntity<Admin> excluirAdmin(@PathVariable String email) {
        adminService.excluirAdmin(email);
        return ResponseEntity.noContent().build();
    }
}
