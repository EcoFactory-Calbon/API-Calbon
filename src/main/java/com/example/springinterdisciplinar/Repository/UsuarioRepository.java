package com.example.springinterdisciplinar.Repository;

import com.example.springinterdisciplinar.Model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
