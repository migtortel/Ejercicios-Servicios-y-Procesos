package ejercicio_15;

import java.util.Random;

public class Cliente implements Runnable{

	private int idCliente;
	private Cajero caja;
	
	public Cliente(int i, Cajero cajero) {
		this.idCliente = i;
		this.caja = cajero;
	}

	@Override
	public void run() {
		Random r = new Random();
		while(true) {
			int dinero = (r.nextInt(1,6)*20);
			this.caja.sacarDinero(idCliente, dinero);
		}
		
		
	}

}
