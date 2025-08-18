package com.example.springinterdisciplinar.Service;

import com.example.springinterdisciplinar.Exception.FuncionarioNaoEncontradoException;
import com.example.springinterdisciplinar.Model.Funcionario;
import com.example.springinterdisciplinar.Repository.FuncionarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FuncionarioService {

    private final FuncionarioRepository funcionarioRepository;

    public FuncionarioService(FuncionarioRepository funcionarioRepository) {
        this.funcionarioRepository = funcionarioRepository;
    }

    
    public List<Funcionario> listarFuncionario(){
        return funcionarioRepository.findAll();
    }


    public Funcionario inserirFuncionario(Funcionario funcionario){
        return funcionarioRepository.save(funcionario);
    }

    public void excluirFuncionario(Long id) {
        Funcionario funcionario = funcionarioRepository.findById(id)
                .orElseThrow(() -> new FuncionarioNaoEncontradoException("Funcionário não encontrado"));
        funcionarioRepository.delete(funcionario);
    }

}
