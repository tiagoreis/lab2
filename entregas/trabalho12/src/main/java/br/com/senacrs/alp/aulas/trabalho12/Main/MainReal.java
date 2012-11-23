package br.com.senacrs.alp.aulas.trabalho12.Main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainReal {

	private final String DIRETORIO_CONFIG = System.getProperty("user.dir")
			+ File.separatorChar + "config" + File.separatorChar;
	private final String DIRETORIO_HTML = System.getProperty("user.dir")
			+ File.separatorChar + "html" + File.separatorChar;
	private final String CAMINHO_RELATIVO = System.getProperty("root.dir");
	private final String USER_DIR = System.getProperty("user.dir");
	private final String PARTE_TRABALHO = "D";

	Map<String, String> map = new HashMap<String, String>();

	String root_dir = null;
	String caminhoCompletoIndex = null;
	String token = "=";
	int port = 0;
	String keyPort = "port";
	String keyRootDir = "root_dir";
	String mensagem = null;
	String protocolo = null;
	String respostaProtocolo = null;
	long contentLength = 0;
	String contentType = "text/html; charset=UTF-8";
	String server = "servidor";
	String dateGMT = null;
	// boolean arquivoHtmlExistente = false;
	String newLine = System.getProperty("line.separator");
	StringBuilder conteudoArquivoHtml = null;

	public void start(String[] args) {

		String nomeArquivoConfig = null;
		String nomeArquivoRequisicao = null;
		String nomeArquivoSaida = null;
		File arquivoRequisicao = null;
		File arquivoConfig = null;

		gerarDataGMT();

		validaArgumento(args);

		nomeArquivoConfig = args[0];
		nomeArquivoRequisicao = args[1];
		nomeArquivoSaida = args[2];

		try {

			arquivoConfig = validaArquivoConfig(nomeArquivoConfig);
			arquivoRequisicao = validaArquivoRequisicao(nomeArquivoRequisicao);

			lerArquivoConfig(arquivoConfig);
			lerArquivoRequisicao(arquivoRequisicao);

			escreverArquivoSaidaStringBuilder(nomeArquivoSaida);

			escreverArquivoSaidaWriter(nomeArquivoSaida);

			retorno();
		} catch (Exception e) {
			throw new IllegalArgumentException(e);
		}

	}

	private void escreverArquivoSaidaWriter(String nomeArquivoSaida) {
		// TODO falta definicao do tipo de escrita

		String texto = null;
		BufferedWriter writer = null;
		FileWriter file = null;
		String[] conteudo = { 
				"HTTP/1.1 " + respostaProtocolo , 
				"Date: " + dateGMT , 
				"Server: " + server,
				"Content-Length: " + contentLength,
				"Content-Type: " + contentType,
				"Connection: close"
				
				};

		try {
			file = new FileWriter(nomeArquivoSaida+"_writer");
			writer = new BufferedWriter(file);

			for (int i = 0; i < conteudo.length; i++) {
				//System.out.println(conteudo[i].toString());
				texto = conteudo[i];
				writer.write(texto);
				writer.newLine();
				
			}
			writer.newLine();
			writer.write(conteudoArquivoHtml.toString());
			writer.flush();

		} catch (Exception ex) {

		}

	}

	private File validaArquivoRequisicao(String nomeArquivoRequisicao) {
		File arquivoRequisicao = null;
		arquivoRequisicao = new File(DIRETORIO_CONFIG + nomeArquivoRequisicao);

		if (arquivoRequisicao.isDirectory() || !arquivoRequisicao.exists()
				|| arquivoRequisicao.length() == 0) {
			throw new IllegalArgumentException();
		}

		return arquivoRequisicao;

	}

	private File validaArquivoConfig(String nomeArquivoConfig) {
		File arquivoConfig = null;
		arquivoConfig = new File(DIRETORIO_CONFIG + nomeArquivoConfig);

		if (arquivoConfig.isDirectory() || !arquivoConfig.exists()
				|| arquivoConfig.length() == 0) {
			throw new IllegalArgumentException();
		}

		return arquivoConfig;

	}

	private void escreverArquivoSaidaStringBuilder(String nomeArquivoSaida)
			throws IOException {
		// TODO falta definicao do tipo de escrita 
		validarSomenteArquivo(nomeArquivoSaida);

		FileOutputStream fileOutputStream = null;
		fileOutputStream = new FileOutputStream(nomeArquivoSaida);

		StringBuilder sb = new StringBuilder();
		sb.append("HTTP/1.1 " + respostaProtocolo + newLine);
		sb.append("Date: " + dateGMT + newLine);
		sb.append("Server: " + server + newLine);
		sb.append("Content-Length: " + contentLength + newLine);
		sb.append("Content-Type: " + contentType + newLine);
		sb.append("Connection: close" + newLine);
		sb.append(newLine);
		if (respostaProtocolo.equalsIgnoreCase("200 OK")) {
			sb.append(conteudoArquivoHtml);
		}

		try {
			fileOutputStream.write(sb.toString().getBytes());
			// System.out.println(PARTE_TRABALHO.equalsIgnoreCase("D"));
			if (PARTE_TRABALHO.equalsIgnoreCase("D")) {
				setMensagem(sb.toString());
			}
		} catch (Exception e) {
			throw new IllegalArgumentException();
		}

	}

	private void validarSomenteArquivo(String nomeArquivoSaida) {

		if (nomeArquivoSaida.startsWith("/")) {
			throw new IllegalArgumentException();
		}

		String diretorio = "";
		String[] somenteArquivo = nomeArquivoSaida.split("/");
		int tamanho = somenteArquivo.length;

		if (tamanho > 1) {
			for (int i = 0; i < tamanho - 1; i++) {
				diretorio += somenteArquivo[i] + File.separatorChar;
			}

			File diretorioCompleto = new File(diretorio);

			try {
				diretorioCompleto.mkdirs();
			} catch (Exception e) {
				throw new IllegalArgumentException();
			}

		}

	}

	private void gerarDataGMT() {

		Date data = null;
		DateFormat formatador = null;
		String resultado = null;

		data = new Date();
		formatador = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss z",
				Locale.getDefault());
		// formatador.setTimeZone(TimeZone.getTimeZone("America/Santiago"));
		formatador.setTimeZone(TimeZone.getTimeZone("Brazil/East"));

		resultado = formatador.format(data);
		dateGMT = resultado;

	}

	public void lerArquivoConfig(File arquivoConfig) {

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

		if (args == null || args.length != 3 || args[0] == null
				|| args[1] == null || args[2] == null) {
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

	public void lerArquivoRequisicao(File arquivoRequisicao) {

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

				if (arquivoIndex.isDirectory()) {
					file = new File(arquivoIndex, "index.html");
					arquivoIndexExiste = file.exists();
					caminhoCompletoIndex = arquivoIndex.toString();
				}

				if (arquivoIndex.isFile()) {
					file = new File(caminho);
					arquivoIndexExiste = file.exists();
					caminhoCompletoIndex = file.toString();
				}

				if (arquivoIndexExiste) {
					contentLength = file.length();
					lerArquivoHtml(file);

				} else {
					throw new IllegalArgumentException();
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

	private void lerArquivoHtml(File file) throws IOException {

		BufferedReader reader = null;
		String linhas = null;
		StringBuilder sb = null;
		sb = new StringBuilder();
		int tamanhoArquivo = 0;
		int countAux = 0;

		try {

			reader = new BufferedReader(new FileReader(file));

			tamanhoArquivo = (int) file.length();
			FileInputStream fileInputStream = new FileInputStream(file);
			DataInputStream dataInputStream = new DataInputStream(
					fileInputStream);

			LineNumberReader lineRead = new LineNumberReader(
					new InputStreamReader(dataInputStream));
			lineRead.skip(tamanhoArquivo);

			int numLinhas = lineRead.getLineNumber() + 1;

			for (int i = 0; i < numLinhas; i++) {
				countAux++;
				linhas = reader.readLine();

				if (countAux != numLinhas) {
					sb.append(linhas + newLine);

				} else {
					sb.append(linhas);

				}

			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		conteudoArquivoHtml = sb;

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

			respostaProtocolo = "404 NotFound";

			throw new IllegalArgumentException();

		} else {
			respostaProtocolo = "200 OK";
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

	public void retorno() {

		String retorno = null;

		if (PARTE_TRABALHO.equalsIgnoreCase("A")) {
			retorno = port + ":" + DIRETORIO_CONFIG;
			setMensagem(retorno);
		}

		if (PARTE_TRABALHO.equalsIgnoreCase("B")) {
			retorno = root_dir;
			setMensagem(retorno);
		}

		if (PARTE_TRABALHO.equalsIgnoreCase("C")) {
			if (respostaProtocolo.equalsIgnoreCase("200 OK")) {
				retorno = respostaProtocolo + " " + caminhoCompletoIndex;
			} else {
				retorno = respostaProtocolo;
			}
			setMensagem(retorno);
		}

		if (PARTE_TRABALHO.equalsIgnoreCase("D")) {
			// TODO a saida da parte D estao no meio do metodo
			// escreverArquivoSaida
		}

	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

}
