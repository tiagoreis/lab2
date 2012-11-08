package br.com.senacrs.alp.aulas.trabalho12.Main;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class Main {

	static Map<String, String> map = new HashMap<String, String>();
	static String keyRootDir = "root_dir";
	static String keyPort = "port";

	public static void main(String[] args) {

		validaArgumento(args);

	}

	public static void validaArgumento(String[] args) {

		ArquivoProperties arquivoProperties = null;
		String argumento = null;
		File arquivo = null;

		arquivoProperties = new ArquivoProperties();

		// se for nulo OU o tamanho for diferente de um (o gustavo disse que
		// passaria somente um argumento...)
		if (args == null || args.length != 1) {
			msgErro();
			throw new IllegalArgumentException();
		}

		// argumento = Arrays.toString(args);
		argumento = args[0];

		arquivo = new File(argumento);

		// verifica se eh um diretorio OU se o arquivo existe
		if (arquivo.isDirectory() || !arquivo.exists()) {
			msgErro();
			throw new IllegalArgumentException();
		}

		arquivoProperties.lerArquivo(arquivo);

	}

	// saida proposta pelo gustavo
	private static void msgErro() {
		System.out.println("Erro");

	}

}
