package br.com.senacrs.alp.aulas.trabalho5;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class EmpresaImp implements Empresa{

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

	private FuncionarioImp cast(Funcionario funcionario){
		
		return (FuncionarioImp) funcionario;
	}
	
}
