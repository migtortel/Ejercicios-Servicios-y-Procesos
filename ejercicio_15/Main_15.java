package ejercicio_15;

import java.util.Scanner;

public class Main_15 {

	public static void main(String[] args) {
		/*
	15.- Codifica un programa que simule un cajero automático con los clientes retirando dinero.
		Funcionamiento en detalle:
	• El usuario introduce la cantidad de euros con la que el cajero será repuesto. Dicha cantidad
		será mayor que cero y múltiplo de 20.
	• El usuario introduce el número de clientes que podrán sacar dinero. Cada cliente podrá sacar
		cada vez una cantidad aleatoria que deberá ser múltiplo de 20 y hasta un máximo de 100
		euros por operación. Los nombres de los clientes serán números empezando por el 1.
	• Cada cliente será simulado por un hilo.
	• El “reponedor” del cajero será simulado otro hilo.
	• Al comenzar la simulación, y cada vez que el cajero se quede con saldo 0, será repuesto con
		la cantidad fijada inicialmente.
	• No hay ningún orden establecido para que los clientes extraigan dinero.
	• La simulación no tiene fin.
	• Se han de utilizar señales de coordinación entre los hilos para optimizar el uso de la CPU.
		 */
		Scanner sc = new Scanner(System.in);
		System.out.print("Número de clientes: ");
		int numClientes = sc.nextInt();
		int saldoCajero;
		
		do {
			System.out.print("Saldo de reposción del cajero: ");
			saldoCajero = sc.nextInt();
		}while((saldoCajero<=0) && (saldoCajero%20 !=0));
		sc.close();
		Cajero cajero = new Cajero(saldoCajero);
		Reponedor repo = new Reponedor(saldoCajero, cajero);
		new Thread(repo).start();
		for (int i = 0; i < numClientes; i++) {
			Cliente cli = new Cliente(i+1,cajero);
			new Thread(cli).start();
		}
	}

}
