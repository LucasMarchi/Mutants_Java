package com.irmandade.mutants.searchers;

public class VerticalSeracher implements ISearcher {

	@Override
	public int buscar(String[] dna, int i, int j) {
		if (i < dna[i].length() - 3) {
		    String v = "";
		    char gen = dna[i].charAt(j);
		    v += gen;
		    v += dna[i + 1].charAt(j);
		    v += dna[i + 2].charAt(j);
		    v += dna[i + 3].charAt(j);
		    String replaced_string = v.replace(String.valueOf(gen), "");
		
		    return replaced_string.length() == 0 ? 1 : 0;
    	}
    	
    	return 0;
	}

}
