package br.com.senacrs.alp.aulas.trabalho12.Main;

import java.awt.image.ReplicateScaleFilter;
import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {


	File arquivo = null;
	
	Map<String, String> map = new HashMap<String, String>();

	public static void main(String[] args) {
			

		testaArgumento(args);
		
		//System.out.println(System.getProperty("user.dir"));
		//MyServer myServer = new MyServer();
		//myServer.getDiretorio(ROOT_HTML);
		//getDiretorio();
		//validaCaminhoArquivo(ROOT_DIR);
		
	}


	private static void testaArgumento(String[] args) {
		// TODO Auto-generated method stub
		if(args == null){
			throw new IllegalArgumentException();
		} else {
			
/*
			arquivo = new File(Arrays.toString(args));

			if (arquivo.isDirectory() || !arquivo.exists()) {
				throw new IllegalArgumentException();
			}

*/			
			//System.out.println(args);
			String msg = "msg ";
			msg += Arrays.toString(args);

			imprimir(msg);
			
		}
		
		
		
	}


	private static void imprimir(String msg) {
		System.out.println(msg);
		
	}


	private static void validaCaminhoArquivo(String rootDir) {
		// TODO Auto-generated method stub
		
		
		
	}


	private static String getDiretorio() {
		
		String arquivo = null;
		
		
		return arquivo;
		
	}

	
	private void getArquivo(String nomeArquivo){

		if (nomeArquivo == null) {
			throw new IllegalArgumentException();
		}

		arquivo = new File(nomeArquivo);

		if (arquivo.isDirectory() || !arquivo.exists()) {
			throw new IllegalArgumentException();
		}

		
	}

	
	
	
	
}
