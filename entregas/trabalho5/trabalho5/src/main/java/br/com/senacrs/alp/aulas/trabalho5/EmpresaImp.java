package br.com.senacrs.alp.aulas.trabalho5;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import junit.framework.Assert;

import org.hamcrest.core.IsEqual;

import br.com.senacrs.alp.aulas.MinhaLista;
import br.com.senacrs.alp.aulas.MinhaListaImp;
import br.com.senacrs.alp.aulas.Nodo;

public class EmpresaImp implements Empresa{

	
	@Override
	public void adicionaFuncionario(Funcionario funcionario) {
		
		MinhaLista<Funcionario> lista = null;
		
		System.out.println("emp imp "+funcionario);
		
		if(funcionario == null){
			throw new IllegalArgumentException();  
			
		} else {
			
			
			lista.sufixar(funcionario);
			
			System.out.println("add");
			
		}
		
	}

	@Override
	public Funcionario buscaFuncionario(String nome) {
		/*
		MinhaLista<Object> lista = null;
		Funcionario funcionario = null;
		Object teste = null;
		
		
		teste = lista.buscar(0);
		
		//System.out.println("busca");
		*/
		return null;
	}

	@Override
	public int totalFolhaPgto() {
		// TODO Auto-generated method stub
		return 0;
	}

	
	
	private FuncionarioImp cast(Funcionario funcionario){
		
		return (FuncionarioImp) funcionario;
	}
	
}
