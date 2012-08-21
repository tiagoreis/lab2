package br.com.senac.alp.aulas.MinhaLista;

public class MinhaListaImp<Tipo> implements MinhaLista<Tipo> {

	private Nodo<Tipo> inicio = null;

	//iniciando um construtor pra comecar com valor valido
	public MinhaListaImp (Tipo valorInicial){
		this.inicio = new Nodo<Tipo>(valorInicial);
	}
	
	public void sufixar(Tipo valor) {

		// Nodo<Tipo> ultimo = ultimoElemento();
		Nodo<Tipo> ultimo = buscarUltimoNodo();
		// encapsulando valor da caixa
		Nodo<Tipo> novoUltimo = new Nodo<Tipo>(valor);
		ultimo.setProximo(novoUltimo);

	}

	private Nodo<Tipo> buscarUltimoNodo() {

		int tamanho = tamanho();
		Nodo<Tipo> resultado = buscarNodo(tamanho - 1);

		return resultado;
	}

	
	public void prefixar(Tipo valor) {
		Nodo<Tipo> primeiro = buscarPrimeiroNodo();
		Nodo<Tipo> novoPrimeiro = new Nodo(valor);
		novoPrimeiro.setProximo(primeiro);
		setInicio(novoPrimeiro);

	}

	private Nodo<Tipo> buscarPrimeiroNodo() {

		return this.inicio;

	}

	public Tipo buscar(int posicao) {
		// busca caixa
		Nodo<Tipo> nodo = buscarNodo(posicao);
		// retorna valor da caixa
		return nodo.getValor();

	}

	public void inserir(int posicao, Tipo valor) {
		// lista
		// inicial E -> A -> B -> C
		// final E -> A -> D -> B -> C
		// apenas pegar os valores
		// pega posicao anterior (pega o A)
		Nodo<Tipo> anterior = buscarNodo(posicao - 1);
		// pegar o nodo que vem apos o anterior (B)
		Nodo<Tipo> proximo = anterior.getProximo();
		// pega o nodo que sera colocado (D)
		Nodo<Tipo> nodo = new Nodo(valor);
		// liga A -> D
		anterior.setProximo(nodo);
		// liga D -> B
		nodo.setProximo(proximo);

	}

	public Tipo remover(int posicao) {
		// lista
		// inicial D -> A -> B -> C
		// final D -> A -> C
		Nodo<Tipo> anterior = buscarNodo(posicao - 1);
		Nodo<Tipo> nodo = anterior.getProximo();
		Nodo<Tipo> proximo = nodo.getProximo();
		anterior.setProximo(proximo);
		return nodo.getValor();

	}

	public int tamanho() {

		Nodo<Tipo> nodo = getInicio();
		int resultado = 1;

		while (nodo.getProximo() != null) {
			nodo.getProximo();
			resultado++;
		}

		return resultado;
	}

	private Nodo<Tipo> getInicio() {

		return inicio;
	}

	private Nodo<Tipo> buscarNodo(int posicao) {

		Nodo<Tipo> resultado = getInicio();

		for (int i = 0; i < posicao; i++) {
			resultado = resultado.getProximo();
		}
		return resultado;

	}

	private void setInicio(Nodo<Tipo> inicio) {
		this.inicio = inicio;
	}

	private Nodo primeiroElemento() {
		return getInicio();
	}


}
