package br.com.senacrs.alp.aulas.trabalho9;

import br.com.senacrs.alp.aulas.trabalho9.FuncionarioFactoryImpl;
import br.com.senacrs.alp.aulas.trabalho9.FuncionarioImp;

public class FuncionarioFactoryImpl implements FuncionarioFactory {	

	static FuncionarioFactoryImpl instancia = new FuncionarioFactoryImpl();
	
	public static void main(String[] args) {
		FuncionarioFactoryImpl obj = null;
		obj = FuncionarioFactoryImpl.getInstancia();
	}

	public static FuncionarioFactoryImpl getInstancia(){
		return FuncionarioFactoryImpl.instancia;
	}


	@Override
	public Funcionario criaFuncionario(String nome, int salario) {
		if(nome == null || nome.equalsIgnoreCase("") || salario < 0){
			throw new IllegalArgumentException(); 
		}
		
		FuncionarioImp func = new FuncionarioImp(nome, salario);
		
		return func;
	}
	
	
}
