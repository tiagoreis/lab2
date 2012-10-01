package br.com.senacrs.alp.aulas;

public class MinhaListaReversivelImp<Tipo> implements
		MinhaListaReversivel<Tipo> {

	private Nodo<Tipo> inicio = null;

	public MinhaListaReversivelImp() {

		this.inicio = new Nodo<Tipo>(null);
	}

	protected Nodo<Tipo> getInicio() {
		return inicio;
	}
	
	@Override
	public void sufixar(Tipo valor) {

		Nodo<Tipo> ultimo = buscarUltimoNodo();
		Nodo<Tipo> novoUltimo = new Nodo<Tipo>(valor);

		ultimo.setProximo(novoUltimo);
		novoUltimo.setAnterior(ultimo);
	}

	private Nodo<Tipo> buscarUltimoNodo() {

		int tamanho = tamanho();
		Nodo<Tipo> resultado = buscarNodo(tamanho);

		return resultado;
	}

	private Nodo<Tipo> buscarNodo(int posicao) {

		Nodo<Tipo> resultado = getInicio();

		for (int i = 0; i < posicao; i++) {
			resultado = resultado.getProximo();
		}

		return resultado;
	}

	@Override
	public void prefixar(Tipo valor) {

		Nodo<Tipo> inicio = null;
		Nodo<Tipo> primeiro = null;
		Nodo<Tipo> novoPrimeiro = null;

		inicio = this.inicio;
		primeiro = inicio.getProximo();
		novoPrimeiro = new Nodo<Tipo>(valor);
		novoPrimeiro.setProximo(primeiro);
		inicio.setProximo(novoPrimeiro);
		novoPrimeiro.setAnterior(inicio);

		if (primeiro != null) {

			primeiro.setAnterior(novoPrimeiro);

		}

	}

	@Override
	public Tipo buscar(int posicao) {

		Nodo<Tipo> nodo = null;

		verificarPosicaoParaBuscar(posicao);
		nodo = buscarNodo(posicao + 1);

		return nodo.getValor();
	}

	private void verificarPosicaoParaBuscar(int posicao) {

		int posicaoMaxima = 0;

		posicaoMaxima = this.tamanho() - 1;
		verificarPosicao(posicao, posicaoMaxima);
	}

	private void verificarPosicao(int posicao, int posicaoMaxima) {

		boolean posicaoValida = false;

		posicaoValida = posicaoDentroDeLimitesValidos(posicao, posicaoMaxima);
		if (!posicaoValida) {
			throw new IndexOutOfBoundsException();
		}
	}

	private boolean posicaoDentroDeLimitesValidos(int posicao, int posicaoMaxima) {

		boolean resultado = false;

		resultado = (posicao >= 0) && (posicao <= posicaoMaxima);

		return resultado;
	}

	@Override
	public void inserir(int posicao, Tipo valor) {

		Nodo<Tipo> anterior = null;
		Nodo<Tipo> proximo = null;
		Nodo<Tipo> nodo = null;

		verificarPosicaoParaInserir(posicao);
		anterior = buscarNodo(posicao);
		proximo = anterior.getProximo();
		nodo = new Nodo<Tipo>(valor);
		anterior.setProximo(nodo);
		nodo.setProximo(proximo);
		nodo.setAnterior(anterior);

		if (proximo != null) {

			proximo.setAnterior(nodo);

		}
	}

	private void verificarPosicaoParaInserir(int posicao) {

		int posicaoMaxima = 0;

		posicaoMaxima = this.tamanho();
		verificarPosicao(posicao, posicaoMaxima);
	}

	@Override
	public Tipo remover(int posicao) {

		Nodo<Tipo> anterior = null;
		Nodo<Tipo> nodo = null;
		Nodo<Tipo> proximo = null;

		verificarPosicaoParaBuscar(posicao);
		anterior = buscarNodo(posicao);
		nodo = anterior.getProximo();
		proximo = nodo.getProximo();
		anterior.setProximo(proximo);

		if (proximo != null) {

			proximo.setAnterior(anterior);

		}

		return nodo.getValor();
	}

	@Override
	public int tamanho() {

		Nodo<Tipo> nodo = getInicio();
		int resultado = 0;

		while (nodo.getProximo() != null) {
			nodo = nodo.getProximo();
			resultado++;
		}

		return resultado;
	}

	@Override
	public void reverter() {
		
		Nodo<Tipo> fim = buscarUltimoNodo();
		Nodo<Tipo> nodo = fim;
		Nodo<Tipo> aux = null;
		Nodo<Tipo> auxTmp = null;
		
		if (fim.getAnterior() != null) {

			while (nodo.getAnterior() != null){
				nodo.setProximo(nodo.getAnterior());
				auxTmp = nodo.getAnterior();
				nodo.setAnterior(aux);
				aux = nodo;
				nodo = auxTmp;
			}
			inicio.setProximo(fim);
			fim.setAnterior(inicio);
			aux.setProximo(null);
			
		}
	}

	@Override
	public String toString() {

		String resultado = null;
		Nodo<Tipo> nodo = null;

		resultado = this.getClass().getSimpleName() + ":";
		nodo = this.inicio;
		while (nodo.getProximo() != null) {
			nodo = nodo.getProximo();
			resultado += nodo;
		}

		return resultado;
	}

}