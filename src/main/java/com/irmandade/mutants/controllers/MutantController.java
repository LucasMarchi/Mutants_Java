package com.irmandade.mutants.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.irmandade.mutants.HumanoRepository;
import com.irmandade.mutants.models.Humano;
import com.irmandade.mutants.services.MutationService;

@RestController
@RequestMapping("/mutants")
public class MutantController {

	@Autowired
	private MutationService mutationService;
	
	@Autowired
	HumanoRepository humanoRepository;
	
	@PostMapping
	public boolean isMutant(@RequestBody String[] dna) {
		boolean mutation = mutationService.isMutant(dna);
		humanoRepository.save(new Humano(mutation, dna));
		return mutation;
	}
	
	@GetMapping
	public String teste() {
		return "oi";
	}
}
