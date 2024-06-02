package ejercicio_10;

public class Elementos {

	private int posicion;
	private int pila[];

	public Elementos(int tope) {
		this.posicion = 0;
		this.pila = new int[tope];
	}

	public synchronized int sacarElemento() {
		if (this.posicion == 0) {
			try {
				notify();
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return -1;
		}else {
			posicion--;
			return pila[posicion];
		}
	}

	public synchronized boolean ponerElemento(int num) {
		if (num >= 0 && (posicion < pila.length)) {
			for (int i = 0; i < this.posicion; i++) {
				if (this.pila[i] == num) {
					System.out.println("Elemento " + num + " ya existe");
					return false;
				}
			}
			pila[posicion] = num;
			posicion++;
			return true;
		}else {
			try {
				notify();
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("No hay sitio");
			return false;
		}
	}
}
