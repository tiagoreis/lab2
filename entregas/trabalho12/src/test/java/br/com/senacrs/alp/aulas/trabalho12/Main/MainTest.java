package br.com.senacrs.alp.aulas.trabalho12.Main;

import java.io.File;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.internal.runners.statements.Fail;

import br.com.senacrs.alp.aulas.trabalho12.Main.Main;
import static org.junit.Assert.fail;

public class MainTest {
	
	// definicoes de acesso a configuracao
	private final static String NOME_ARQUIVO_CONFIG 		= "config.properties";
	private final static String NOME_ARQUIVO_CONFIG_VAZIO 	= "config_vazio.properties";
	private final static String NOME_ARQUIVO_CONFIG_INVALIDO= "config_invalido.properties";
	private final static String NOME_ARQUIVO_CONFIG_PORTA_INVALIDA = "config_porta_invalida.properties";
	
	private final static String NOME_ARQUIVO_REQUISICAO 		= "requisicao.properties";
	//private final static String NOME_ARQUIVO_HTTP 		= null;
	private static final String NOME_ARQUIVO_REQUISICAO_ERROR = "requisicaoError.properties";
	

	
	@SuppressWarnings("static-access")
	@Test
	public void testArgumento(){
		
		Main main = new Main();
		String[] args = {NOME_ARQUIVO_CONFIG, NOME_ARQUIVO_REQUISICAO};
		
		try {
			main.main(args);
		} catch (IllegalArgumentException e) {
			Assert.assertTrue(true);
		}
		
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void testArgumentoNull(){
		
		Main main = new Main();
		
		try {
			main.main(null);
			fail();
		} catch (IllegalArgumentException e) {
			Assert.assertTrue(true);
		}
		
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void testArquivoVazio(){
		
		Main main = new Main();
		String[] args = {NOME_ARQUIVO_CONFIG_VAZIO};
		
		try {
			main.main(args);
			fail();
		} catch (IllegalArgumentException e) {
			Assert.assertTrue(true);
		}
		
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void testArquivoInvalido(){
		
		Main main = new Main();
		String[] args = {NOME_ARQUIVO_CONFIG_INVALIDO};
		
		try {
			main.main(args);
			fail();
		} catch (IllegalArgumentException e) {
			Assert.assertTrue(true);
		}
		
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void testArquivoInexistente(){
		
		Main main = new Main();
		String[] args = {NOME_ARQUIVO_CONFIG_INVALIDO + ".nao_existe"};
		
		try {
			main.main(args);
			fail();
		} catch (IllegalArgumentException e) {
			Assert.assertTrue(true);
		}
		
	}
	
	
	@SuppressWarnings("static-access")
	@Test
	public void testPortaComLetras(){
		
		Main main = new Main();
		String[] args = {NOME_ARQUIVO_CONFIG_PORTA_INVALIDA};
		
		try {
			main.main(args);
			fail();
		} catch (IllegalArgumentException e) {
			Assert.assertTrue(true);
		}
		
	}
		
	@SuppressWarnings("static-access")
	@Test
	public void testFormataDiretorio(){
		
		Main main = new Main();
		String[] args = {NOME_ARQUIVO_CONFIG_INVALIDO + ".nao_existe"};
		try {
			main.main(args);
			fail();
		} catch (IllegalArgumentException e) {
			Assert.assertTrue(true);
		}
		
	}


	@Test
	public void testRequisicaoErro(){
		
		Main main = new Main();
		String[] args = {NOME_ARQUIVO_CONFIG, NOME_ARQUIVO_REQUISICAO_ERROR};
		
		try {
			main.main(args);
			fail();
		} catch (IllegalArgumentException e) {
			Assert.assertTrue(true);
		}
		
	}


}
