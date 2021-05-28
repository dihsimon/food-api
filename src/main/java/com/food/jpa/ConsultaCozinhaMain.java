package com.food.jpa;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.food.FoodApiApplication;
import com.food.domain.model.Cozinha;

public class ConsultaCozinhaMain {
	
	public static void main(String[] args) {
		
		ApplicationContext apliApplicationContext = new SpringApplicationBuilder(FoodApiApplication.class)
				.web(WebApplicationType.NONE)
				.run(args);
		
		CadastroCozinha cadastroCozinha =  apliApplicationContext.getBean(CadastroCozinha.class);
		
		Cozinha c = new Cozinha();
		c.setNome("Japonesa");
		
		System.out.println(cadastroCozinha.listar());
	}
}
