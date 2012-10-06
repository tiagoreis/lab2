package br.com.senacrs.alp.aulas.trabalho9;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import br.com.senacrs.alp.aulas.trabalho9.Funcionario;

public class EmpresaImpl implements Empresa {

	private Map<String, Funcionario> mapFunc = new HashMap<String, Funcionario>();

	@Override
	public void adicionaFuncionario(Funcionario funcionario) {
		if(funcionario == null){
			throw new IllegalArgumentException();  
			
		} else {
			mapFunc.put(funcionario.getNome(), funcionario);
		}
		
	}

	@Override
	public Funcionario buscaFuncionario(String nome) {
		Funcionario result = null;
		
		Funcionario resultNome = mapFunc.get(nome);
		
		if(resultNome != null){
			result = resultNome;
		}

		return result;
	
	}

	@Override
	public int totalFolhaPgto() {

		int resultado = 0;

		for(Funcionario f : mapFunc.values()){
			
			resultado += f.getSalario();
		}
		
		return resultado;
		
	}

	@Override
	public List<Funcionario> ordemCrescenteSalario() {
		
		ComparatorOrdemCrescenteFuncionario comparator = null;
		Collection<Funcionario> coFuncionarios =  null;
		
		coFuncionarios =  mapFunc.values();
		comparator = new ComparatorOrdemCrescenteFuncionario();
		
		LinkedList<Funcionario> linkedFuncionario = new LinkedList<Funcionario>(coFuncionarios);
		
		Collections.sort(linkedFuncionario, comparator);
		
		return linkedFuncionario ;
	}

	@Override
	public List<Funcionario> ordemDecrescenteSalario() {
		ComparatorOrdemDecrescenteSalario comparator = null;
		Collection<Funcionario> coFuncionarios =  null;
		
		coFuncionarios =  mapFunc.values();
		comparator = new ComparatorOrdemDecrescenteSalario();
		
		LinkedList<Funcionario> linkedFuncionario = new LinkedList<Funcionario>(coFuncionarios);
		
		Collections.sort(linkedFuncionario, comparator);
		
		return linkedFuncionario ;
	}

	@Override
	public List<Funcionario> ordemAlfabetica() {
		ComparatorOrdemAlfabetica comparator = null;
		Collection<Funcionario> coFuncionarios =  null;
		
		coFuncionarios =  mapFunc.values();
		comparator = new ComparatorOrdemAlfabetica();
		
		LinkedList<Funcionario> linkedFuncionario = new LinkedList<Funcionario>(coFuncionarios);
		
		Collections.sort(linkedFuncionario, comparator);
		
		return linkedFuncionario ;
	}

}
