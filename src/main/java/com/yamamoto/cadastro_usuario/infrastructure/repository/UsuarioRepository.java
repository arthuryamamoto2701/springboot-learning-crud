package com.yamamoto.cadastro_usuario.infrastructure.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yamamoto.cadastro_usuario.infrastructure.entitys.Usuario;

import jakarta.transaction.Transactional;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    
    Optional <Usuario> findByEmail(String email);
    // Optional evita o NullPointerException e exige tratamento com excessão ou alternativa caso o email não exista. 

    @Transactional // Garante que a operação de exclusão seja executada dentro de uma transação, garantindo a integridade dos dados.
    void deleteByEmail(String email);
}
