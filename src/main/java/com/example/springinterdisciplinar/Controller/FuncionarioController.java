package com.example.springinterdisciplinar.Controller;

import com.example.springinterdisciplinar.Model.Funcionario;
import com.example.springinterdisciplinar.Service.FuncionarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/funcionario")
public class FuncionarioController {
    private final FuncionarioService funcionarioService;

    public FuncionarioController( FuncionarioService funcionarioService) {
        this.funcionarioService = funcionarioService;
    }

    @GetMapping("/listar")
    public ResponseEntity<List<Funcionario>> listarFuncionario() {
        List<Funcionario> funcionarios = funcionarioService.listarFuncionario();
        return ResponseEntity.ok(funcionarios);
    }

    @PostMapping("/inserir")
    public ResponseEntity<Funcionario> adicionarFuncionario(@RequestBody Funcionario funcionario) {
        Funcionario novo = funcionarioService.inserirFuncionario(funcionario);
        return ResponseEntity.status(HttpStatus.CREATED).body(novo);
    }

    @DeleteMapping("/excluir/{id}")
    public ResponseEntity<Funcionario> excluirFuncionario(@PathVariable Long id) {
        funcionarioService.excluirFuncionario(id);
        return ResponseEntity.noContent().build();
    }
}
