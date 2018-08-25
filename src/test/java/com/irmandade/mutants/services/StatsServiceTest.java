package com.irmandade.mutants.services;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.irmandade.mutants.services.HumanoService;
import com.irmandade.mutants.models.Humano;
import com.irmandade.mutants.models.Stats;
import com.irmandade.mutants.services.StatsService;

@RunWith(MockitoJUnitRunner.class)
public class StatsServiceTest {
	
	@InjectMocks
	StatsService statsService;
	
	@Mock
	HumanoService humanoService;

	@Test
	public void deveRetornarStatus() {
		
		Long count_mutant_dna_esperado = 1L;
		Long count_human_dna_esperado  = 2L;
		BigDecimal ratio_esperado      = new BigDecimal(0.5).setScale(2);
		
		List<Humano> listaHumanos = new ArrayList<>();
		listaHumanos.add(new Humano(true, null));
		listaHumanos.add(new Humano(false, null));
		
		when(humanoService.findAll()).thenReturn(listaHumanos);
		Stats stats = statsService.getStatus();
		
		assertEquals(count_mutant_dna_esperado, stats.getCount_mutant_dna());
		assertEquals(count_human_dna_esperado, stats.getCount_human_dna());
		assertEquals(ratio_esperado, stats.getRatio());
	}
	
}

