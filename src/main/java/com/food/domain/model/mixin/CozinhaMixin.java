package com.food.domain.model.mixin;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.food.domain.model.Restaurante;

public class CozinhaMixin {

	@JsonIgnore
    private List<Restaurante> restaurantes;
}
