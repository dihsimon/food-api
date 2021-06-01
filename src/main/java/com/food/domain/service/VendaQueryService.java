package com.food.domain.service;

import java.util.List;

import com.food.domain.model.dto.VendaDiaria;
import com.food.domain.model.filter.VendaDiariaFilter;

public interface VendaQueryService {

	List<VendaDiaria> consultarVendasDiarias(VendaDiariaFilter filtro, String timeOffset);
}
