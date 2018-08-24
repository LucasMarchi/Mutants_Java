package com.irmandade.mutants.searchers;

public class DiagonalReverseSearcher implements ISearcher {

	@Override
	public int buscar(String[] dna, int i, int j) {
		if (i < dna[i].length() - 3) {
	    	if (j > 3) {
		        String d = "";
		        char gen = dna[i].charAt(j);
		        d += gen;
		        d += dna[i + 1].charAt(j - 1);
		        d += dna[i + 2].charAt(j - 2);
		        d += dna[i + 3].charAt(j - 3);
		        String replaced_string = d.replace(String.valueOf(gen), "");
		
		        return replaced_string.length() == 0 ? 1 : 0;
	    	}
    	}
    	
    	return 0;
	}

}
