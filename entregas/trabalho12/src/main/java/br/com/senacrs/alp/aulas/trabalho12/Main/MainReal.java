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

public class MainReal {

	private String DIRETORIO_CONFIG = null;
	private String DIRETORIO_HTML = null;
	private String CAMINHO_RELATIVO = null;
	private String USER_DIR = null;

	Map<String, String> map = new HashMap<String, String>();

	String root_dir = null;
	String caminhoCompletoIndex = null;
	String token = "=";
	int port = 0;
	String keyPort = "port";
	String keyRootDir = "root_dir";
	String mensagem = null;
	String protocolo = null;

	public void start(String[] args) {

		this.DIRETORIO_CONFIG = System.getProperty("user.dir")
				+ File.separatorChar + "config" + File.separatorChar;
		this.DIRETORIO_HTML = System.getProperty("user.dir")
				+ File.separatorChar + "html" + File.separatorChar;
		this.USER_DIR = System.getProperty("user.dir");
		this.CAMINHO_RELATIVO = System.getProperty("root.dir");

		String nomeArquivoConfig = null;
		String nomeArquivoRequisicao = null;

		validaArgumento(args);

		nomeArquivoConfig = args[0];
		nomeArquivoRequisicao = args[1];

		try {
			lerArquivoConfig(nomeArquivoConfig);
			lerArquivoRequisicao(nomeArquivoRequisicao);

		} catch (Exception e) {
			throw new IllegalArgumentException(e);
		}

	}

	public void lerArquivoConfig(String nomeArquivoConfig) {

		File arquivoConfig = null;
		arquivoConfig = new File(DIRETORIO_CONFIG + nomeArquivoConfig);

		if (arquivoConfig.isDirectory() || !arquivoConfig.exists()
				|| arquivoConfig.length() == 0) {
			throw new IllegalArgumentException();
		}

		BufferedReader reader = null;
		StringTokenizer stringToken = null;
		int contadorToken = 0;
		String[] arrayLinha = null;

		String linhas = null;
		String key = null;
		String value = null;

		try {

			reader = new BufferedReader(new FileReader(arquivoConfig));

			try {

				while ((linhas = reader.readLine()) != null) {

					stringToken = new StringTokenizer(linhas, token);
					contadorToken = stringToken.countTokens();

					if (linhas.indexOf(token) == -1 || contadorToken > 2) {
						throw new IllegalArgumentException();
					} else {

						arrayLinha = linhas.split(token);
						key = arrayLinha[0].trim();
						value = arrayLinha[1].trim();

						map.put(key, value);
					}
				}

				validaDadosConfig(map);

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

	public void validaArgumento(String[] args) {

		if (args == null || args.length != 2 || args[0] == null
				|| args[1] == null) {
			throw new IllegalArgumentException();
		}

	}

	public void validaDadosConfig(Map<String, String> map) {

		validaPorta(map);
		validaRootDir(map);
	}

	private void validaRootDir(Map<String, String> map) {

		String root = map.get(keyRootDir);
		root = root.replace(".", System.getProperty("user.dir"));
		root = ajustaSeparador(root);
		root_dir = root;

	}

	public void validaPorta(Map<String, String> map) {

		try {

			Pattern pattern = Pattern.compile("[0-9]");
			Matcher matcher = pattern.matcher(map.get(keyPort));

			if (matcher.matches() == true) {
				throw new IllegalArgumentException();
			} else {
				port = Integer.parseInt(map.get(keyPort));
			}

		} catch (Exception e) {
			throw new IllegalArgumentException(e);

		}

	}

	public void lerArquivoRequisicao(String nomeArquivoRequisicao) {

		File arquivoRequisicao = null;
		arquivoRequisicao = new File(DIRETORIO_CONFIG + nomeArquivoRequisicao);

		if (arquivoRequisicao.isDirectory() || !arquivoRequisicao.exists()
				|| arquivoRequisicao.length() == 0) {
			throw new IllegalArgumentException();
		}

		BufferedReader reader = null;
		String linhaHost = null;
		String linhaGet = null;
		String caminho = null;

		File arquivoIndex = null;
		File file = null;

		boolean arquivoIndexExiste = false;

		try {

			reader = new BufferedReader(new FileReader(arquivoRequisicao));

			try {

				linhaGet = reader.readLine();
				linhaHost = reader.readLine();

				caminho = lerCaminhoRequisicao(linhaGet);
				caminho = ajustaSeparador(caminho);
				caminho = USER_DIR + caminho;
				arquivoIndex = new File(caminho);

				if (arquivoIndex.isFile()) {
					throw new IllegalArgumentException();
				}

				if (arquivoIndex.isDirectory()) {

					file = new File(arquivoIndex, "index.html");

					arquivoIndexExiste = file.exists();

					if (arquivoIndexExiste) {
						caminhoCompletoIndex = file.toString();

					} else {
						throw new IllegalArgumentException();
					}
				}

				validaHost(linhaHost);

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

	private void validaHost(String linhaHost) {

		String[] elementos = null;
		String espaco = " ";

		if (!linhaHost.startsWith("Host: ")) {
			throw new IllegalArgumentException();
		}

		elementos = linhaHost.split(espaco);

		if (elementos.length != 2 || !elementos[0].equalsIgnoreCase("Host:")) {
			throw new IllegalArgumentException();
		}

	}

	private String lerCaminhoRequisicao(String linhaGet) {

		String[] elementos = null;
		String espaco = " ";
		elementos = linhaGet.split(espaco);
		String caminho = null;

		if (elementos.length != 3 || !elementos[0].equalsIgnoreCase("GET")
				|| !elementos[1].startsWith("/")
				|| !elementos[2].equalsIgnoreCase("HTTP/1.1")) {

			throw new IllegalArgumentException();

		} else {
			protocolo = elementos[2];
			caminho = elementos[1];

		}

		return caminho;
	}

	private String ajustaSeparador(String caminho) {
		String barra = "/";

		while (caminho.contains(barra)) {
			caminho = caminho.replace(barra, File.separator);
		}

		return caminho;
	}

	public String retorno() {
		String retorno = null;
		// Parte: A
		// retorno = port +":" + DIRETORIO_CONFIG ;

		// Parte: B
		// retorno = root_dir;

		// Parte: C
		retorno = "200 OK " + caminhoCompletoIndex;

		return retorno;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

}
