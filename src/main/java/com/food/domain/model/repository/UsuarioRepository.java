package com.food.domain.model.repository;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.food.domain.model.Usuario;

@Repository
public interface UsuarioRepository extends CustomJpaRepository<Usuario, Long> {

	Optional<Usuario> findByEmail(String email);
}
