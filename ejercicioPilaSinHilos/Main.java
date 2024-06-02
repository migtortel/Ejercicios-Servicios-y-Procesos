package ejercicioPilaSinHilos;


public class Main {

	private static final int NUM = 4;
	public static void main(String[] args) {
		// TODO Auto-generated method stub	
		
		
		Elementos elementos = new Elementos(NUM);
		System.out.println(elementos.sacarElemento()); // Vacía
		System.out.println(elementos.ponerElemento(0)); // Añade 0
		System.out.println(elementos.ponerElemento(0)); // Repetido
		System.out.println(elementos.sacarElemento()); // Extrae el 0
		System.out.println(elementos.ponerElemento(1)); // Añade 1
		System.out.println(elementos.ponerElemento(2)); // Añade 2
		System.out.println(elementos.ponerElemento(3)); // Añade 3
		System.out.println(elementos.ponerElemento(3)); // Repetido
		System.out.println(elementos.ponerElemento(4)); // Añade 4
		System.out.println(elementos.ponerElemento(5)); // No cabe
		System.out.println(elementos.sacarElemento()); // Extrae 
		
		

	}

}
