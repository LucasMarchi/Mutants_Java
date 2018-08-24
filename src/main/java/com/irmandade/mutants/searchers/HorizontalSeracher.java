package com.irmandade.mutants.searchers;

public class HorizontalSeracher implements ISearcher {

	@Override
	public int buscar(String[] dna, int i, int j) {
		if (j < dna[i].length() - 3) {
	        String h = "";
	        char gen = dna[i].charAt(j);
	        h += gen;
	        h += dna[i].charAt(j + 1);
	        h += dna[i].charAt(j + 2);
	        h += dna[i].charAt(j + 3);
	        String replaced_string = h.replace(String.valueOf(gen), "");
	
	        return replaced_string.length() == 0 ? 1 : 0;
    	}
    	
    	return 0;
	}

}
