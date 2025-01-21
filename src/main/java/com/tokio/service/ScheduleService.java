package com.tokio.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.tokio.domain.Conta;
import com.tokio.domain.Transferencia;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ScheduleService {

	@Autowired
	private final ContaService contaService;

	@Autowired
	private final TransferenciaService tranferenciaService;

	private static final String CRON = "10,23 * * * * *";

	@Scheduled(cron = CRON)
	public void efetuaTransferencia() {

		List<Transferencia> transferencias = tranferenciaService.findByEfetuado(0);

		transferencias.forEach(t -> {

			if (t.getDtTransferencia().compareTo(new Date()) == 0
					|| t.getDtTransferencia().compareTo(new Date()) == -1) {
				Conta origem = contaService.findById(t.getIdContaOrigem()).get();
				Conta destino = contaService.findById(t.getIdContaDestino()).get();

				Double subtraiOrigem = origem.getValor() - t.getTotal();
				origem.setValor(subtraiOrigem);
				contaService.update(origem);

				Double sumDestino = destino.getValor() + t.getTotal();
				destino.setValor(sumDestino);
				contaService.update(destino);

				t.setEfetuado(1);
				tranferenciaService.update(t);
			}

		});
	}

}
