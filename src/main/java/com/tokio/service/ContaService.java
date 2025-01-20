package com.tokio.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tokio.domain.Conta;
import com.tokio.repository.ContaRepository;

@Service
public class ContaService {
	
	@Autowired
	private ContaRepository repository;
	
	public List<Conta> findAll() {
		return repository.findAll();
	}
	
	public Optional<Conta> findById(Integer id) {
		return repository.findById(id);
	}
	
	public void create(Conta conta) {
		repository.save(conta);
	}
	
	public void update(Conta conta) {
		repository.save(conta);
	}


}
