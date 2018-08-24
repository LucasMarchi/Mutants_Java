package com.irmandade.mutants.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Humano {

	public Humano(boolean mutation, String[] dna) {
		this.mutation = mutation;
		this.dna = dna;
	}

	@Id
	@GeneratedValue
	private Long id;
	private boolean mutation;
	private String[] dna;

}