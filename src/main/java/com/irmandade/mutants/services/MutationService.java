package com.irmandade.mutants.services;

import org.springframework.stereotype.Service;

import com.irmandade.mutants.helpers.ImplementacoesSearchersHelper;
import com.irmandade.mutants.searchers.ISearcher;

@Service
public class MutationService {
	
	public boolean isMutant(String[] dna) {
		int contador = 0;
        for (int i = 0; i < dna.length; i++) {
            for (int j = 0; j < dna[i].length(); j++) {
            	for (ISearcher implementacao : ImplementacoesSearchersHelper.getImplementacoes()) {
            		contador += implementacao.buscar(dna, i, j);
                    if(contador > 1) return true;
				}
            }
        }
        return false;
    }
}
