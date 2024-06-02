package ejercicio_7;

import java.io.IOException;

public class Main_7 {

	public static void main(String[] args) {
		/*
		 * 7. (wait y notify) Utilizando wait y notify o notifyAll codifica un programa que 
		 * lea de dos ficheros e intercale las palabras de cada fichero y las muestre por 
		 * pantalla. Si el fichero1.txt tiene "hola Pepe" y el fichero2.txt tiene "Ayer Maria" 
		 * la salida por pantalla tendría que ser "Hola Ayer Pepe Maria", debes programarlo con 
		 * hilos, el hilo uno trabajará con el fichero 1 y el hilo 2 con el segundo.
		 */
		
		// Ejercicio de tipo productor-consumidor
		
		// Instanciamos una clase compartida entre los dos hilos para 
		// poder tener metodos sincronizados
		LecturaFichero fichero;
			fichero = new LecturaFichero();
			new Thread(new RnFichero(1, fichero)).start();
			new Thread(new RnFichero(2, fichero)).start();
		// Iniciamos los hilos 
		
		
	}

}
