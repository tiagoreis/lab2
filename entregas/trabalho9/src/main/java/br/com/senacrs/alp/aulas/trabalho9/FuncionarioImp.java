package br.com.senacrs.alp.aulas.trabalho9;

public class FuncionarioImp implements Funcionario{ 

	private String nome = null;
	private Integer salario = 0;
	
	public FuncionarioImp(String nome , Integer salario){
		
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
	
	public void setSalario(Integer salario) {
		this.salario = salario;
	}
	
	
	
}
