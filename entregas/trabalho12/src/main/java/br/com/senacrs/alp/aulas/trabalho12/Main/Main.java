package br.com.senacrs.alp.aulas.trabalho12.Main;

import java.awt.image.ReplicateScaleFilter;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.security.auth.login.Configuration;

public class Main {

	private final static String DIRETORIO_ATUAL = System
			.getProperty("user.dir");
	private final static String DIRETORIO_ABSOLUTO = "./";

	static File arquivo = null;

	static Map<String, String> map = new HashMap<String, String>();
	static String token = "=";
	static String keyRootDir = "root_dir";
	static String keyPort = "port";

	private static String config_dir = null;
	private static Integer port = null;

	public static void main(String[] args) {

		testaArgumento(args);
		lerArquivo();
		validaDadosConfig();

		saida();
	}

	private static void saida() {
		// TODO Auto-generated method stub
		
	}

	private static void validaDadosConfig() {

		validaPorta();
		
		Integer porta = null;
		config_dir = map.get(keyRootDir);
		porta = Integer.parseInt(map.get(keyPort));
		port = porta;

	}

    // verifica se eh somente numeros
	private static void validaPorta() {

		try {
			Pattern pattern = Pattern.compile("[0-9]");
	        Matcher matcher = pattern.matcher(map.get(keyPort));
	        
	        if(matcher.matches() == false){
				throw new IllegalArgumentException();
	        }
	        
		} catch (Exception e) {
			// TODO: handle exception
			
		}
		
		
	}

	public static void testaArgumento(String[] args) {

		String argumento = null;

		// se for nulo
		if (args == null) {
			throw new IllegalArgumentException();
		}

		// se o tiver mais de um argumento
		if (args.length != 1) {
			throw new IllegalArgumentException();
		}

		// argumento = Arrays.toString(args);
		argumento = args[0];

		arquivo = new File(argumento);

		if (arquivo.isDirectory() || !arquivo.exists()) {
			throw new IllegalArgumentException();
		}

	}

	public static void lerArquivo() {

		if (!arquivo.exists()) {
			throw new IllegalArgumentException();
		}

		String linhas = null;
		String key = null;
		String value = null;
		int contadorChave = 0;
		StringTokenizer stringToken = null;

		BufferedReader reader = null;

		String[] arrKeyValue = null;

		try {

			reader = new BufferedReader(new FileReader(arquivo));

			// se o arquivo for vazio
			if (arquivo.length() == 0) {
				throw new IllegalArgumentException();
			}

			try {
				while ((linhas = reader.readLine()) != null) {

					stringToken = new StringTokenizer(linhas, token);
					contadorChave = stringToken.countTokens();

					// se nao tiver separador
					if (linhas.indexOf(token) == -1) {
						throw new IllegalArgumentException();
					} else {

						// se tiver mais de um separador
						if (contadorChave > 2) {
							throw new IllegalArgumentException();
						} else {

							//System.out.println(linhas);

							arrKeyValue = linhas.split(token);

							// tira os sacanas dos espaços
							key = arrKeyValue[0].trim();
							value = arrKeyValue[1].trim();

							map.put(key, value);

							formataDiretorio(map.get("root_dir"));
							// System.out.println(map.get("root_dir"));
						}
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	private static String formataDiretorio(String argumento) {
		String diretorio = null;

		// System.out.println(DIRETORIO_ABSOLUTO + argumento);

		return diretorio;
	}

	@SuppressWarnings("static-access")
	public String formatarMensagem(String chave, Object... argumentos) {

		if (map.get(chave) == null) {
			throw new IllegalArgumentException();
		}

		String chaveMap = null;
		String textoFormatado = null;

		chaveMap = map.get(chave);
		textoFormatado = chaveMap.format(chaveMap, argumentos);


		return textoFormatado.trim();

	}

}
