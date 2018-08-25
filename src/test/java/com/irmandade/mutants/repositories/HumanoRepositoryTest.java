package com.irmandade.mutants.repositories;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.irmandade.mutants.models.Humano;

@RunWith(SpringRunner.class)
@DataJpaTest
public class HumanoRepositoryTest {
	
	@Autowired
    private TestEntityManager entityManager;
 
    @Autowired
    private HumanoRepository humanoRepository;
    
    @Test
    public void deveEncontrarPorDNA() {
    	String[] dna = {"AAAA", "TTTT", "CCCC", "GGGG"};
    	entityManager.persist(new Humano(true, dna));
    	Optional<Humano> optionalHumano = humanoRepository.findByDna(dna);
    	assertTrue(optionalHumano.isPresent());
    	assertThat(optionalHumano.get().getDna()).isEqualTo(dna);
    }

}
