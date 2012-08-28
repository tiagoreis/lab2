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

	private String obterSufixo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Test
	public void testPrefixar() {
		fail("Not yet implemented");
	}

	@Test
	public void testBuscar() {
		fail("Not yet implemented");
	}

	@Test
	public void testInserir() {
		fail("Not yet implemented");
	}

	@Test
	public void testRemover() {
		fail("Not yet implemented");
	}

	@Test
	public void testTamanho() {
		fail("Not yet implemented");
	}

}
