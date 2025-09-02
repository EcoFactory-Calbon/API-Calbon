package com.example.springinterdisciplinar.Validation;

import com.example.springinterdisciplinar.Exception.DadosInvalidosException;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class FuncionarioPatchValidation {
    public void validar(Map<String, Object> updates){
        Map<String, String> erros = new HashMap<>();

        if (updates.containsKey("nome")) {
            String nome = updates.get("nome").toString();
            if (nome.isBlank()) {
                erros.put("nome", "Nome não pode ser vazio");
            }
        }
        if (updates.containsKey("sobrenome")) {
            String sobrenome = updates.get("sobrenome").toString();
            if (sobrenome.isBlank()) {
                erros.put("sobrenome", "sobrenome não pode ser vazio");
            }
        }
        if (updates.containsKey("email")) {
            String email = updates.get("email").toString();
            if (email.isBlank()) {
                erros.put("email", "email não pode ser vazio");
            }
        }
        if (updates.containsKey("numero_cracha")) {
            String numero_cracha = updates.get("numero_cracha").toString();
            if (numero_cracha.isBlank()) {
                erros.put("numero_cracha", "numero do cracha não pode ser vazio");
            }
        }
        if (updates.containsKey("id_cargo")) {
            String id_cargo = updates.get("numero_cracha").toString();
            if (id_cargo.isBlank()) {
                erros.put("id_cargo", "id_cargo não pode ser vazio");
            }
        }


        if (!erros.isEmpty()) {
            throw new DadosInvalidosException(erros.toString());
        }
    }
}
