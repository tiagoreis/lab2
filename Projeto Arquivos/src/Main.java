import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;


public class Main {

	public static void main(String[] args)   {
		
		//diretorio usurario
		String prj = System.getProperty("user.dir");

		//diretorio onde ta o doc
		String dir = "meus-docs";
		
		//nome arquivo
		String arq = "texto.txt";
		
		// junta tudo com separador correto
		String path = prj + File.separatorChar 
				+ dir + File.separatorChar + arq;
		
		//tipo: arquivo
		File file = new File(path);
		InputStream input = null;
		
		
		try {
			input = new FileInputStream(file);
		
			imprimirConteudo(input);
			
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			try {
				if(input != null){
					input.close();
				} else {
					System.out.println("input null");
				}
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}
	
	public static void imprimirConteudo(InputStream input) throws IOException {
		
		int conteudo = 0;
		char letra = '\0';
		conteudo = input.read();
		
		while(conteudo != -1){
			letra = (char) conteudo;
			System.out.print(letra);
			conteudo = input.read();
		}
		
	}
}
