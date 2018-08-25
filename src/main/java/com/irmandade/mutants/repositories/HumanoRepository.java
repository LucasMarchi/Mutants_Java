package com.irmandade.mutants.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.irmandade.mutants.models.Humano;

@Repository
public interface HumanoRepository extends JpaRepository<Humano, Long> {
	
	Optional<Humano> findByDna(String[] dna);
	
}
