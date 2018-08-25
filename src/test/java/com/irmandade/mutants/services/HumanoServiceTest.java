package com.irmandade.mutants.services;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.irmandade.mutants.models.Humano;
import com.irmandade.mutants.repositories.HumanoRepository;

@RunWith(MockitoJUnitRunner.class)
public class HumanoServiceTest {
	
	@InjectMocks
	HumanoService humanoService;
	
	@Mock
	HumanoRepository humanoRepository;	
	
	@Test
	public void deveSalvarHUmano() {
		humanoService.save(new Humano());
	}
	
	@Test
	public void deveRetornarListaDeHumanos() {
		when(humanoRepository.findAll()).thenReturn(new ArrayList<>());
		assertNotNull(humanoService.findAll());
	}
	
}

