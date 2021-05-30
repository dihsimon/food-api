package com.food.api.core.jackson;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.module.SimpleModule;
import com.food.api.model.mixin.CidadeMixin;
import com.food.api.model.mixin.CozinhaMixin;
import com.food.domain.model.Cidade;
import com.food.domain.model.Cozinha;

@Component
public class JacksonMixinModule extends SimpleModule {

	/**
	 * SerialVersionUID
	 */
	private static final long serialVersionUID = 342303287977364648L;
	
	public JacksonMixinModule() {
	    setMixInAnnotation(Cidade.class, CidadeMixin.class);
	    setMixInAnnotation(Cozinha.class, CozinhaMixin.class);
	}
}
