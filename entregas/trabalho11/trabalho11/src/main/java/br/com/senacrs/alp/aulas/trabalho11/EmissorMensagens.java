package br.com.senacrs.alp.aulas.trabalho11;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.StringTokenizer;


public class EmissorMensagens {

	File arquivo = null;

	
	private Map<String, String> map = new HashMap<String, String>();
	
	public EmissorMensagens(String nomeArquivo) {

		BufferedReader reader = null;
		FileReader file = null;
		String linhas = null;
		int contadorChave = 0;
		StringTokenizer stringToken = null;
		String token = "=";
		LinkedList<String> linhasLista = new LinkedList<String>();
		String [] arrayChaveValor = null;
		
		if (nomeArquivo == null) {
			throw new IllegalArgumentException();
		}

		arquivo = new File(nomeArquivo);

		if (arquivo.isDirectory()) {
			throw new IllegalArgumentException();
		}

		if (!arquivo.exists()) {
			throw new IllegalArgumentException();
		}

		
		
		try {
			
			file = new FileReader(arquivo);
			reader = new BufferedReader(file);
			linhas = reader.readLine() ;
			
			
			while(linhas != null){
				
				contadorChave = 0;
				
				System.out.println("*****"+linhas+"*****");
				
				
				if(linhas.indexOf(token, 1) == -1){
					System.out.println("nao tem token " + linhas);
					throw new IllegalArgumentException("nao tem token");
				}
				
				
				
				stringToken = new StringTokenizer(linhas, token);
				contadorChave = stringToken.countTokens();
				
				if(contadorChave != 2 ){
					//System.out.println("cont "+contadorChave);
					throw new IllegalArgumentException("erro no token");
				}
				
				

				
				//arrayChaveValor  = linhas.split(token);
				//System.out.println("arr " + arrayChaveValor[0]);
				//System.out.println("arr " + arrayChaveValor[1]);
				//map.put(key, value)
				
				
				//linhasLista.add(linhas);
				
				linhas = reader.readLine();
			
			}
			
		} catch (Exception e) {
			//e.printStackTrace();
			
		}

		//System.out.println(nomeArquivo);

	}

	public String formatarMensagem(String chave, Object... argumentos) {

		if (argumentos.length == 0) {
			throw new IllegalArgumentException();
		}

		if (chave == null) {
			throw new IllegalArgumentException();
		}

		//System.out.println(chave);
		
		return null;
	}
	
		
	
}
