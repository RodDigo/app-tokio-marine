package com.tokio.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/tokio")
@CrossOrigin("*")
public class TesteController {
	
	@Value("${version}")
	private String version;
	
	@GetMapping()
	public String hello() {
		return "Hello Tokio version: " + version;
	}

}
