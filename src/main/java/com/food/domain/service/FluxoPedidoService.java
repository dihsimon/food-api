package com.food.domain.service;

import java.time.OffsetDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.food.domain.model.Pedido;

@Service
public class FluxoPedidoService {

	@Autowired
	private EmissaoPedidoService emissaoPedido;

	@Transactional
	public void confirmar(String codigoPedido) {
		Pedido pedido = emissaoPedido.buscarOuFalhar(codigoPedido);
		pedido.confirmar();
	}
	
	@Transactional
	public void cancelar(String codigoPedido) {
	    Pedido pedido = emissaoPedido.buscarOuFalhar(codigoPedido);
	    pedido.cancelar();
	}

	@Transactional
	public void entregar(String codigoPedido) {
	    Pedido pedido = emissaoPedido.buscarOuFalhar(codigoPedido);
	    pedido.entregar();
	    pedido.setDataEntrega(OffsetDateTime.now());
	}
}
