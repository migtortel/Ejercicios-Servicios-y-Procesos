package ejercicio_15;

public class Reponedor implements Runnable{

	private int saldo;
	private Cajero caja;
	
	public Reponedor(int saldoCajero, Cajero cajero) {
		this.saldo = saldoCajero;
		this.caja = cajero;		
	}

	@Override
	public void run() {
		while(true) {
			this.caja.reponerSaldo(saldo);
		}
		
	}

}
