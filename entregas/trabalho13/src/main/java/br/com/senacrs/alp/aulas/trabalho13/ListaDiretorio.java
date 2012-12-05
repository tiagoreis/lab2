package br.com.senacrs.alp.aulas.trabalho13;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListaDiretorio {

	public String[] listaConteudoDiretorio(String diretorio) {

		validaDiretorio(diretorio);

		String[] resultado = null;

		resultado = ordenaConteudoDiretorio(diretorio);

		return resultado;
	}

	private String[] ordenaConteudoDiretorio(String diretorio) {

		File fileDiretorio = new File(diretorio);
		File[] listFile = fileDiretorio.listFiles();

		String[] resultado = null;
		String[] arrayDiretorios = null;
		String[] arrayArquivos = null;

		int numeroArquivos = 0;
		int numeroDiretorios = 0;

		resultado = new String[listFile.length + 2];
		resultado[0] = "list: " + fileDiretorio;
		resultado[1] = "total: " + listFile.length;

		if (listFile.length > 0) {

			numeroArquivos = contadorArquivos(listFile);
			numeroDiretorios = contadorDiretorios(listFile);

			arrayDiretorios = montarArrayDiretorio(listFile, numeroDiretorios);
			arrayArquivos = montarArrayArquivos(listFile, numeroArquivos);

			Arrays.sort(arrayDiretorios);
			Arrays.sort(arrayArquivos);

			Object[] teste = conteudoDiretorioUnificado(arrayDiretorios,
					arrayArquivos);

			for (int i = 0; i < teste.length; i++) {
				resultado[i + 2] = teste[i].toString();
				// System.out.println(teste[i]);
			}

		}

		return resultado;
	}

	private void validaDiretorio(String diretorio) {
		if (diretorio == null) {
			throw new IllegalArgumentException();
		}

		File fileDiretorio = new File(diretorio);

		if (!fileDiretorio.isDirectory()) {
			throw new IllegalArgumentException();
		}

	}

	private Object[] conteudoDiretorioUnificado(String[] arrayDiretorio,
			String[] arrayArquivo) {

		String[] array1 = null;
		String[] array2 = null;
		List<String> list1 = null;
		List<String> list2 = null;

		array1 = arrayDiretorio;
		array2 = arrayArquivo;
		list1 = new ArrayList<String>(Arrays.asList(array1));
		list2 = new ArrayList<String>(Arrays.asList(array2));

		list1.addAll(list2);

		return list1.toArray();
	}

	private String[] montarArrayArquivos(File[] listFile, int numeroArquivos) {

		String[] arquivos = null;
		arquivos = new String[numeroArquivos];

		int cont = 0;
		for (int i = 0; i < listFile.length; i++) {

			if (listFile[i].isFile()) {

				arquivos[cont] = "a " + listFile[i].getName();
				cont++;
			}
		}

		return arquivos;
	}

	private String[] montarArrayDiretorio(File[] listFile, int numeroDiretorios) {
		String[] diretorio = null;
		diretorio = new String[numeroDiretorios];

		int cont = 0;
		for (int i = 0; i < listFile.length; i++) {

			if (listFile[i].isDirectory()) {

				diretorio[cont] = "d " + listFile[i].getName();
				cont++;
			}
		}

		return diretorio;
	}

	private int contadorDiretorios(File[] listFile) {
		int cont = 0;
		for (int i = 0; i < listFile.length; i++) {

			if (listFile[i].isDirectory()) {
				cont++;
			}
		}

		return cont;

	}

	private int contadorArquivos(File[] listFile) {
		int cont = 0;

		for (int i = 0; i < listFile.length; i++) {
			if (listFile[i].isFile()) {
				cont++;
			}
		}

		return cont;
	}
}
