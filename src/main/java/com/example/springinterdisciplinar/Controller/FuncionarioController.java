package com.example.springinterdisciplinar.Controller;

import com.example.springinterdisciplinar.Dto.AdminRequestDTO;
import com.example.springinterdisciplinar.Dto.AdminResponseDTO;
import com.example.springinterdisciplinar.Dto.FuncionarioRequestDTO;
import com.example.springinterdisciplinar.Dto.FuncionarioResponseDTO;
import com.example.springinterdisciplinar.Model.Funcionario;
import com.example.springinterdisciplinar.Service.FuncionarioService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/funcionario")
public class FuncionarioController {
    private final FuncionarioService funcionarioService;

    public FuncionarioController( FuncionarioService funcionarioService) {
        this.funcionarioService = funcionarioService;
    }

    @GetMapping("/listar")
    public ResponseEntity<List<FuncionarioResponseDTO>> listarAdmin() {
        List<FuncionarioResponseDTO> funcionarios = funcionarioService.listar();
        return ResponseEntity.ok(funcionarios);
    }

    @PostMapping("/inserir")
    public ResponseEntity<FuncionarioResponseDTO> adicionarAdmin(@RequestBody @Valid FuncionarioRequestDTO dto) {
       FuncionarioResponseDTO response = funcionarioService.inserirFuncionario(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @DeleteMapping("/excluir/{id}")
    public ResponseEntity<Funcionario> excluirFuncionario(@PathVariable Long id) {
        funcionarioService.excluirFuncionario(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<FuncionarioResponseDTO> atualizarFuncionario(@PathVariable Long id, @RequestBody @Valid FuncionarioRequestDTO dto) {
        FuncionarioResponseDTO response = funcionarioService.atualizarFuncionario(dto, id);
        return ResponseEntity.ok(response);
    }
    @PatchMapping("/atualizar/{id}")
    public ResponseEntity<FuncionarioResponseDTO> atualizarParcialmenteFuncionario(@PathVariable Long id, @RequestBody Map<String, Object> updates) {
       FuncionarioResponseDTO response = funcionarioService.atualizarFuncionarioParcialmente(updates, id);
        return ResponseEntity.ok(response);
    }
}
