package br.com.senacrs.alp.aulas.trabalho12.Main;

import java.io.File;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.internal.runners.statements.Fail;

import br.com.senacrs.alp.aulas.trabalho12.Main.Main;
import static org.junit.Assert.fail;

public class MainTest {
	
	private final static String DIRETORIO_ATUAL = System.getProperty("user.dir");

	private final static String DIRETORIO_HTML = System
			.getProperty("user.dir")
			+ File.separatorChar
			+ "root_html"
			+ File.separatorChar;
	private  String NOME_DIRETORIO_HTML = "root_html";
	private final static String NOME_ARQUIVO_HTML = "index.html";
	private final static String DIRETORIO_HTML_COMPLETO = DIRETORIO_HTML + NOME_ARQUIVO_HTML;


	
	private final static String DIRETORIO_CONFIG = System
			.getProperty("user.dir")
			+ File.separatorChar
			+ "root_config"
			+ File.separatorChar;
	private final static String NOME_DIRETORIO_CONFIG 		= "root_config";
	private final static String NOME_ARQUIVO_CONFIG 		= "config.properties";
	private final static String NOME_ARQUIVO_CONFIG_VAZIO 	= "config_vazio.properties";
	private final static String NOME_ARQUIVO_CONFIG_INVALIDO= "config_invalido.properties";
	private final static String NOME_ARQUIVO_CONFIG_PORTA_INVALIDA = "config_porta_invalida.properties";
	

/*	private final static String ROOT_HTML = DIRETORIO_ENTRADA
			+ NOME_ARQUIVO;
*/

	
	@Test
	public void testArgumento(){
		Main main = new Main();
		String[] args = {NOME_ARQUIVO_CONFIG};
		
		try {
			main.main(args);
			//fail("ERRO");
		} catch (IllegalArgumentException e) {
			Assert.assertTrue(true);
		}
		
	}
	
	@Test
	public void testDoisArgumentos(){
		Main main = new Main();
		String[] args = {"arg1","arg2"};
		
		try {
			main.main(args);
			fail("ERRO");
		} catch (IllegalArgumentException e) {
			Assert.assertTrue(true);
		}
		
	}
	
	@Test
	public void testArgumentoNull(){
		Main main = new Main();
		
		try {
			main.main(null);
			fail("ERRO");
		} catch (IllegalArgumentException e) {
			Assert.assertTrue(true);
		}
		
	}
	
	@Test
	public void testArquivoNull(){
		Main main = new Main();
		String[] args = {NOME_ARQUIVO_CONFIG_VAZIO};
		try {
			main.main(args);
			fail("ERRO");
		} catch (IllegalArgumentException e) {
			Assert.assertTrue(true);
		}
		
	}
	
	@Test
	public void testArquivoInvalido(){
		Main main = new Main();
		String[] args = {NOME_ARQUIVO_CONFIG_INVALIDO};
		try {
			main.main(args);
			fail("ERRO");
		} catch (IllegalArgumentException e) {
			Assert.assertTrue(true);
		}
		
	}
	
	@Test
	public void testArquivoInexistente(){
		Main main = new Main();
		String[] args = {NOME_ARQUIVO_CONFIG_INVALIDO + ".nao_existe"};
		try {
			main.main(args);
			fail("ERRO");
		} catch (IllegalArgumentException e) {
			Assert.assertTrue(true);
		}
		
	}
	
	
	@Test
	public void testPortaComLetras(){
		Main main = new Main();
		String[] args = {NOME_ARQUIVO_CONFIG_PORTA_INVALIDA};
		try {
			main.main(args);
			fail("ERRO");
		} catch (IllegalArgumentException e) {
			Assert.assertTrue(true);
		}
		
	}
		
	//@Test
	public void testFormataDiretorio(){
		Main main = new Main();
		String[] args = {NOME_ARQUIVO_CONFIG_INVALIDO + ".nao_existe"};
		try {
			main.main(args);
			fail("ERRO");
		} catch (IllegalArgumentException e) {
			Assert.assertTrue(true);
		}
		
	}
		
	
	private enum ChavesEnum {
		
		root_dir("root_config"),
		port("80"),
		inexistente("mensagem_inexistente"),
		;
		
		private final String chave;
		
		private ChavesEnum(String chave) {
			
			this.chave = chave;
		}
		
		public String getChave() {
			
			return this.chave;
		}
		
		public static ChavesEnum valorDe(String valor) {
			
			ChavesEnum resultado = null;
			
			for (ChavesEnum c : ChavesEnum.values()) {
				if (c.getChave().equals(valor)) {
					resultado = c;
					break;
				}
			}
			
			return resultado;
		}
	}

}
