package com.tokio.service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tokio.domain.Conta;
import com.tokio.domain.Transferencia;
import com.tokio.repository.TransferenciaRepository;

@Service
public class TransferenciaService {

	@Autowired
	private TransferenciaRepository repository;

	public List<Transferencia> findAll() {
		return repository.findAll();
	}
	
	public Optional<Transferencia> findById(Integer id) {
		return repository.findById(id);
	}

	public String create(Transferencia transferencia) {
		Long dias = this.validaTaxa(transferencia.getDtTransferencia());
		Double d = calculoTaxacao(dias, transferencia);
		
		if(d == null) {
			return "Taxa não aplicavel";
		} else {
			repository.save(transferencia);			
		}
		return "Ok";
		
	}

	public Long validaTaxa(Date days) {
		LocalDate dtToday = LocalDate.now();
		LocalDate dtAgendamento = convertToLocalDateViaInstant(days) ;
		long diasTaxacao = ChronoUnit.DAYS.between(dtToday, dtAgendamento);
		return diasTaxacao;
	}

	public LocalDate convertToLocalDateViaInstant(Date dateToConvert) {
	    return dateToConvert.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
	}

	public Double calculoTaxacao(long dias, Transferencia transferencia) {
		
		if(dias > 50) {
			return null;
		}

		double valorTotal = transferencia.getValor();
		
		transferencia.setTaxa(0.0);
		transferencia.setTaxaFixa(0.0);
		
		
		if(dias == 0 ) {
			transferencia.setTaxa(2.5);
			transferencia.setTaxaFixa(3.0);
			valorTotal +=  transferencia.getValor() * 2.5 / 100 + 3;
		}
		
		if(dias > 0 && dias <= 10) {
			transferencia.setTaxaFixa(3.0);
			valorTotal = transferencia.getValor()  + 3;
		}
		
		if(dias > 10 && dias <= 20) {
			transferencia.setTaxa(8.2);
			valorTotal += transferencia.getValor() * 8.2 / 100;
		}
		
		if(dias > 21 && dias <= 30) {
			transferencia.setTaxa(6.9);
			valorTotal +=  transferencia.getValor() * 6.9 / 100;
		}
		
		if(dias > 31 && dias <= 40) {
			transferencia.setTaxa(4.7);
			valorTotal +=  transferencia.getValor() * 4.7 / 100;
		}
		
		if(dias > 41 && dias <= 50) {
			transferencia.setTaxa(1.7);
			valorTotal +=  transferencia.getValor() * 1.7 / 100;
		}
		
		transferencia.setTotal(valorTotal);
		
		return valorTotal;
		
	}    
	     
}        
         