package com.food.domain.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.food.domain.model.Cidade;

/**
 * Repositorio de Cidade
 */
@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Long> {
	
}
