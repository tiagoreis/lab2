package br.com.senacrs.alp.aulas.sockets;

import java.io.File;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import br.com.senacrs.alp.aulas.trabalho11.EmissorMensagens;

public class ServidorMain {

	private final static String DIRETORIO_ENTRADA = System
			.getProperty("user.dir")
			+ File.separatorChar
			+ "mensagens"
			+ File.separatorChar;
	private final static String NOME_ARQUIVO_PT = "mensagens_pt.txt";
	private final static String ARQUIVO_PT = DIRETORIO_ENTRADA
			+ NOME_ARQUIVO_PT;

	
	public static void main(String[] args) {
		
		ServerSocket server = null;
		Socket socket = null;
		ManipuladorSocket obj = null;
		String line = null;
		
		EmissorMensagens emissorMensagens = null;
		String msg = null;
		
		
		try {
			
			emissorMensagens = new EmissorMensagens(ARQUIVO_PT);
			msg = emissorMensagens.buscarMensagem("mensagem_bom_dia");
			//System.out.println(msg);
			
			server = new ServerSocket(54321);
			socket = server.accept();
			obj = new ManipuladorSocket(socket);
			line = obj.receberTexto();
			System.out.println(line);
			obj.enviarTexto(msg);
			obj.finalizar();
		} catch (IOException e) {
			throw new IllegalArgumentException(e);
		} finally {
			closeSocket(socket);
			closeServer(server);
		}
	}

	private static void closeSocket(Socket socket) {

		if (socket != null) {
			try {
				socket.close();
			} catch (IOException e) {
				throw new IllegalStateException(e);
			}				
		}
	}

	private static void closeServer(ServerSocket server) {
		
		if (server != null) {
			try {
				server.close();
			} catch (IOException e) {
				throw new IllegalStateException(e);
			}							
		}
	}
}
