package com.food.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.food.domain.exception.CozinhaNaoEncontradaException;
import com.food.domain.exception.EntidadeEmUsoException;
import com.food.domain.model.Cozinha;
import com.food.domain.model.repository.CozinhaRepository;

@Service
public class CadastroCozinhaService {

	private static final String MSG_COZINHA_EM_USO = "Cozinha de código %d não pode ser removida, pois está em uso";

	@Autowired
	private CozinhaRepository cozinhaRepository;

	public Cozinha salvar(Cozinha cozinha) {
		return cozinhaRepository.save(cozinha);
	}

	@Transactional
	public void excluir(Long cozinhaId) {
	    try {
	        cozinhaRepository.deleteById(cozinhaId);
	        cozinhaRepository.flush();
	        
	    } catch (EmptyResultDataAccessException e) {
	        throw new CozinhaNaoEncontradaException(cozinhaId);
	    
	    } catch (DataIntegrityViolationException e) {
	        throw new EntidadeEmUsoException(
	            String.format(MSG_COZINHA_EM_USO, cozinhaId));
	    }
	}

	public Cozinha buscarOuFalhar(Long cozinhaId) {
	    return cozinhaRepository.findById(cozinhaId)
	        .orElseThrow(() -> new CozinhaNaoEncontradaException(cozinhaId));
	}       
}
