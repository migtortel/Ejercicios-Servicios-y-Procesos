package ejercicio_15;

import java.util.Scanner;

public class Main_15 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Número de clientes: ");
		int numClientes = sc.nextInt();
		int saldoCajero;
		
		do {
			System.out.print("Saldo de reposción del cajero: ");
			saldoCajero = sc.nextInt();
		}while((saldoCajero<=0) && (saldoCajero%20 !=0));
		
		Cajero cajero = new Cajero(saldoCajero);
		Reponedor repo = new Reponedor(saldoCajero);
		new Thread(repo).start();
		for (int i = 0; i < numClientes; i++) {
			Cliente cli = new Cliente(i+1,cajero);
			new Thread(cli).start();
		}
	}

}
