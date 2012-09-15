package br.com.senacrs.alp.aulas.trabalho5;


public class FuncionarioFactoryImpl implements FuncionarioFactory {
	
	static FuncionarioFactoryImpl instancia = new FuncionarioFactoryImpl();
	
	public static void main(String[] args) {
		FuncionarioFactoryImpl obj = null;
		obj = FuncionarioFactoryImpl.getInstancia();
	}
	

	public static FuncionarioFactoryImpl getInstancia(){
		/*
		if ( instancia == null){
			instancia = new FuncionarioFactoryImpl();
		}
		*/
		return FuncionarioFactoryImpl.instancia;
	}

	@Override
	public Funcionario criaFuncionario(String nome, int salario) {
		
		if(nome == null || nome.equalsIgnoreCase("") || salario < 0){
			throw new IllegalArgumentException(); 
		}
		
		//FuncionarioImp func = null;
		FuncionarioImp func = new FuncionarioImp(nome, salario);
		
		//System.out.println("func " + func);
		
		return func;
	}
	
	private FuncionarioFactoryImpl() {

		super();
	}

}

