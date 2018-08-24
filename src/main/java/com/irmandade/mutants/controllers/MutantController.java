package com.irmandade.mutants.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.irmandade.mutants.models.Humano;
import com.irmandade.mutants.services.HumanoService;
import com.irmandade.mutants.services.MutationService;

import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/mutants")
public class MutantController {

	@Autowired
	private MutationService mutationService;

	@Autowired
	HumanoService humanoService;

	@CacheEvict(value = "stats", allEntries = true)
	@PostMapping
	@ApiResponses({
		@ApiResponse(code = 200, message = "Executado com sucesso"),
		@ApiResponse(code = 400, message = "Dados inputados não atendem as especificações"),
		@ApiResponse(code = 500, message = "Erro na aplicação")
	})
	public ResponseEntity<?> isMutant(@ApiParam(value = "cadeia de dna") @RequestBody String[] dna) throws Exception {
		try {
			boolean mutation = mutationService.isMutant(dna);
			humanoService.save(new Humano(mutation, dna));
			return ResponseEntity.ok(mutation);

		} catch (ArrayIndexOutOfBoundsException e) {
			return ResponseEntity.badRequest().body("O dna inputado deve seguir a regra N x N");
			
		} catch (Exception e) {
			return ResponseEntity
					.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Desculpe estamos com problemas, para maiores informações entre em contato com o time de especialistas da irmandade");
		}
	}

}
