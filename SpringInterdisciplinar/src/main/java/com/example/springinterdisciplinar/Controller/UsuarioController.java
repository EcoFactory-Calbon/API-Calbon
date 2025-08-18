package com.example.springinterdisciplinar.Controller;

import com.example.springinterdisciplinar.Model.Funcionario;
import com.example.springinterdisciplinar.Model.Usuario;
import com.example.springinterdisciplinar.Service.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    private final UsuarioService usuarioService;
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping("/listar")
    public ResponseEntity<List<Usuario>> listarUsuario() {
        List<Usuario> usuarios = usuarioService.listar();
        return ResponseEntity.ok(usuarios);
    }

    @PostMapping("/adicionar")
    public ResponseEntity<Usuario> adicionarFuncionario(@RequestBody Usuario usuario) {
        Usuario novo = usuarioService.inserirUsuario(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(novo);
    }

    @DeleteMapping("/excluir/{id}")
    public ResponseEntity<Usuario> excluirUsuario(@PathVariable Long id) {
        usuarioService.excluirUsuario(id);
        return ResponseEntity.noContent().build();
    }

}
