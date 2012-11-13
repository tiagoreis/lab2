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

	private final String DIRETORIO_CONFIG = System.getProperty("user.dir")
			+ File.separatorChar + "config" + File.separatorChar;

	private final String DIRETORIO_HTML = System.getProperty("user.dir") + File.separatorChar
			+ "html" + File.separatorChar;

	Map<String, String> map = new HashMap<String, String>();

	String token = "=";
	String keyPort = "port";
	String keyRootDir = "root_dir";
//	String keyGet = "get";
//	String keyHost = "host";
	String ROOT_DIR = System.getProperty("user.dir");
	String mensagem = null;

	public void lerArquivoConfig(String nomeArquivoConfig) {

		File arquivoConfig = null;
		arquivoConfig = new File(DIRETORIO_CONFIG + nomeArquivoConfig);

		if (arquivoConfig.isDirectory() || !arquivoConfig.exists()) {
			throw new IllegalArgumentException();
		}

		String linhas = null;
		String key = null;
		String value = null;
		int contadorChave = 0;
		StringTokenizer stringToken = null;

		BufferedReader reader = null;

		String[] arrKeyValue = null;
		String mensagem = null;

		try {

			reader = new BufferedReader(new FileReader(arquivoConfig));

			if (arquivoConfig.length() == 0) {
				throw new IllegalArgumentException();
			}

			try {

				while ((linhas = reader.readLine()) != null) {

					stringToken = new StringTokenizer(linhas, token);
					contadorChave = stringToken.countTokens();

					if (linhas.indexOf(token) == -1 || contadorChave > 2) {
						throw new IllegalArgumentException();
					} else {

						arrKeyValue = linhas.split(token);
						key = arrKeyValue[0].trim();
						value = arrKeyValue[1].trim();
						
						map.put(key, value);
					}
				}

				validaDadosConfig(map);

				mensagem = map.get(keyPort) +":" + map.get(keyRootDir);
				
				//setMensagem(mensagem);
				
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

		String nomeArquivoConfig = null;
		String nomeArquivoRequisicao = null;

		if (args == null || args.length != 2 || args[0] == null
				|| args[1] == null) {
			throw new IllegalArgumentException();
		}

		nomeArquivoConfig = args[0];
		nomeArquivoRequisicao = args[1];

		try {
			lerArquivoConfig(nomeArquivoConfig);
			lerArquivoRequisicao(nomeArquivoRequisicao);
			
		} catch (Exception e) {
			throw new IllegalArgumentException(e);
		}

	}

	public void validaDadosConfig(Map<String, String> map) {

		validaPorta(map);
	}

	public void validaPorta(Map<String, String> map) {

		try {

			Pattern pattern = Pattern.compile("[0-9]");
			Matcher matcher = pattern.matcher(map.get(keyPort));

			if (matcher.matches() == true) {
				throw new IllegalArgumentException();
			}

		} catch (Exception e) {
			throw new IllegalArgumentException(e);

		}

	}

	public void lerArquivoRequisicao(String nomeArquivoRequisicao) {

		File arquivoRequisicao = null;
		arquivoRequisicao = new File(DIRETORIO_CONFIG + nomeArquivoRequisicao);

		if (arquivoRequisicao.isDirectory() || !arquivoRequisicao.exists()) {
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

			if (arquivoRequisicao.length() == 0) {
				throw new IllegalArgumentException();
			}

			try {

				linhaGet = reader.readLine();
				linhaHost = reader.readLine();

				caminho = lerCaminhoRequisicao(linhaGet);
				caminho = ajustaSeparador(caminho);
				caminho = ROOT_DIR + caminho;
				
				arquivoIndex = new File(caminho);
				
				if(arquivoIndex.isFile()){
					System.out.println("nao eh arquivo ");
				}
				
				if (arquivoIndex.isDirectory()) {
					//System.out.println("eh diretorio");
					//arquivosNoDiretorio = caminhoReal.listFiles();
					
					//file = new File (caminhoReal + "index.html");
					file = new File(arquivoIndex, "index.html");
					
					arquivoIndexExiste = file.exists();
					
					if(arquivoIndexExiste ){
						System.out.println("arquivo existe");
					} else {
						System.out.println("arquivo nao existe");
						
					}
					
				}

				
				validaHost(linhaHost);


				setMensagem(caminho);

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

		if (linhaHost.startsWith("Host: ")) {
			elementos = linhaHost.split(espaco);
			if (elementos.length == 2) {
				if (elementos[0].equalsIgnoreCase("Host:")) {
				}
			}
		}
	}

	private String lerCaminhoRequisicao(String linhaGet) {

		String[] elementos = null;
		String espaco = " ";
		elementos = linhaGet.split(espaco);
		String caminho = null;

		if (elementos.length == 3) {
			if (elementos[0].equalsIgnoreCase("GET")) {
				if (elementos[2].equalsIgnoreCase("http/1.1")) {
					caminho = elementos[1];
					if (caminho.startsWith("/")) {
					}
				}
			}
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

	
	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

}
