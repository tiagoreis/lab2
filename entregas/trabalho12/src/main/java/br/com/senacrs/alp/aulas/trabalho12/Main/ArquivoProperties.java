package br.com.senacrs.alp.aulas.trabalho12.Main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ArquivoProperties {

	File arquivo = null;
	Map<String, String> map = new HashMap<String, String>();
	String token = "=";
	String config_dir = null;
	Integer port = null;
	String keyRootDir = "root_dir";
	String keyPort = "port";

	public void lerArquivo(File arquivoAux) {

		arquivo = arquivoAux;

		if (!arquivo.exists()) {
			msgErro();
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

			// leitor do arquivo
			reader = new BufferedReader(new FileReader(arquivo));

			System.out.println(arquivo.getPath());
			// System.out.println(arquivo.getAbsolutePath());
			// System.out.println(arquivo.getAbsolutePath());
			// System.out.println(arquivo.getAbsolutePath());

			// verifica se o arquivo for vazio
			if (arquivo.length() == 0) {
				msgErro();
				throw new IllegalArgumentException();
			}

			try {
				// enquanto estiver lendo....
				while ((linhas = reader.readLine()) != null) {

					// procura token tem na linha
					stringToken = new StringTokenizer(linhas, token);
					// conta quantos token tem na linha (no caso procuro quantos
					// "=" tem na linha)
					contadorChave = stringToken.countTokens();

					// se nao tiver separador OU se tiver mais de um separador
					if (linhas.indexOf(token) == -1 || contadorChave > 2) {
						msgErro();
						throw new IllegalArgumentException();
					} else {

						// quebra a linha, dividindo entre chave e valor
						arrKeyValue = linhas.split(token);

						// tira os sacanas dos espaços
						key = arrKeyValue[0].trim();
						value = arrKeyValue[1].trim();

						// coloca no map
						map.put(key, value);

						validaDadosConfig();
						// formataDiretorio(map.get("root_dir"));
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

	private void validaDadosConfig() {

		validaPorta();

		Integer porta = null;
		config_dir = map.get(keyRootDir);
		porta = Integer.parseInt(map.get(keyPort));
		port = porta;

	}

	// verifica se eh somente numeros
	private void validaPorta() {

		try {
			// expressao regular que permite apenas numeros
			Pattern pattern = Pattern.compile("[0-9]");
			Matcher matcher = pattern.matcher(map.get(keyPort));

			// verifica se o pattern nao funcionou (nao tem somente numeros)
			if (matcher.matches() == false) {
				msgErro();
				throw new IllegalArgumentException();
			}

		} catch (Exception e) {
			// TODO: handle exception

		}

	}

	// saida proposta pelo gustavo
	private void msgErro() {
		System.out.println("Erro");

	}

	/*
	 * // saida proposta pelo gustavo (<porta>:<caminho absoluto final do
	 * arquivo>) private void saida() { // TODO Auto-generated method stub
	 * 
	 * System.out.println(port +":"+config_dir);
	 * 
	 * }
	 */
}
