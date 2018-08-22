package com.irmandade.mutants.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/mutants")
public class MutantsController {
	
	@GetMapping
	public String get() {
		return "Iniciando..";
	}
}
