package ejercicio_Concesionario;

public class Concesionario {

	private String[] marcas = {"Audi", "Seat", "BMW", "Renault", "Mercedes"};
	private int turnoFabrica = 0;
	private int TURNO_ACTUAL;
	
	
	public synchronized void fabricarCoche(int marca) {
		if(TURNO_ACTUAL == turnoFabrica) {
			TURNO_ACTUAL = marca;
			System.out.println("Coche recién fabricado " + marcas[marca-1]);
		}else {
			notifyAll();
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public synchronized void comprarCoche(int idCliente) {
		if((TURNO_ACTUAL == turnoFabrica)||(TURNO_ACTUAL != idCliente) ) {
			notifyAll();
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		if(TURNO_ACTUAL == idCliente) {
			System.out.println("El comprador " + idCliente + " ha comprado " + marcas[idCliente-1]);
			TURNO_ACTUAL = turnoFabrica;
		}
		
	}

}
