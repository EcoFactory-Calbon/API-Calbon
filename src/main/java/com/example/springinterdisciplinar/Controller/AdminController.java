package com.example.springinterdisciplinar.Controller;

import com.example.springinterdisciplinar.Dto.AdminRequestDTO;
import com.example.springinterdisciplinar.Dto.AdminResponseDTO;
import com.example.springinterdisciplinar.Service.AdminService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/admin")
public class AdminController {

    private final AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    // GET - listar todos os admins
    @GetMapping("/listar")
    public ResponseEntity<List<AdminResponseDTO>> listarAdmin() {
        List<AdminResponseDTO> admins = adminService.listar();
        return ResponseEntity.ok(admins);
    }

    // POST - adicionar admin
    @PostMapping("/inserir")
    public ResponseEntity<AdminResponseDTO> adicionarAdmin(@RequestBody @Valid AdminRequestDTO dto) {
        AdminResponseDTO response = adminService.inserirAdmin(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    // DELETE - excluir admin por email
    @DeleteMapping("/excluir/{email}")
    public ResponseEntity<Void> excluirAdmin(@PathVariable String email) {
        adminService.excluirAdmin(email);
        return ResponseEntity.noContent().build();
    }

    // PUT - atualizar admin totalmente
    @PutMapping("/atualizar/{email}")
    public ResponseEntity<AdminResponseDTO> atualizarAdmin(@PathVariable String email, @RequestBody @Valid AdminRequestDTO dto) {
        AdminResponseDTO response = adminService.atualizarAdmin(dto, email);
        return ResponseEntity.ok(response);
    }

    // PATCH - atualizar admin parcialmente
    @PatchMapping("/atualizar/{email}")
    public ResponseEntity<AdminResponseDTO> patchAdmin(@PathVariable String email, @RequestBody Map<String, Object> updates) {
        AdminResponseDTO response = adminService.atualizarAdminParcialmente(updates, email);
        return ResponseEntity.ok(response);
    }
}
