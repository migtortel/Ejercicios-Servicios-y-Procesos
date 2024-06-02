package ejercicio_5;

import java.util.Random;
import java.util.Scanner;

public class Main_5 {

	public static void main(String[] args) {
/*
 * 			5. Codifica un programa que sume los valores de la diagonal principal y 
 * 			la inversa de una matriz cuadrada de tamaño N y la muestre por pantalla. 
 * 			Utiliza hilos y distribuye el trabajo entre dos hilos que se repartan el trabajo.
 */
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce el tamaño de la matriz: ");
		int N = sc.nextInt();
		sc.close();
		int[][] matriz = new int[N][N];
		llenarMatriz(matriz);
		
		RnDiagonal hiloDiagonal = new RnDiagonal(matriz);
		RnInversa hiloInverso = new RnInversa(matriz);
		hiloDiagonal.start();
		hiloInverso.start();
		try {
			hiloDiagonal.join();
			hiloInverso.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("La suma de los valores en la diagonal es: " +hiloDiagonal.getSumaDiagonal());
		System.out.println("La suma de los valores en la diagonal inversa es: " +hiloInverso.getSumaInversa());
		
	}
	private static void llenarMatriz(int[][] matriz) {
		Random rand = new Random();
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				matriz[i][j] = rand.nextInt(1,10); 
				System.out.print(matriz[i][j] + " ");
			}
			System.out.println();
		}
	}

}
