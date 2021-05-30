package com.food.api.core.jackson;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.module.SimpleModule;
import com.food.domain.model.Cidade;
import com.food.domain.model.Cozinha;
import com.food.domain.model.Restaurante;
import com.food.domain.model.mixin.CidadeMixin;
import com.food.domain.model.mixin.CozinhaMixin;
import com.food.domain.model.mixin.RestauranteMixin;

@Component
public class JacksonMixinModule extends SimpleModule {

	/**
	 * SerialVersionUID
	 */
	private static final long serialVersionUID = 342303287977364648L;
	
	public JacksonMixinModule() {
		setMixInAnnotation(Restaurante.class, RestauranteMixin.class);
	    setMixInAnnotation(Cidade.class, CidadeMixin.class);
	    setMixInAnnotation(Cozinha.class, CozinhaMixin.class);
	}
}
