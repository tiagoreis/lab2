package br.com.senacrs.alp.aulas.trabalho12.Main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class MyServer {

	BufferedReader entrada;
	BufferedWriter saida;

	private final String DIRETORIO_ATUAL = System.getProperty("user.dir");
	private final String DIRETORIO_ABSOLUTO = "./";

	File arquivo = null;

	Map<String, String> map = new HashMap<String, String>();
	String token = "=";
	String keyRootDir = "root_dir";
	String keyPort = "port";

	private String config_dir = null;
	private Integer port = null;

	public void testaArgumento(String[] args) {

		String msg = "msg ";
		String argumento = null;

		// se for nulo
		if (args == null) {
			throw new IllegalArgumentException();
		}

		// se o tamanho for diferente de 1
		if (args.length != 1) {
			throw new IllegalArgumentException();
		}

		// argumento = Arrays.toString(args);
		argumento = args[0];

		arquivo = new File(argumento);

		if (arquivo.isDirectory() || !arquivo.exists()) {
			throw new IllegalArgumentException();
		}

		lerArquivo();
		validaDadosConfig();

	}

	private void validaDadosConfig() {

		Integer porta = null;
		
		/*config_dir = map.get(keyRootDir);
		porta = Integer.parseInt(map.get(keyPort));
		port = porta;
		
		System.out.println(port+":"+config_dir);
*/
		
	}

	public void lerArquivo() {

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

							// System.out.println(linhas);

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

	private String formataDiretorio(String argumento) {
		String diretorio = null;

		// System.out.println(DIRETORIO_ABSOLUTO + argumento);

		return diretorio;
	}

	private void imprimir(String msg) {
		System.out.println(msg);

	}

	public String formatarMensagem(String chave, Object... argumentos) {

		if (map.get(chave) == null) {
			throw new IllegalArgumentException();
		}

		String chaveMap = null;
		String textoFormatado = null;

		chaveMap = map.get(chave);
		textoFormatado = chaveMap.format(chaveMap, argumentos);

		System.out.println(chaveMap);
		System.out.println(textoFormatado);

		return textoFormatado.trim();

	}

}
