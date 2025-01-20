package com.tokio.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tokio.domain.Conta;
import com.tokio.domain.Transferencia;

@Repository
public interface TransferenciaRepository extends JpaRepository<Transferencia, Integer> {

	List<Transferencia> findByEfetuado(int efetuado);
	
}
