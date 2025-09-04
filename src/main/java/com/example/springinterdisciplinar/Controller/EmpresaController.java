package com.example.springinterdisciplinar.Controller;

import com.example.springinterdisciplinar.Dto.AdminRequestDTO;
import com.example.springinterdisciplinar.Dto.AdminResponseDTO;
import com.example.springinterdisciplinar.Dto.EmpresaRequestDTO;
import com.example.springinterdisciplinar.Dto.EmpresaResponseDTO;
import com.example.springinterdisciplinar.Model.Empresa;
import com.example.springinterdisciplinar.Service.EmpresaService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/empresa")
public class EmpresaController {

    private final EmpresaService empresaService;
    public EmpresaController(EmpresaService empresaService) {
        this.empresaService = empresaService;
    }

    @GetMapping("/listar")
    public ResponseEntity<List<EmpresaResponseDTO>> listarEmpresa() {
        List<EmpresaResponseDTO> empresas = empresaService.listar();
        return ResponseEntity.ok(empresas);
    }

    @PostMapping("/inserir")
    public ResponseEntity<EmpresaResponseDTO> adicionarEmpresa(@RequestBody @Valid EmpresaRequestDTO dto) {
        EmpresaResponseDTO response = empresaService.inserirEmpresa(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @DeleteMapping("/excluir/{id}")
    public ResponseEntity<Void> excluirEmpresa(@PathVariable Long id) {
        empresaService.excluirEmpresa(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<EmpresaResponseDTO> atualizarEmpresa(@PathVariable Long id, @RequestBody @Valid EmpresaRequestDTO dto) {
        EmpresaResponseDTO response = empresaService.atualizarEmpresa(dto, id);
        return ResponseEntity.ok(response);
    }
}
