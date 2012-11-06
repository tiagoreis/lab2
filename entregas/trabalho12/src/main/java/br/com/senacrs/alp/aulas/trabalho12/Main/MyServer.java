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

	File arquivo = null;
	String token = "=";

	BufferedReader entrada;
	BufferedWriter saida;
	Map<String, String> map = new HashMap<String, String>();


	
	public void getDiretorio(String nomeArquivo){
		
		if (nomeArquivo == null) {
			throw new IllegalArgumentException();
		}

		arquivo = new File(nomeArquivo);

		if (arquivo.isDirectory() || !arquivo.exists()) {
			throw new IllegalArgumentException();
		}

		//validaArquivo();
	}
	
	
	public void validaArquivo() {

		if (!arquivo.exists()) {
			throw new IllegalArgumentException();
		}

		String linhas = null;
		String key = null;
		String value = null;
		int contadorChave = 0;
		StringTokenizer stringToken = null;

		BufferedReader reader = null;

		String [] arrKeyValue = null;
		
		try {

			reader = new BufferedReader(new FileReader(arquivo));

			try {
				while ((linhas = reader.readLine()) != null) {
	
					// System.out.println(linhas);

					stringToken = new StringTokenizer(linhas, token);
					contadorChave = stringToken.countTokens();

					// se nao tiver separador
					if (linhas.indexOf(token) == -1) {

						throw new IllegalArgumentException();
					} else {

						System.out.println(linhas);

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
							//System.out.println("----------------------------------");

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


}
