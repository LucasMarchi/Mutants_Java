package com.irmandade.mutants.models;

import java.math.BigDecimal;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Stats {

	private Long count_mutant_dna;
	private Long count_human_dna;
	private BigDecimal ratio;

	public Stats(Long count_mutant_dna, Long count_human_dna, BigDecimal ratio) {
		this.count_mutant_dna = count_mutant_dna;
		this.count_human_dna = count_human_dna;
		this.ratio = ratio;
	}
	
}
