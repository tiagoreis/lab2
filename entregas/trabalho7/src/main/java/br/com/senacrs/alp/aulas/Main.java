package br.com.senacrs.alp.aulas;



public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MinhaListaReversivel<Object> lista = new MinhaListaReversivelImp<Object>();
		
		lista.prefixar("A");
		lista.inserir(1, "B");
		lista.sufixar("C");
		
		for (int i = 0; i < lista.tamanho(); i++) {
			System.out.println(lista.buscar(i));
		}
		
		lista.reverter();
		
		for (int i = 0; i < lista.tamanho(); i++) {
			System.out.println(lista.buscar(i));
		}
	}

}
