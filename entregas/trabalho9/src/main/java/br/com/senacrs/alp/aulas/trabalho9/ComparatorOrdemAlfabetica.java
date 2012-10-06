package br.com.senacrs.alp.aulas.trabalho9;

import java.util.Comparator;

public class ComparatorOrdemAlfabetica implements Comparator<Funcionario> {

	@Override
	public int compare(Funcionario o1, Funcionario o2) {
		
		int resultado = 0;
		
		resultado = o1.getNome().compareTo(o2.getNome());
		
		return resultado; 
			
	}

}
