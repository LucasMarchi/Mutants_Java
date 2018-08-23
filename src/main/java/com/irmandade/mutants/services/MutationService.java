package com.irmandade.mutants.services;

import org.springframework.stereotype.Service;

@Service
public class MutationService {
	
	public boolean isMutant(String[] dna) {
		
		int contador = 0;

        for (int i = 0; i < dna.length; i++) {
            
            int tamanhoSequencia = dna[i].length();
            
            for (int j = 0; j < tamanhoSequencia; j++) {
                
                if (i < tamanhoSequencia - 3) {

                    // Diagonal
                    if (j < tamanhoSequencia - 3) {
                    	contador += buscarNaDiagonal(dna, i, j);
                        if(contador > 1) return true;
                    }
                    
                    //diadonal reverse
                    if (j > 3) {
                    	contador += buscarNaDiagonalReverso(dna, i, j);
                        if(contador > 1) return true;
                    }

                    // Vertical
                    contador += buscarNaVertical(dna, i, j);
                    if(contador > 1) return true;
                }

                // Horizontal
                if (j < tamanhoSequencia - 3) {
                	contador += buscarNaHorizontal(dna, i, j);
                    if(contador > 1) return true;
                }
            }
        }
        return false;
    }

    private static int buscarNaDiagonal(String[] dna, int i, int j) {
        String d = "";
        char gen = dna[i].charAt(j);
        d += gen;
        d += dna[i + 1].charAt(j + 1);
        d += dna[i + 2].charAt(j + 2);
        d += dna[i + 3].charAt(j + 3);
        String replaced_string = d.replace(String.valueOf(gen), "");
        
        return replaced_string.length() == 0 ? 1 : 0;
    }
    
    private static int buscarNaDiagonalReverso(String[] dna, int i, int j) {
        String d = "";
        char gen = dna[i].charAt(j);
        d += gen;
        d += dna[i + 1].charAt(j - 1);
        d += dna[i + 2].charAt(j - 2);
        d += dna[i + 3].charAt(j - 3);
        String replaced_string = d.replace(String.valueOf(gen), "");

        return replaced_string.length() == 0 ? 1 : 0;
    }
    
    private static int buscarNaVertical(String[] dna, int i, int j) {
        String v = "";
        char gen = dna[i].charAt(j);
        v += gen;
        v += dna[i + 1].charAt(j);
        v += dna[i + 2].charAt(j);
        v += dna[i + 3].charAt(j);
        String replaced_string = v.replace(String.valueOf(gen), "");

        return replaced_string.length() == 0 ? 1 : 0;
    }
    
    private static int buscarNaHorizontal(String[] dna, int i, int j) {
        String h = "";
        char gen = dna[i].charAt(j);
        h += gen;
        h += dna[i].charAt(j + 1);
        h += dna[i].charAt(j + 2);
        h += dna[i].charAt(j + 3);
        String replaced_string = h.replace(String.valueOf(gen), "");

        return replaced_string.length() == 0 ? 1 : 0;
    }
}
