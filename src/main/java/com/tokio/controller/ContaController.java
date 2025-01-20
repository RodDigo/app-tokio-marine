package com.tokio.controller;

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

import com.tokio.domain.Conta;
import com.tokio.domain.ContaDto;
import com.tokio.service.ContaService;

@RestController
@RequestMapping("/api/conta")
@CrossOrigin("*")
public class ContaController extends AbstractController {

	@Autowired
	private ContaService service;
	
	@PostMapping("/create")
	@ResponseStatus(HttpStatus.CREATED)
	public void create(@RequestBody ContaDto dto) {
		service.create(convertToEntity(dto, Conta.class));
	}
	
	@GetMapping("/getAll")
	public List<ContaDto> findAll() {
		List<ContaDto>  dtos = converToDtos(ContaDto.class, service.findAll());
		return dtos;
	}
	
	
}
