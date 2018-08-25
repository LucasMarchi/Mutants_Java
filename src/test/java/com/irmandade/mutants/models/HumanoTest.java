package com.irmandade.mutants.models;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class HumanoTest {
	
	@Test
	public void deveRetornarToString() {
		assertNotNull(new Humano().toString());
	}
	
	@Test
	public void deveRetornarHashCode() {
		assertNotNull(new Humano().hashCode());
	}

}
