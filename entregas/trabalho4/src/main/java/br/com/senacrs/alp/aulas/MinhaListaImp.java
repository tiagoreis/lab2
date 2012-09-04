package br.com.senacrs.alp.aulas;

public class MinhaListaImp<Tipo> implements MinhaLista<Tipo> {
	
	private Nodo<Tipo> inicio = null;
	
	public  MinhaListaImp() {
		
		Tipo obj = (Tipo) new Object();
		this.inicio = new Nodo<Tipo>(obj);
		
	}
	
	public MinhaListaImp(Tipo valorInicio) {
		
		Tipo obj = (Tipo) new Object();
		this.inicio = new Nodo<Tipo>(null);
		
		//nao permita que o primeiro argumento seja nulo
		if (valorInicio == null){
			// seta excessao
			// padrao para problemas de argumento
			throw new IllegalArgumentException();
		} 

		//Tipo obj = (Tipo) new Object();
		//this.inicio = new Nodo<Tipo>(obj);
		
		this.inicio = new Nodo<Tipo>(valorInicio);
	}

	// protected: todos do pacote enxergam
	//public Nodo<Tipo> getInicio() {
	protected Nodo<Tipo> getInicio() {
		return inicio;
	}

	protected void setInicio(Nodo<Tipo> inicio) {
		this.inicio = inicio;
	}


	public void sufixar(Tipo valor) {

		Nodo<Tipo> ultimo = buscarUltimoNodo();
		Nodo<Tipo> novoUltimo = new Nodo<Tipo>(valor);
		
		ultimo.setProximo(novoUltimo);
	}


	private Nodo<Tipo> buscarUltimoNodo() {
		
		int tamanho = tamanho();
		Nodo<Tipo> resultado = buscarNodo(tamanho - 1);
		
		return resultado;
	}


	private Nodo<Tipo> buscarNodo(int posicao) {
		
		Nodo<Tipo> resultado = getInicio();
		//alteracao pra usar o fantasma
		//for (int i = 0; i < posicao; i++) {
		for (int i = -1; i < posicao; i++) {
				resultado = resultado.getProximo();
		}
				
		return resultado;
	}

	public void prefixar(Tipo valor) {
		
		// antigo sem fantasma
/*		
		Nodo<Tipo> primeiro = buscarPrimeiroNodo();
		Nodo<Tipo> novoPrimeiro = new Nodo<Tipo>(valor);
		novoPrimeiro.setProximo(primeiro);
		setInicio(novoPrimeiro);
*/				
		// novo com fantasma
		// carrega o nodo
		Nodo<Tipo> nodo = new Nodo<Tipo>(valor);
		Nodo inicio = getInicio();
		// esse valor eh nulo por causa do fantasma
		Nodo inicioReal = inicio.getProximo();
		
		// chama o elemento apos o fantasma
		nodo.setProximo(inicioReal);
		// coloca a seta pro proximo da lista
		inicio.setProximo(nodo);
		
	}

	private Nodo<Tipo> buscarPrimeiroNodo() {

		Nodo<Tipo> resultado = getInicio();
		
		return resultado;
	}


	public Tipo buscar(int posicao) {
		
		Nodo<Tipo> nodo = buscarNodo(posicao);
		
		return nodo.getValor();
	}

	public void inserir(int posicao, Tipo valor) {

		Nodo<Tipo> anterior = buscarNodo(posicao - 1);
		Nodo<Tipo> proximo = anterior.getProximo();
		Nodo<Tipo> nodo = new Nodo<Tipo>(valor);
		
		anterior.setProximo(nodo);
		nodo.setProximo(proximo);		
	}

	public Tipo remover(int posicao) {
		
		Nodo<Tipo> anterior = buscarNodo(posicao - 1);
		Nodo<Tipo> nodo = anterior.getProximo();
		Nodo<Tipo> proximo = nodo.getProximo();
		
		anterior.setProximo(proximo);
		
		return nodo.getValor();
	}

	public int tamanho() {
		
		Nodo<Tipo> nodo = getInicio();
		//int resultado = 1;
		// agora pode ter um nodo vazio (fantasma)
		int resultado = 0;

		while (nodo.getProximo() != null) {
			nodo = nodo.getProximo();
			resultado++;
		}
		
		return resultado;
		
	}

}
