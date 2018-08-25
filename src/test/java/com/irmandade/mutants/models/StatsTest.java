package com.irmandade.mutants.models;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class StatsTest {
	
	@Test
	public void deveRetornarToString() {
		assertNotNull(new Stats().toString());
	}
	
	@Test
	public void deveRetornarHashCode() {
		assertNotNull(new Stats().hashCode());
	}

}
