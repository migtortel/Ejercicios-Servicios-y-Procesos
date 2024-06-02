package ejercicio_6;

import java.util.Random;
import java.util.Scanner;

public class Main_6 {

	public static void main(String[] args) {
		
		/*		6. Codifica un programa que calcule la media de los valores de una matriz 
		 * 		cuadrada de tamaño N y la muestre por pantalla. Utiliza hilos.
		 */
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce el tamaño de la matriz: ");
		int N = sc.nextInt();
		sc.close();
		int[][] matriz = new int[N][N];
		Runtime r = Runtime.getRuntime();
		int cores = r.availableProcessors();
		int rango = N / cores;
		int rangoIni = 0;
		int rangoFin = rango;
		int suma = 0;
		RnHilos[] h = new RnHilos[cores];
		
		llenarMatriz(matriz);
		
		for (int i = 0; i < h.length; i++) {
			h[i] = new RnHilos(rangoIni, rangoFin, matriz);
			h[i].start();
			rangoIni += rango;
			rangoFin += rango;
			if(i == h.length - 2)
				rangoFin = matriz.length;
		}
		
		for (int i = 0; i < h.length; i++) {
			try {
				h[i].join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		for (int i = 0; i < h.length; i++) {
			suma += h[i].getSuma();
		}
		double media = (double)suma/N;
		System.out.println("La suma de los valores de la matriz es: " + suma);
		System.out.println("La media de los valores de la matriz es: " + media);
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
