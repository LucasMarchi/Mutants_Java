package com.irmandade.mutants.helpers;

import java.util.ArrayList;
import java.util.List;

import com.irmandade.mutants.searchers.DiagonalReverseSearcher;
import com.irmandade.mutants.searchers.DiagonalSearcher;
import com.irmandade.mutants.searchers.HorizontalSeracher;
import com.irmandade.mutants.searchers.ISearcher;
import com.irmandade.mutants.searchers.VerticalSeracher;

public class ImplementacoesSearchersHelper {

	public static List<ISearcher> getImplementacoes(){
		List<ISearcher> implementacoes = new ArrayList<>();
		implementacoes.add(new DiagonalSearcher());
		implementacoes.add(new DiagonalReverseSearcher());
		implementacoes.add(new HorizontalSeracher());
		implementacoes.add(new VerticalSeracher());
		return implementacoes;
	}
}
