package com.example.springinterdisciplinar.Repository;

import com.example.springinterdisciplinar.Model.Admin;
import com.example.springinterdisciplinar.Model.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AdminRepository extends JpaRepository<Admin, Integer> {

    Optional<Admin> findByEmail(String email);

}
