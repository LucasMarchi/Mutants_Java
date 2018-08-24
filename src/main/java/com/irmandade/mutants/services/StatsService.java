package com.irmandade.mutants.services;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.irmandade.mutants.HumanoRepository;
import com.irmandade.mutants.models.Humano;
import com.irmandade.mutants.models.Stats;

@Service
public class StatsService {
	
	@Autowired
	private HumanoRepository humanoService;
	
	public Stats getStatus() {
		List<Humano> humanos = humanoService.findAll();
		Long count_human_dna = (long) humanos.size();
		Long count_mutant_dna = humanos.stream().filter(humano -> humano.isMutation()).count();
		BigDecimal ratio = BigDecimal.ZERO;
		if(count_mutant_dna != 0) {
			ratio = new BigDecimal(count_mutant_dna.doubleValue() / count_human_dna.doubleValue()).setScale(2, RoundingMode.HALF_UP);
		}
		return new Stats(count_mutant_dna, count_human_dna, ratio);
	}
}
