package br.com.senacrs.alp.aulas;

import static org.junit.Assert.*;
import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MinhaListaImpTest {

	// @Before => anotacao
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
		//verifica se a condicao eh satisfeita, caso nao seja para o teste
		Assert.assertNotNull(obj);
		
	}

	@Test
	public void testMinhaListaImpNull() {
		
		MinhaListaImp<String> obj = null;
		
		try {
			obj = new MinhaListaImp<String>(null);
			fail("falhou");
		} catch (IllegalArgumentException e) {
			//a excessao tem de ser a mesma excessao do retorno
			
			Assert.assertTrue(true);
		}
		
		// espera q o objeto seja nulo
		//Assert.assertNull(obj);
	
	}
	
	@Test
	public void testSufixar() {
		
		MinhaListaImp<String> obj = null;
		String valor = null;
		String sufixo = null;
		
		
		obj = new MinhaListaImp<String>("inicio");
		valor = "valor";
		obj.sufixar(valor);
		//verificar se o sufixo eh o ultimo da lista
		sufixo = obterSufixo(obj);
		Assert.assertEquals(valor, sufixo);
		
		//fail("Not yet implemented");
	}

	private String obterSufixo(MinhaListaImp<String> obj) {
		String resultado = null;
		Nodo<String> nodo = null;
		
		nodo = obj.getInicio();
		while(nodo.getProximo() != null){
			nodo = nodo.getProximo();
		}
		
		resultado = nodo.getValor();
		
		return resultado;
	}

	@Test
	public void testPrefixar() {
		
		Nodo<String> nodo = null;
		MinhaListaImp<String> obj = null;
		String valor = null;
		String prefixo = null;
		
		obj = new MinhaListaImp<String>("inicio");
		valor = "prefixo";
		
		obj.prefixar(valor);
		nodo = obj.getInicio();
		prefixo = nodo.getValor();

		Assert.assertEquals(valor, prefixo);
		
	}

	@Test
	public void testBuscar() {

		MinhaListaImp<String> obj = null;
		String valor = null;
		String resultado = null;
		Integer posicao = null;
		
		valor = "valor";
		posicao = 0;
		
		obj = new MinhaListaImp<String>(valor );
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
		
		obj = new MinhaListaImp<String>(valor );
		obj.inserir(posicao, valor);
		
	}

	@Test
	public void testRemover() {
		MinhaListaImp<String> obj = null;
		String valor = null;
		Integer posicao = null;
		
		valor = "valor";
		posicao = 1;
		
		obj = new MinhaListaImp<String>(valor );
		
		obj.inserir(posicao, valor);
		obj.remover(posicao);
		
	}

	@Test
	public void testTamanho() {

		MinhaListaImp<String> obj = null;

		int tamanho = 0;
		int resultado = 0;
		
		obj = new MinhaListaImp<String>("inicio");

		// valor da classe de implementacao
		resultado = obj.tamanho();
		// valor vindo da classe auxiliar
		tamanho = obterTamanho(obj);
		
		Assert.assertEquals(resultado, tamanho);
		
	}
	
	private Integer obterTamanho(MinhaListaImp<String> obj) {
		
		Nodo<String> nodo = null;
		int tamanho = 1;
		
		nodo = obj.getInicio();
		
		while(nodo.getProximo() != null){
			nodo = nodo.getProximo();
			tamanho++;
		}

		return tamanho;
	}
	

}
