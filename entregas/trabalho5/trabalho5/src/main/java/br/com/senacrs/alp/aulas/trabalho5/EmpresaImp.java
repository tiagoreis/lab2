package br.com.senacrs.alp.aulas.trabalho5;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import junit.framework.Assert;

import org.hamcrest.core.IsEqual;

import br.com.senacrs.alp.aulas.MinhaLista;
import br.com.senacrs.alp.aulas.MinhaListaImp;
import br.com.senacrs.alp.aulas.Nodo;
import br.com.senacrs.alp.aulas.MinhaLista;
import br.com.senacrs.alp.aulas.MinhaListaImp;
import br.com.senacrs.alp.aulas.MinhaLista;
import br.com.senacrs.alp.aulas.MinhaListaImp;

import br.com.senacrs.alp.aulas.MinhaLista;
import br.com.senacrs.alp.aulas.MinhaListaImp;

public class EmpresaImp implements Empresa{

	MinhaLista<Funcionario> lista = new MinhaListaImp<Funcionario>();
	
	@Override
	public void adicionaFuncionario(Funcionario funcionario) {
		
		MinhaLista<Funcionario> lista = null;
		
		//System.out.println("emp imp "+funcionario);
		
		if(funcionario == null){
			throw new IllegalArgumentException();  
			
		} else {
			
			
			//lista.sufixar(funcionario);
			lista.prefixar(funcionario);
			
			System.out.println("add");
			
		}
		
	}

	@Override
	public Funcionario buscaFuncionario(String nome) {
		Funcionario funcionario = null;
		FuncionarioImp funcionarioImp = null;
		Funcionario result = null;

		for (int i = 0; i < lista.tamanho(); i++) {

			funcionario = lista.buscar(i);
			funcionarioImp = cast(funcionario);

			if(nome == funcionarioImp.getNome()){
				result = funcionario;
				break;
			}

		}

		return result;
	
	}

	
	@Override
	public int totalFolhaPgto() {
		Funcionario funcionario = null;
		FuncionarioImp funcionarioImp = null;
		int resultado = 0;

		for (int i = 0; i < lista.tamanho(); i++) {

			funcionario = lista.buscar(i);
			funcionarioImp = cast(funcionario);

			resultado += funcionarioImp.getSalario();

		}

		return resultado;
		
	}

	
	
	private FuncionarioImp cast(Funcionario funcionario){
		
		return (FuncionarioImp) funcionario;
	}
	
}
