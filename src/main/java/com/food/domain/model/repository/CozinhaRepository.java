package com.food.domain.model.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.food.domain.model.Cozinha;

@Repository
public interface CozinhaRepository extends CustomJpaRepository<Cozinha, Long> {

	List<Cozinha> findTodasByNomeContaining(String nome);
	
	Optional<Cozinha> findByNome(String nome);
	
	boolean existsByNome(String nome);

}
