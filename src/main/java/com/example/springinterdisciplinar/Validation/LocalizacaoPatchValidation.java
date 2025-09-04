package com.example.springinterdisciplinar.Validation;

import com.example.springinterdisciplinar.Exception.DadosInvalidosException;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class LocalizacaoPatchValidation {

//    public void validar(Map<String, Object> updates){
//        Map<String, String> erros = new HashMap<>();
//
//        if (updates.containsKey("nome")) {
//            String nome = updates.get("nome").toString();
//            if (nome.isBlank()) {
//                erros.put("nome", "Nome não pode ser vazio");
//            }
//        }

    public void validar(Map<String, Object> updates){
        Map<String, String> erros = new HashMap<>();

        if (updates.containsKey("estado")){
            String estado = updates.get("estado").toString();
            if (estado.isBlank()){
                erros.put("estado", "Estado não pode estar vazio");
            }
            if (estado.length() != 2 ){
                erros.put("estado", "O estado pode ter apenas 2 caracteres");
            }
        }
        if (updates.containsKey("cidade")){
            String cidade = updates.get("cidade").toString();
            if (cidade.isBlank()){
                erros.put("cidade", "Cidade não pode estar vazio");
            }
        }
        if (!erros.isEmpty()) {
            throw new DadosInvalidosException(erros.toString());
        }
    }



}
