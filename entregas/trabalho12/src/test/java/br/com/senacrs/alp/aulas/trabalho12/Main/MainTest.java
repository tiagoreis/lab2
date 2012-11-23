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

	private final static String NOME_ARQUIVO_SAIDA = "saida.txt";
	private final static String NOME_ARQUIVO_DIRETORIO_SAIDA = "./txt1/txt2/saida2.txt";
	private final static String NOME_ARQUIVO_DIRETORIO_SAIDA_INVALIDO = "/txt1/txt2/saida2.txt";
	
	private final static String NOME_ARQUIVO_INDEX_INVALIDO = "";
	
	/*

	<saida> (wiki)
HTTP/1.1 200 OK
Date: Mon, 23 May 2005 22:38:34 GMT
Server: Apache/1.3.27 (Unix)  (Red-Hat/Linux)
Last-Modified: Wed, 08 Jan 2003 23:11:55 GMT
Etag: "3f80f-1b6-3e1cb03b"
Accept-Ranges: bytes
Content-Length: 438
Connection: close
Content-Type: text/html; charset=UTF-8
(terminar com uma linha vazia)
<conteudo>

String resultado = null;
data = null;
data = new Date();
DateFormat format = null;

format = DateFormat.getDateInstance();
format.setTimeZone(TimeZone.getTimeZone("GMT"));
resultado = format.format(data);


/meuHtml.html:
oi mundo web = tam.12bytes

req:
GET /meuHtml.html http/1.1
Host: localhost

saida (parte D):
-------------------------------------------------
|HTTP/1.1 200 OK
|Date: Mon, 23 May 2005 22:38:34 GMT
|Server: Apache/1.3.27 (Unix)  (Red-Hat/Linux)
|Content-Length: 12
|Content-Type: text/html; charset=UTF-8
|Connection: close
|
|oi mundo web
-------------------------------------------------

-------------------------------------------------
|HTTP/1.1 404 NotFound
|Date: Mon, 23 May 2005 22:38:34 GMT
|Server: Apache/1.3.27 (Unix)  (Red-Hat/Linux)
|Content-Length: 0
|Content-Type: text/html; charset=UTF-8
|Connection: close
|
-------------------------------------------------


	*/

	
	@SuppressWarnings("static-access")
	@Test
	public void testArgumento(){
		
		Main main = new Main();
		String[] args = {NOME_ARQUIVO_CONFIG, NOME_ARQUIVO_REQUISICAO, NOME_ARQUIVO_SAIDA};
		
		try {
			main.main(args);
		} catch (IllegalArgumentException e) {
			Assert.assertTrue(true);
			fail("Não é pra abortar");

		}
		
	}
	
	@SuppressWarnings("static-access")
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
	
	@SuppressWarnings("static-access")
	@Test
	public void testArquivoVazio(){
		
		Main main = new Main();
		String[] args = {NOME_ARQUIVO_CONFIG_VAZIO};
		
		try {
			main.main(args);
			fail("ERRO");
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
			fail("ERRO");
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
			fail("ERRO");
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
			fail("ERRO");
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
			fail("ERRO");
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
			fail("ERRO");
		} catch (IllegalArgumentException e) {
			Assert.assertTrue(true);
		}
		
	}

	@Test
	public void testArquivoDiretorioSaidaInvalido(){
		
		Main main = new Main();
		String[] args = {NOME_ARQUIVO_CONFIG, NOME_ARQUIVO_REQUISICAO, NOME_ARQUIVO_DIRETORIO_SAIDA_INVALIDO};
		
		try {
			main.main(args);
			fail("ERRO");
			
		} catch (IllegalArgumentException e) {
			Assert.assertTrue(true);
		}
		
	}

	@Test
	public void testSaidaIndexInvalido(){
		
		Main main = new Main();
		String[] args = {NOME_ARQUIVO_CONFIG, NOME_ARQUIVO_REQUISICAO, NOME_ARQUIVO_DIRETORIO_SAIDA_INVALIDO};
		
		try {
			main.main(args);
			fail("ERRO");
			
		} catch (IllegalArgumentException e) {
			Assert.assertTrue(true);
		}
		
	}

}
