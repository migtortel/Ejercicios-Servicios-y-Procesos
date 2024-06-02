package ejercicio_3;

public class Main {

	public static void main(String[] args) {
		/*
		 * 3. Codifica un programa que lance una carrera de 8 corredores, representados
		 * cada uno de ellos por un hilo: Cada corredor tendrá un número de dorsal desde
		 * el 1 hasta el 8 y tendrá que incrementar una variable de uno en uno desde el
		 * 1 hasta el 10000 (en un bucle for por ejemplo) para llegar a la meta. Los
		 * corredores saldrán en el mismo momento en el que ejecute la aplicación.
		 * Cuando hayan llegado los 8 corredores se mostrará un listado de resultados.
		 */

		Thread[] corredor = new Thread[8];
		Meta meta = new Meta(8);
		for (int i = 0; i < corredor.length; i++) {
			corredor[i] = new Thread(new RnCorredor(i + 1, meta));
			corredor[i].start();
		}
		try {
			for (Thread thread : corredor) {
				thread.join();
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Resultados de la carrera: " + meta.toString());
	}
}
