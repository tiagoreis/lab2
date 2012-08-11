package br.com.senac.alp.aulas;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;


public class PrimeiraAula {

	private static PrimeiraAula instancia = new PrimeiraAula();
	
	private PrimeiraAula() {

		super();
	}
	
	public double somaTotal(double[] valores) {
		
		double resultado = 0.0;
		
		
		if (valores == null){
			resultado = Double.NaN;
		} else{
			for (int i = 0; i < valores.length; i++) {
				resultado +=valores[i];
			}
		}
		
		
		return resultado;
	}
	
	public static PrimeiraAula getInstancia() {
		return PrimeiraAula.instancia;
	}
	
	
	public static void main(String[] args){
		PrimeiraAula obj = null;
		obj = PrimeiraAula.getInstancia();
		obj.testeArgumentoNulo();
		obj.testeSomaResultadoArgumentoVazio();
		obj.testeSomaResultadoArgumentoArray();
		obj.testeSomaResultadoArgumentoArrayUnitario();
	}
	
	
	public void testeArgumentoNulo(){
		PrimeiraAula obj = null;
		obj = PrimeiraAula.getInstancia();
		double[] valores = null;		
		double esperado = 0.0;
		double resultado = 0.0;
				
		esperado = Double.NaN;
		resultado = obj.somaTotal(valores);
		if(Double.compare(resultado, esperado) == 0){
			System.out.println("Quando o argumento for nulo deve retornar " + String.valueOf(esperado) 
					+ ", valor retornando: " + String.valueOf(resultado));
		} else {
			System.out.println("Não ok!");
		}
		
	}
	
	public void testeSomaResultadoArgumentoVazio() {
		PrimeiraAula obj = null;
		obj = PrimeiraAula.getInstancia();

		double[] valores = null;		
		double esperado = 0.0;
		double resultado = 0.0;
		
		valores = new double[0];
		resultado = obj.somaTotal(valores);
		if(Double.compare(resultado, esperado) == 0){
			System.out.println(
					"Quando o argumento for vazio deve retornar " + String.valueOf(esperado) 
					+ ", valor retornando: " + String.valueOf(resultado));
		} else {
			System.out.println("Não ok!");
		}
		
	}
	
	public void testeSomaResultadoArgumentoArrayUnitario() {
		PrimeiraAula obj = null;
		obj = PrimeiraAula.getInstancia();

		double[] valores = null;		
		double esperado = 0.0;
		double resultado = 0.0;
		
		valores = new double[1];
		valores[0] = Math.random();
		esperado = valores[0];
		resultado = obj.somaTotal(valores);
		
		if(Double.compare(resultado, esperado) == 0){
			System.out.println(
					"Esperado valor: " + String.valueOf(esperado) 
					+ ", mas retornado valor: " + String.valueOf(resultado)
					);
		} else {
			System.out.println("Não ok!");
		}

	}

	public void testeSomaResultadoArgumentoArray() {
		PrimeiraAula obj = null;
		obj = PrimeiraAula.getInstancia();

		double[] valores = null;		
		double esperado = 0.0;
		double resultado = 0.0;
		
		valores = new double[10];
		for (int i = 0; i < valores.length; i++) {
			double val = Math.random();
			valores[i] = val;
			esperado += val;
		}

		resultado = obj.somaTotal(valores);
		if(Double.compare(resultado, esperado) == 0){
			System.out.println(
					"Esperado valor: " + String.valueOf(esperado) 
					+ ", mas retornado valor: " + String.valueOf(resultado)
					+ " array completo: " + Arrays.toString(valores)
					);
		} else {
			System.out.println("Não ok!");
		}
		
	}

	
	
}
