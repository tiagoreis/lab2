package br.com.senacrs.alp.aulas;

import static org.junit.Assert.*;
import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MinhaListaImpTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testMinhaListaImp() {
		// Object => pq a lista ta de forma generica
		MinhaListaImp<String> obj = null;
		String arg = null;

		arg = "valor valido";
		obj = new MinhaListaImp<String>(arg);
		// verifica se a condicao eh satisfeita, caso nao seja para o teste
		Assert.assertNotNull(obj);

	}


	@Test
	public void testSufixar() {

		MinhaListaImp<String> obj = null;
		String valor = null;
		String sufixo = null;

		obj = new MinhaListaImp<String>("inicio");
		valor = "valor";
		obj.sufixar(valor);
		// verificar se o sufixo eh o ultimo da lista
		sufixo = obterSufixo(obj);
		Assert.assertEquals(valor, sufixo);
	}

	private String obterSufixo(MinhaListaImp<String> obj) {
		String resultado = null;
		Nodo<String> nodo = null;

		nodo = obj.getInicio();
		while (nodo.getProximo() != null) {
			nodo = nodo.getProximo();
		}

		resultado = nodo.getValor();

		return resultado;
	}

	@Test
	public void testPrefixar() {
		
		MinhaListaImp<Object> obj = null;
		Object valor = null;
		Object prefixo = null;
		
		obj = new MinhaListaImp<Object>();

		valor = "prefixo";

		obj.prefixar(valor);
		prefixo = obterPrefixo(obj);

		Assert.assertEquals(valor, prefixo);

	}

	private Object obterPrefixo(MinhaListaImp<Object> objeto) {

		Object resultado = null;
		Nodo<Object> nodo = null;
		Nodo<Object> PrimeiroNodo = null;
		

		nodo = objeto.getInicio();
		PrimeiroNodo = nodo.getProximo();
		resultado = PrimeiroNodo.getValor();

		return resultado;

	}

	@Test
	public void testBuscar() {

		MinhaListaImp<Object> obj = null;
		String valor = null;
		Object resultado = null;
		Integer posicao = null;

		int tamanhoLista = 5;
		
		valor = "nodo 2";
		posicao = 2;

		obj = new MinhaListaImp<Object>(valor);
		gerarListaGenerica(obj, tamanhoLista);
		resultado = obj.buscar(posicao);

		Assert.assertEquals(valor, resultado);

	}

	@Test
	public void testInserir() {

		MinhaListaImp<String> obj = null;
		String valor = null;
		Integer posicao = null;

		valor = "valor";
		posicao = 0;

		obj = new MinhaListaImp<String>(valor);
		obj.inserir(posicao, valor);

	}

	@Test
	public void testRemover() {
		MinhaListaImp<Object> obj = null;
		String valor = null;
		Integer posicao = null;

		int tamanhoLista = 5;
		valor = "valor";
		posicao = 1;

		obj = new MinhaListaImp<Object>(valor);
		gerarListaGenerica(obj, tamanhoLista);

		obj.inserir(posicao, valor);
		obj.remover(posicao);

	}

	@Test
	public void testTamanho() {

		MinhaListaImp<Object> obj = null;

		int tamanho = 0;
		int tamanhoLista = 5;
		int resultado = 0;

		obj = new MinhaListaImp<Object>();

		gerarListaGenerica(obj, tamanhoLista);

		// valor da classe de implementacao
		resultado = obj.tamanho();
		// valor vindo da classe auxiliar
		tamanho = obterTamanho(obj);

		Assert.assertEquals(resultado, tamanho);

	}

	private void gerarListaGenerica(MinhaListaImp<Object> obj, int tamanhoLista) {
		Nodo<Object> nodo = null;
		nodo = obj.getInicio();
		Nodo<Object> novo = null;
		for (int i = 0; i < tamanhoLista; i++) {
			novo = new Nodo<Object>("nodo " + (i));
			nodo.setProximo(novo);
			nodo = novo;
		}
		
	}

	private Integer obterTamanho(MinhaListaImp<Object> obj) {

		Nodo<Object> nodo = null;
		int tamanho = 0;

		nodo = obj.getInicio();

		while (nodo.getProximo() != null) {
			nodo = nodo.getProximo();
			tamanho++;
		}

		return tamanho;
	}

}
