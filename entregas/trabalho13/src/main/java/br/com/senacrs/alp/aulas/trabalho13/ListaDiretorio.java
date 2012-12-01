package br.com.senacrs.alp.aulas.trabalho13;

import java.io.File;
import java.lang.reflect.Array;
import java.util.Arrays;

public class ListaDiretorio {

	public String[] listaConteudoDiretorio(String diretorio) {
		
		String[] resultado = null;
		String[] dir = null;
		String[] arq = null;
		
		String newLine = System.getProperty("line.separator");
		String name = null;
		
		int numeroArquivos= 0;
		int numeroDiretorios=0;
		int contador=0;
		int cont = 0;
		
		if(diretorio == null){
			throw new IllegalArgumentException();
		}

		
		File fileDiretorio = new File(diretorio);
		
		if(!fileDiretorio.isDirectory()){
			throw new IllegalArgumentException();
		}

		File[] listFile = fileDiretorio.listFiles();

		if(listFile.length > 0){

			contador = listFile.length ;
			numeroArquivos = contadorArquivos(listFile);
			numeroDiretorios = contadorDiretorios(listFile);
			
			dir = montarArrayDiretorio(listFile, numeroDiretorios);
			arq = montarArrayArquivos(listFile, numeroArquivos);
			
			resultado = new String[listFile.length + 2];
			resultado[0] = "list: " + fileDiretorio ;
			resultado[1] = "total: " + listFile.length;
			
			
			
		} else {
			resultado = new String[2];
			resultado[0] = "list: " + fileDiretorio ;
			resultado[1] = "total: " + listFile.length;
			

		}

		Arrays.sort(dir); 
		Arrays.sort(arq); 
		
		return resultado;
	}

	private String[] montarArrayArquivos(File[] listFile, int numeroArquivos) {
		
		String [] arquivos = null;
		arquivos = new String[numeroArquivos];
				
		int cont = 0;
		for (int i = 0; i < listFile.length; i++) {

			if(listFile[i].isFile()){
				
				arquivos[cont] = "a " + listFile[i].getName();
				cont++;
			} 
		}

		return arquivos;
	}

	private String[] montarArrayDiretorio(File[] listFile, int numeroDiretorios) {
		String []diretorio = null;
		diretorio = new String[numeroDiretorios];
				
		int cont = 0;
		for (int i = 0; i < listFile.length; i++) {

			if(listFile[i].isDirectory()){
				
				diretorio[cont] = "d " + listFile[i].getName();
				cont++;
			} 
		}

		
		return diretorio;
	}

	private int contadorDiretorios(File[] listFile) {
		int cont = 0;
		for (int i = 0; i < listFile.length; i++) {

			if(listFile[i].isDirectory()){
				cont++;
			} 
		}
		
		return cont;
		
	}

	private int contadorArquivos(File[] listFile) {
		int cont = 0;

		for (int i = 0; i < listFile.length; i++) {
			if(listFile[i].isFile()){
				cont++;
			} 
		}
		
		return cont;
	}
}
