package br.com.senacrs.alp.aulas;

public class Nodo<Tipo extends Object> {

	private Tipo valor;
	private Nodo<Tipo> proximo = null;
	private Nodo<Tipo> anterior = null;

	public Nodo(Tipo valor) {

		this.valor = valor;
	}

	public Tipo getValor() {
		return valor;
	}

	public void setValor(Tipo valor) {
		this.valor = valor;
	}

	public Nodo<Tipo> getProximo() {
		return proximo;
	}

	public void setProximo(Nodo<Tipo> proximo) {
		this.proximo = proximo;
	}
	
	public Nodo<Tipo> getAnterior() {
		return anterior;
	}

	public void setAnterior(Nodo<Tipo> anterior) {
		this.anterior = anterior;
	}

	@Override
	public String toString() {
		
		String resultado = null;
		
		resultado = "[" + this.valor + "]";
		if (this.proximo != null) {
			resultado += "->";
		}
		
		return resultado;
	}

}