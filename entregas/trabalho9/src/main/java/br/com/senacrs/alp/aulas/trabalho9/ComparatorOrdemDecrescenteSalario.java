package br.com.senacrs.alp.aulas.trabalho9;

import java.util.Comparator;

public class ComparatorOrdemDecrescenteSalario implements Comparator<Funcionario> {

	@Override
	public int compare(Funcionario o1, Funcionario o2) {
		int resultado = 0;
		
		if(o1.getSalario() < o2.getSalario()){
			resultado = 1;
		} else if (o1.getSalario() > o2.getSalario()){
			resultado = -1;
		}
		
		return resultado; 
			
	}

	
}
