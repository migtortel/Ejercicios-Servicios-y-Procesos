package ejercicio_1;

import java.util.TreeSet;

public class RnBuscaPrimos implements Runnable{
	
	int rangoInicio, rangoFin;
	static TreeSet<Integer> primosOrdenados = new TreeSet<Integer>(); //para la version 2 del ejercicio
	
	public RnBuscaPrimos(int ini, int fin) {
		this.rangoInicio = ini;
		this.rangoFin = fin;
	}

	@Override
	public void run() {
		for (int i = this.rangoInicio; i < this.rangoFin; i++) {
			if (esPrimo(i)) {
				//System.out.println(i);
				primosOrdenados.add(i);
			}
		}
		
	}

	private boolean esPrimo(int num) {
		if(num <=1)
			return false;
		for (int i = 2; i <= Math.sqrt(num); i++) {
			if (num % i == 0)
				return false;
		}
		return true;
	}
	
	public static void mostrarPrimosOrdenados() {
		System.out.println(primosOrdenados.toString());
	}
}
