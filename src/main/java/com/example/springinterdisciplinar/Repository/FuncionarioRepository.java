package com.example.springinterdisciplinar.Repository;
import com.example.springinterdisciplinar.Model.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long>{
}
