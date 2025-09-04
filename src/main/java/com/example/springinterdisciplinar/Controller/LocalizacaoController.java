package com.example.springinterdisciplinar.Controller;

import com.example.springinterdisciplinar.Dto.FuncionarioResponseDTO;
import com.example.springinterdisciplinar.Dto.LocalizacaoRequestDTO;
import com.example.springinterdisciplinar.Dto.LocalizacaoResponseDTO;
import com.example.springinterdisciplinar.Model.Funcionario;
import com.example.springinterdisciplinar.Model.Localizacao;
import com.example.springinterdisciplinar.Service.LocalizacaoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/localizacao")
public class LocalizacaoController {

    private final LocalizacaoService localizacaoService;

    public LocalizacaoController(LocalizacaoService localizacaoService) {
        this.localizacaoService = localizacaoService;
    }

    @GetMapping("/listar")
    public ResponseEntity<List<LocalizacaoResponseDTO>> listarLocalizacao() {
        List<LocalizacaoResponseDTO> localizacoes = localizacaoService.listar();
        return ResponseEntity.ok(localizacoes);
    }

    @PostMapping("/inserir")
    public ResponseEntity<LocalizacaoResponseDTO> inserirLocalizacao(@RequestBody @Valid LocalizacaoRequestDTO dto) {
        LocalizacaoResponseDTO response = localizacaoService.inserirLocalizacao(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);

    }

    @DeleteMapping("/excluir/{id}")
    public ResponseEntity<Localizacao> excluirLocalizacao(@PathVariable Long id) {
        localizacaoService.excluirLocalizacao(id);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/atualizar/{id}")
    public ResponseEntity<LocalizacaoResponseDTO> atualizarParcialmenteLocalizacao(@PathVariable Long id, @RequestBody Map<String, Object> updates) {
        LocalizacaoResponseDTO response = localizacaoService.atualizarParcialmenteLocalizacao(updates, id);
        return ResponseEntity.ok(response);
    }


}

