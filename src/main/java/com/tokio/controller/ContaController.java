package com.tokio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tokio.domain.Conta;
import com.tokio.service.ContaService;

@RestController
@RequestMapping("/api/conta")
@CrossOrigin("*")
public class ContaController {

	@Autowired
	private ContaService contaService;
	
	@GetMapping("/getAll")
	public List<Conta> findAll() {
		return contaService.findAll();
	}
	
	
}
