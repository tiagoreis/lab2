package br.com.senacrs.alp.aulas.trabalho12.Main;

import java.io.File;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.internal.runners.statements.Fail;

import br.com.senacrs.alp.aulas.trabalho12.Main.Main;
import static org.junit.Assert.fail;

public class MainTest {
	
	private final static String DIRETORIO_ENTRADA = System
			.getProperty("user.dir")
			+ File.separatorChar
			+ "root_html"
			+ File.separatorChar;

	private final static String NOME_ARQUIVO_HTML = "index.html";


	private final static String ROOT_DIR = DIRETORIO_ENTRADA
			+ NOME_ARQUIVO_HTML;


	private  String NOME_DIRETORIO_HTML = "root_html";
	private final static String NOME_DIRETORIO_CONFIG = "root_config";
	
	private final static String NOME_ARQUIVO = "index.html";

/*	private final static String ROOT_HTML = DIRETORIO_ENTRADA
			+ NOME_ARQUIVO;
*/

	
	@Test
	public void testArgumento(){
		Main main = new Main();
		String[] args = {"a","b"};
		
		try {
			main.main(args);
			Assert.assertTrue(true);
		} catch (IllegalArgumentException e) {
			fail("ERRO");
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
	public void testDiretorioNull(){
		Main main = new Main();
		String[] args = {NOME_DIRETORIO_CONFIG};
		try {
			main.main(args);
			fail("ERRO");
		} catch (IllegalArgumentException e) {
			Assert.assertTrue(true);
		}
		
	}
	
	


}
