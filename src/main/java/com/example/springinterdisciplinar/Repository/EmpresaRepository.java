package com.example.springinterdisciplinar.Repository;

import com.example.springinterdisciplinar.Model.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpresaRepository extends JpaRepository<Empresa, Long> {
}
