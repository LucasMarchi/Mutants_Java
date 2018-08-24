package com.irmandade.mutants.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.irmandade.mutants.HumanoRepository;
import com.irmandade.mutants.models.Humano;

@Service
public class HumanoService {
	
	@Autowired
	HumanoRepository humanoRepository;
	
	public void save(Humano humano) {
		Optional<Humano> optionalHumano = humanoRepository.findByDna(humano.getDna());
		if(!optionalHumano.isPresent()) humanoRepository.save(humano);
	}
	
	public List<Humano> findAll() {
		return humanoRepository.findAll();
	}
}
