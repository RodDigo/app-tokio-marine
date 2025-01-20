package com.tokio.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.tokio.domain.Transferencia;
import com.tokio.service.TransferenciaService;

@RestController
@RequestMapping("/api/transferencia")
@CrossOrigin("*")
public class TransferenciaController {

	@Autowired
	private TransferenciaService service;
	
	@PostMapping("/create")
	@ResponseStatus(HttpStatus.CREATED)
	public String create(@RequestBody Transferencia dto) {
		if(dto.getDtAgendamento() == null) {
			dto.setDtAgendamento(new Date());
		}
		return service.create(dto);
	}
	
	@GetMapping("/getAll")
	public List<Transferencia> findAll() {
		return service.findAll();
	}
	
	
}
