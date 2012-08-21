package br.com.senac.alp.aulas.MinhaLista;


public interface MinhaLista <Tipo extends Object>{ //generic: template... aceita qualquer objeto

	void sufixar(Tipo valor);
	
	void prefixar(Tipo valor);
	
	Tipo buscar(int posicao);
	
	void inserir(int posicao, Tipo valor);
	
	Tipo remover(int posicao);
	
	int tamanho();
	
	
	
}
