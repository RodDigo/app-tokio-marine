package com.tokio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tokio.domain.Conta;

@Repository
public interface ContaRepository extends JpaRepository<Conta, Integer> {

}
