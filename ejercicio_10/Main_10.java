package ejercicio_10;

import java.util.Scanner;

public class Main_10 {

	public static void main(String[] args) {
/*	10. Codifica una clase Elementos que permita almacenar en forma de pila y sin
	repetir un determinado número de elementos positivos de tipo int. El número de
	elementos máximo a almacenar será especificado en el constructor.
		• El método sacarElemento extrae un elemento y lo devuelve. Devolverá -1 si la estructura está vacía.
		• El método ponerElemento añade un elemento si hay espacio, no existe
		previamente, y es positivo o 0. Devuelve false si no lo ha podido añadir, true en caso contrario.
*/
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce el número máximo de elementos que almacenará la pila");
		int tope = sc.nextInt();
		sc.close();
		Elementos elementos = new Elementos(tope);
		thPonerElementos ponerElementos = new thPonerElementos(elementos);
		thSacarElementos sacarElementos = new thSacarElementos(elementos);
		new Thread(ponerElementos).start();
		new Thread(sacarElementos).start();
		/*
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
		 */
		
	}

}
