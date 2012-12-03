package br.com.senacrs.alp.aulas.trabalho13;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
			
			Arrays.sort(dir); 
			Arrays.sort(arq); 
			
			Object[] teste = conteudoDiretorioUnificado(dir, arq);
			
			for (int i = 0; i < teste.length; i++) {
				resultado[i + 2] = teste[i].toString();
				//System.out.println(teste[i]);
			}
			
		} else {
			resultado = new String[2];
			resultado[0] = "list: " + fileDiretorio ;
			resultado[1] = "total: " + listFile.length;
		}

		return resultado;
	}

	private Object[] conteudoDiretorioUnificado(String[] dir, String[] arq) {
		// TODO Auto-generated method stub
		   String[] array1 = dir;

           String[] array2 = arq;

           List<String> list1 = new ArrayList<String>( Arrays.asList(array1) );

           List<String> list2 = new ArrayList<String>( Arrays.asList(array2) );

           list1.addAll(list2);

           
           
           return list1.toArray(); 
		
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
