package ejercicio_1;

public class Main {

	public static void main(String[] args) {

		/*
		 * 1. Suponiendo que se dispone de una máquina con 4 cores, muestra de una
		 * manera eficiente los números primos que existen entre uno hasta un millón.
		 * Puedes crear una clase en la que al constructor se le indique el rango donde
		 * tiene que buscar los números primos. ¿Aparecerán ordenados?
		 */
		/*
		 * 2.Muestra los números primos mostrados en el ejercicio anterior pero de
		 * maneraordenada y utilizando un hilo para cada rango.
		 */

		Runtime r = Runtime.getRuntime();
		int numCores = r.availableProcessors();
		//System.out.println("numero de procesadores " + numCores);
		int rango = 100 / numCores;
		int rangoIni = 0;
		int rangoFin = rango;

		Thread[] hilos = new Thread[numCores]; // para la version 2

		// este bucle es para el ejercicio 1 (mas sencillo)
		
		for (int i = 0; i < numCores; i++) {
			new Thread(new RnBuscaPrimos(rangoIni, rangoFin)).start();
			rangoIni += rango;
			rangoFin += rango;
		}
		
		// este bucle es para el ejercicio 2
		for (int i = 0; i < hilos.length; i++) {
			hilos[i] = new Thread(new RnBuscaPrimos(rangoIni, rangoFin));
			hilos[i].start();
			rangoIni += rango;
			rangoFin += rango;
		}
		//esperamos a que terminen todos los hilos
		try {
			for (Thread thread : hilos) {
				thread.join();
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		RnBuscaPrimos.mostrarPrimosOrdenados();
	}

}
