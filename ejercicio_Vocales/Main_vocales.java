package ejercicio_Vocales;

import java.util.Scanner;



public class Main_vocales {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String palabra = "";
		boolean correcto = false;
		do {
			System.out.println("Introduce una palabra con solo dos vocales");
			palabra = sc.next().toUpperCase();
			correcto = esCorrecta(palabra);
		} while (!correcto);
		sc.close();
		
		AlmacenVocales almacenv = new AlmacenVocales(palabra);

		new Thread(new RnJugador(almacenv, 0)).start();
		new Thread(new RnJugador(almacenv, 1)).start();
	}

	private static boolean esCorrecta(String palabra) {
		int numVocales = 0;
		char[] arrayVocales = { 'A', 'E', 'I', 'O', 'U' };
		for (int i = 0; i < palabra.length(); i++) {
			for (int j = 0; j < arrayVocales.length; j++) {
				if (palabra.charAt(i) == arrayVocales[j]) {
					numVocales++;
				}
			}
		}
		if (numVocales == 2)
			return true;
		else
			return false;
	}

}
