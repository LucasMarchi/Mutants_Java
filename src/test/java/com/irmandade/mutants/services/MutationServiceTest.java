package com.irmandade.mutants.services;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import com.irmandade.mutants.services.MutationService;

@RunWith(MockitoJUnitRunner.class)
public class MutationServiceTest {
	
	@InjectMocks
	MutationService mutationService;

	@Test
	public void deveRetornarNaoMutant() {
		boolean esperado = false;
		String[] dna = {
						"ACTGAG", 
						"CAATGT", 
						"ACTGAG", 
						"CATAGT", 
						"ACTGAG", 
						"CAAAGT"
						};
		boolean retornado = mutationService.isMutant(dna);
		assertEquals(esperado, retornado);
	}
	
	@Test
	public void deveRetornarNaoMutantParaApenasUmsegmentoMutado() {
		boolean esperado = false;
		String[] dna = {
						"AAAATT", 
						"CAATGT", 
						"ACTGAG", 
						"CATAGT", 
						"ACTGAG", 
						"CAAAGT"
						};
		boolean retornado = mutationService.isMutant(dna);
		assertEquals(esperado, retornado);
	}
	
	@Test
	public void deveRetornarMutantParaSeuenciaDnaEmLinhaHorizontal() {
		boolean esperado = true;
		String[] dna = {"AAAATT", "TTTTAA", "AAAATT", "TTTTAA", "AAAATT", "TTTTAA",};
		boolean retornado = mutationService.isMutant(dna);
		assertEquals(esperado, retornado);
	}
	
	@Test
	public void deveRetornarMutantParaSeuenciaDnaEmLinhaVertical() {
		boolean esperado = true;
		String[] dna = {
						"ACCTGG", 
						"ACTCAG",
						"ACTCAC",
						"ACTGGA"
						};
		boolean retornado = mutationService.isMutant(dna);
		assertEquals(esperado, retornado);
	}
	
	@Test
	public void deveRetornarMutantParaSeuenciaDnaEmDiagonal() {
		boolean esperado = true;
		String[] dna = {
						"ACCTGG", 
						"AATCAG",
						"ACACAC",
						"ACTAGA"
						};
		boolean retornado = mutationService.isMutant(dna);
		assertEquals(esperado, retornado);
	}
	
	@Test
	public void deveRetornarMutantParaSeuenciaDnaEmDiagonalReverse() {
		boolean esperado = true;
		String[] dna = {
						"GCCCAT", 
						"CCCATC", 
						"GCATCC",
						"GATCCG",
						"CATCCC",
						"CATCGG",
						};
		boolean retornado = mutationService.isMutant(dna);
		assertEquals(esperado, retornado);
	}
	
	@Test(expected = ArrayIndexOutOfBoundsException.class)
	public void deveRetornarExceptionQuandoDnaNaoObedecerNxN() {
		String[] dna = {"GCCCAT"};
		mutationService.isMutant(dna);
	}
	
}

