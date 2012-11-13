package br.com.senacrs.alp.aulas.trabalho12.Main;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class Main {

	public static void main(String[] args) {

		MainReal mainReal = null;
		mainReal = new MainReal();
		
		try {
			
			
			mainReal.validaArgumento(args);
			//System.out.println(mainReal.getMensagem());
			
		} catch (Exception e) {
			System.out.println("Erro");
			throw new IllegalArgumentException();

		}


	}

}
