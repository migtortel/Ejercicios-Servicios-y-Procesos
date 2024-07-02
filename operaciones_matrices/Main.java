package operaciones_matrices;

import java.util.Random;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce el número de filas y columnas de la matriz cuadrada:");
		int tamanio = sc.nextInt();
		System.out.println("Introduce la operación a realizar: 0 (suma), 1 (resta), 2 (multiplicación)");
		int operacion = sc.nextInt();
		int escalar = 1;

		Runtime r = Runtime.getRuntime();
		int numCores = r.availableProcessors();
		int rango = tamanio / numCores;
		int rangoInicial = 0;
		int rangoFinal = rango;
		int[][] matriz1 = new int[tamanio][tamanio];
		int[][] matriz2 = new int[tamanio][tamanio];
		int[][] resultado = new int[tamanio][tamanio];
		switch (operacion) {
		case 0:
			generarMatriz(matriz1);
			System.out.println("******* + *******");
			generarMatriz(matriz2);
			HiloSuma []hSuma  = new HiloSuma[numCores]; 
			System.out.println("--------------------");
			for(int i=0;i<hSuma.length;i++) {
				hSuma[i] = new HiloSuma(matriz1, matriz2, rangoInicial, rangoFinal);
				hSuma[i].start();
				rangoInicial += rango;
				rangoFinal += rango;
				if (i==hSuma.length - 2) {
					rangoFinal = matriz1.length;
				}
			}
			break;
		case 1:
			generarMatriz(matriz1);
			System.out.println("******* + *******");
			generarMatriz(matriz2);
			HiloResta []hResta  = new HiloResta[numCores]; 
			System.out.println("--------------------");
			for(int i=0;i<hResta.length;i++) {
				hResta[i] = new HiloResta(matriz1, matriz2, rangoInicial, rangoFinal);
				hResta[i].start();
				rangoInicial += rango;
				rangoFinal += rango;
				if (i==hResta.length - 2) {
					rangoFinal = matriz1.length;
				}
			}
			for (int i = 0; i < hResta.length; i++) {
				
			}
			break;
		case 2:
			System.out.println("Introduce el número a multiplicar");
			escalar = sc.nextInt();
			generarMatriz(matriz1);
			System.out.println("***************");
			HiloMultiplica []hMultiplica = new HiloMultiplica[numCores];
			System.out.println("--------------------");
			for(int i=0;i<hMultiplica.length;i++) {
				hMultiplica[i] = new HiloMultiplica(matriz1, rangoInicial, rangoFinal, escalar, resultado);
				hMultiplica[i].start();
				rangoInicial += rango;
				rangoFinal += rango;
				if (i==hMultiplica.length - 2) {
					rangoFinal = matriz1.length;
				}
			}
			for (int i = 0; i < hMultiplica.length; i++) {
				try {
					hMultiplica[i].join();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			mostrarResultado(resultado);
			break;
		default:
			System.out.println("Operación inválida");
		}

		
		sc.close();
    }


	private static void generarMatriz(int matriz[][]) {
		Random random = new Random();
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				matriz[i][j] = random.nextInt(1, 6);
				System.out.print(matriz[i][j] + " ");
			}
			System.out.println();
		}
	}
	private static void mostrarResultado(int resultado[][]) {
		for (int i = 0; i < resultado.length; i++) {
			for (int j = 0; j < resultado[i].length; j++) {
				System.out.print(resultado[i][j] + "  ");
			}
			System.out.println();
		}
	}

}
