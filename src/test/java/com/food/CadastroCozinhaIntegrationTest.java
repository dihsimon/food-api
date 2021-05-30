package com.food;

import static org.assertj.core.api.Assertions.assertThat;

import javax.validation.ConstraintViolationException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.food.domain.exception.CozinhaNaoEncontradaException;
import com.food.domain.exception.EntidadeEmUsoException;
import com.food.domain.model.Cozinha;
import com.food.domain.service.CadastroCozinhaService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CadastroCozinhaIntegrationTest {

	@Autowired
	private CadastroCozinhaService cadastroCozinhaService;

	@Test
	public void deveAtribuirId_QuandoCadastrarCozinhaComDadosCorretos() {

		Cozinha novaCozinha = new Cozinha();
		novaCozinha.setNome("Chinesa");

		novaCozinha = cadastroCozinhaService.salvar(novaCozinha);
		assertThat(novaCozinha);
		assertThat(novaCozinha.getId()).isNotNull();
	}

	@Test(expected = ConstraintViolationException.class)
	public void deveFalhar_QuandoCadastrarCozinhaSemNome() {
		Cozinha novaCozinha = new Cozinha();
		novaCozinha.setNome(null);

		novaCozinha = cadastroCozinhaService.salvar(novaCozinha);
	}

	@Test(expected = EntidadeEmUsoException.class)
	public void deveFalhar_QuandoExcluirCozinhaEmUso() {
		cadastroCozinhaService.excluir(1L);
	}

	@Test(expected = CozinhaNaoEncontradaException.class)
	public void deveFalhar_QuandoExcluirCozinhaInexistente() {
		cadastroCozinhaService.excluir(100L);
	}

}
