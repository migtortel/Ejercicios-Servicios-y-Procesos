package ejercicio_interruptores;

import java.util.Scanner;

public class Main_Interruptores {
	public static void main(String[] args) {
		/*
	Se dispone de un panel con un número determinado de interruptores, cada uno de los 
		cuales enciende o apaga una luz. Inicialmente todas las luces están apagades. 
		Dos operarios, turnándose, pulsarán en cada uno de sus turnos un interruptor 
		cualquiera al azar, apagando o encendiendo una luz, hasta que finalmente todas las 
		luces queden encendidas. Empezará a pulsar el interruptor cualquiera de los dos operarios. 
		Los operarios deberán turnarse y sincronizarse haciendo un uso adecuado de la CPU 
		(evitando espera activa). Se pide realizar la simulación de este panel de interruptores 
		con los dos operarios representados por hilos en ejecución y leyendo desde consola 
		el número de interruptores y los nombres de los operarios.
		 */
		Scanner sc = new Scanner(System.in);
		System.out.print("Número de interruptores: ");
		int numInterruptores = sc.nextInt();
		Panel panel = new Panel(numInterruptores);
		System.out.print("Operario 1: ");
		String ope1 = sc.next();
		System.out.print("Operario 2: ");
		String ope2 = sc.next();
		sc.close();
		RnOperario oper1 = new RnOperario(ope1,panel);
		RnOperario oper2 = new RnOperario(ope2,panel);
		new Thread(oper1).start();
		new Thread(oper2).start();
	}
}
