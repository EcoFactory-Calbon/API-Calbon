package com.example.springinterdisciplinar.Validation;

import com.example.springinterdisciplinar.Exception.DadosInvalidosException;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class AdminPatchValidation {
    public void validar(Map<String, Object> updates){
        Map<String, String> erros = new HashMap<>();
        if (updates.containsKey("nome")) {
            String nome = updates.get("nome").toString();
            if (nome.isBlank()) {
                erros.put("nome", "Nome não pode ser vazio");
            }
        }
        if (updates.containsKey("senha")) {
            String senha = updates.get("senha").toString();
            if (senha.isBlank()) {
                erros.put("senha", "Senha não pode ser vazio");
            }
        }
        if (!erros.isEmpty()) {
            throw new DadosInvalidosException(erros.toString());
        }
    }

}
