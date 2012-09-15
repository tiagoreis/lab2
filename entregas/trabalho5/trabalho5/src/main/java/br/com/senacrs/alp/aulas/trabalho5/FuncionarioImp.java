package br.com.senacrs.alp.aulas.trabalho5;

public class FuncionarioImp implements Funcionario{ 

	private String nome = null;
	private int salario = 0;
	
	public FuncionarioImp(String nome , int salario){
		
		this.nome = nome;
		this.salario = salario;
		
	}
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getSalario() {
		return salario;
	}
	public void setSalario(int salario) {
		this.salario = salario;
	}
	
	
	
}
