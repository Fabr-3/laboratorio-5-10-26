package com.infrastructure.persistence;

import com.domain.Usuario;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario,Long> {
    
    // Filtra automáticamente a nivel de base de datos
    List<Usuario> findByEliminadoFalse();
    
}