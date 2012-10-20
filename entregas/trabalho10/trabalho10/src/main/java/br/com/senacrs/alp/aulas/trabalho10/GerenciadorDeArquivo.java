package br.com.senacrs.alp.aulas.trabalho10;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.LinkedList;

public class GerenciadorDeArquivo {

	public File arquivo = null;
	
	public GerenciadorDeArquivo(String nomeArquivo) {
		

		if(nomeArquivo == null){
			throw new IllegalArgumentException();
		}

		arquivo = new File(nomeArquivo);
		
		if(arquivo.isDirectory()){
			throw new IllegalArgumentException();
		}
		
	}

	public String[] lerArquivo() throws IllegalArgumentException {

		
		LinkedList<String> linhasLista = new LinkedList<String>();
		String linhas = new String();
		String [] texto = null;
		
		BufferedReader reader = null;
		FileReader file = null;
		
		if(!arquivo.exists()){
			throw new IllegalArgumentException();
		}
		
		try{
		
			file = new FileReader(arquivo);
			reader = new BufferedReader(file);
			
			linhas = reader.readLine();
			
			while(linhas!= null){
				linhasLista.add(linhas);
				linhas = reader.readLine();
			}
		}catch(Exception ex){
			return null;
		}
		
		texto = new String[linhasLista.size()];
		
		for(int i = 0 ; i < linhasLista.size(); i++){
			texto[i] = linhasLista.get(i);
		}
		
		
		return texto;
		
	}

	public String[] lerArquivoComSubstituicao(String lido, String retornado) {

		String[] textoLido = lerArquivo();
		
		for(int i = 0 ; i < textoLido.length;i++){
			textoLido[i] = textoLido[i].replace(lido, retornado);
		}

		return textoLido;
	}

	public void escreverArquivo(String[] conteudo) {

		String texto = null;
		BufferedWriter writer = null;
		FileWriter file = null;
		
		
		try{
			file = new FileWriter(arquivo);
			writer = new BufferedWriter(file);
					
			for(int i = 0 ; i< conteudo.length; i++){
				System.out.println(conteudo[i].toString());
				texto = conteudo[i];
				writer.write(texto);
				writer.newLine();
				writer.flush();
			}		
		
		}catch (Exception ex){
			
		}
		
	}
}