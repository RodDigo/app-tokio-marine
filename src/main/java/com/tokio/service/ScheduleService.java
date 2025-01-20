package com.tokio.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tokio.domain.Conta;
import com.tokio.domain.Transferencia;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ScheduleService {
	
	@Autowired
	private final ContaService contaService;
	
	@Autowired
	private final TransferenciaService tranferenciaService;
	
	public void efetuaTransferencia(Integer idContaOigem, Integer idContaDestino) {
		
		Conta origem = contaService.findById(idContaOigem).get();
		Conta destino =  contaService.findById(idContaDestino).get();
		
		Transferencia tran = new Transferencia();
		
		Double subtraiOrigem =  origem.getValor() - tran.getTotal();
		origem.setValor(subtraiOrigem);
		contaService.update(origem);

		Double sumDestino =  origem.getValor() + tran.getTotal();
		destino.setValor(sumDestino);
		contaService.update(destino);
		
	}

}
