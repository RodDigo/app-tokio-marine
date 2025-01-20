package com.tokio.domain;

import java.util.Date;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Transferencia extends AbstractEntity<Integer> {
	
	private Double valor;
	private Double taxa;
	private Double taxaFixa;
	private Double total;
	private String titular;
	private Date dtTransferencia;
	private Date dtAgendamento;
	private int idContaOrigem;
	private int idContaDestino;
	

}
