package com.irmandade.mutants.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.irmandade.mutants.services.StatsService;

import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/stats")
public class StatsController {
	
	@Autowired
	private StatsService statusService;
	
	@GetMapping
	@Cacheable("stats")
	@ApiResponses({
		@ApiResponse(code = 200, message = "Executado com sucesso"),
		@ApiResponse(code = 500, message = "Erro na aplicação")
	})
	public ResponseEntity<?> getStatus() {
		try {
			return ResponseEntity.ok(statusService.getStatus());
		} catch (Exception e) {
			return ResponseEntity
					.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Desculpe estamos com problemas, para maiores informações entre em contato com o time de especialistas da irmandade");
		}
	}

}
