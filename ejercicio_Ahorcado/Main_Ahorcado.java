package ejercicio_Ahorcado;

import java.util.Scanner;

public class Main_Ahorcado {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Introduzca la palabra a buscar: ");
		String palabra = sc.next();
		System.out.print("Introduzca el número de jugadores:");
		int numJugadores = sc.nextInt();
		sc.close();
		
		Almacen almacen = new Almacen(palabra, numJugadores);
		for (int i = 0; i < numJugadores; i++) {
			RnJugador jugador = new RnJugador(i, almacen);
			new Thread(jugador).start();
		}
	}
}
