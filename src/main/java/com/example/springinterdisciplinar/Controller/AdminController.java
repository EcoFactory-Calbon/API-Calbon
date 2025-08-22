package com.example.springinterdisciplinar.Controller;

import com.example.springinterdisciplinar.Model.Admin;
import com.example.springinterdisciplinar.Model.Funcionario;
import com.example.springinterdisciplinar.Service.AdminService;
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
    public ResponseEntity<List<Admin>> listarAdmin() {
        List<Admin> admins = adminService.listar();
        return ResponseEntity.ok(admins);

    }

    @PostMapping("/adicionar")
    public ResponseEntity<Admin> adicionarFuncionario(@RequestBody Admin admin) {
        Admin novo = adminService.inserirAdmin(admin);
        return ResponseEntity.status(HttpStatus.CREATED).body(novo);
    }

    @DeleteMapping("/excluir/{email}")
    public ResponseEntity<Admin> excluirAdmin(@PathVariable String email) {
        adminService.excluirAdmin(email);
        return ResponseEntity.noContent().build();
    }
}
