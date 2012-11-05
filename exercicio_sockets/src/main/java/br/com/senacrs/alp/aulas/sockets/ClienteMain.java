package br.com.senacrs.alp.aulas.sockets;



import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import br.com.senacrs.alp.aulas.trabalho11.EmissorMensagens;

public class ClienteMain {

	@SuppressWarnings("null")
	public static void main(String[] args) {

		Socket client = null;
		ManipuladorSocket obj = null;
		String line = null;

		String msg = null;
		
		try {
			
			client = new Socket("127.0.0.1", 54321);
			//client = new Socket("192.168.6.138", 54321);
			//client = new Socket("192.168.6.131", 54321);
			
			obj = new ManipuladorSocket(client);
			
			obj.enviarTexto("mensagem_erro");
			
			line = obj.receberTexto();
			System.out.println(line);
			obj.finalizar();
		} catch (UnknownHostException e) {
			throw new IllegalArgumentException(e);
		} catch (IOException e) {
			throw new IllegalArgumentException(e);
		} finally {
			closeSocket(client);
		}
	}

	private static void closeSocket(Socket client) {
		
		if (client != null) {
			try {
				client.close();
			} catch (IOException e) {
				throw new IllegalStateException(e);
			}
		}
	}

}
