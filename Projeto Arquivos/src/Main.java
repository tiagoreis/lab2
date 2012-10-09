import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

import org.omg.CORBA.PUBLIC_MEMBER;


public class Main {

	public static void main(String[] args)   {
		
		//diretorio usurario
		String prj = System.getProperty("user.dir");

		//diretorio onde ta o doc
		String dir = "meus-docs";
		
		//nome arquivo
		String arqA = "texto.txt";
		String arqB = "saida.txt";
		
		// junta tudo com separador correto
		//String path = prj + File.separatorChar + dir + File.separatorChar + arqA;
		String path = prj + File.separatorChar + dir + File.separatorChar + arqB;
		
		//tipo: arquivo
		File file = new File(path);
		InputStream input = null;
		OutputStream output = null;
		
		try {
			
			//input = new FileInputStream(file);
			output = new FileOutputStream(file,true);
			
			
			//imprimirConteudoInput(input);
			imprimirConteudoOutput(output);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(input != null ){
					input.close();
				} 
				if(output != null){
					output.close();
				}
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}
	
	private static void imprimirConteudoOutput(OutputStream output) {

		byte[] texto = new byte[] {'a','b', 'c', 'd', 'a', '|'};
		
		try {

			for (int i = 0; i < texto.length; i++) {
				//System.out.print(texto[i]);
				output.write(texto[i]);
			}		
				
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
	}

	public static void imprimirConteudoInput(InputStream input) throws IOException {
		
		int conteudo = 0;
		char letra = '\0';
		conteudo = input.read();
		
		while(conteudo != -1){
			letra = (char) conteudo;
			System.out.print(letra);
			//System.out.print(input.markSupported());
			
			conteudo = input.read();
		}
		
	}
}
