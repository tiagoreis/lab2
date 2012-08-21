package br.com.senac.alp.aulas.MinhaLista;

public class Nodo<Tipo extends Object> {
	
	private Tipo valor;
	private Nodo <Tipo> proximo = null;
	
	//---------------------------------------------
	public Tipo getValor(){
		//return this.valor;
		return valor;
		
	}
	
	//---------------------------------------------
	public void setValor(Tipo valor) {
		this.valor = valor;
	}
	
	//---------------------------------------------
	public Nodo<Tipo> getProximo() {
		return proximo;
	}
	
	//---------------------------------------------
	public void setProximo(Nodo <Tipo> left){
		proximo = left;
	}
	
	//---------------------------------------------
	public Nodo(Tipo valor2){
		this.valor = valor2;
	}
	//---------------------------------------------

}
