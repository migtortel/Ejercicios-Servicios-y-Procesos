package ejercicio_4;

import java.util.Random;

public class Main_4 {

	public static void main(String[] args) {
		/*
		 *	4. Codifica un programa que utilizando hilos sume los valores pares e impares 
		 *	de una matriz cuadrada de tamaño N y los muestre por pantalla. Distribuye el 
		 *	trabajo entre los hilos.
		 */
		Runtime r = Runtime.getRuntime();
		int numCores = r.availableProcessors();
		
		int size = 11; // tamaño de la matriz
		int[][] matriz = new int[size][size];
		RnHilo[] hilos = new RnHilo[numCores];
		int rangoInicial = 0;
		int rango = size / numCores;
		int rangoFinal = rango;
		
		// llenamos la matriz con numeros aleatorios del 1 al 100
		llenarMatriz(matriz);
		
		for (int i = 0; i < hilos.length; i++) {
			hilos[i] = new RnHilo(rangoInicial, rangoFinal, matriz);
			hilos[i].start();
			//hilos[i]= new Thread(new RnHilo(rangoInicial, rangoFinal, matriz));
			rangoInicial += rango;
			rangoFinal += rango;
			if (i == hilos.length-2) {
				rangoFinal = matriz.length;
			}
		}
		// hay que esperar a todos los hilos porque si no no se muestra la suma correcta
		for (int i = 0; i < hilos.length; i++) {
			try {
				hilos[i].join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		mostrarSuma(hilos);
		
	}
	
	private static void mostrarSuma(RnHilo[] hilos) {
		int sumaParesTotal =0;
		int sumaImparesTotal =0;
		for (int i = 0; i < hilos.length; i++) {
			sumaImparesTotal += hilos[i].getSumaImpares();
			sumaParesTotal += hilos[i].getSumaPares();
		}
		System.out.println("suma de impares " + sumaImparesTotal);
		System.out.println("suma de pares " + sumaParesTotal);
		
	}

	private static void llenarMatriz(int[][] matriz) {
		Random rand = new Random();
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				matriz[i][j] = rand.nextInt(1,101); 
				System.out.print(matriz[i][j] + " ");
			}
			System.out.println();
		}
	}

}
