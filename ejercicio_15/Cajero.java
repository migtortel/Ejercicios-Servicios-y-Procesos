package ejercicio_15;

public class Cajero {

	private int saldoTotal;
	private boolean turno_reponedor = true;

	public Cajero(int saldoCajero) {
		this.saldoTotal = saldoCajero;
	}

	public synchronized void sacarDinero(int idCliente, int dinero) {
		try {
			if (!turno_reponedor) {
				if (saldoTotal - dinero >= 0) {
					saldoTotal -= dinero;
					System.out.println("Cliente: " + idCliente + ". He retirado " + dinero + " euros. Quedan "
							+ saldoTotal + " euros.");
					if (saldoTotal == 0)
						turno_reponedor = true;
				} else {
					System.out.println("Cliente: " + idCliente + ". No puedo sacar " + dinero + " euros");
				}
			}
			notifyAll();
			wait();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public synchronized void reponerSaldo(int saldo) {
		if (turno_reponedor) {
			this.saldoTotal = saldo;
			System.out.println("Se han repuesto " + saldo + " euros.");
			turno_reponedor = false;
		}
		notifyAll();
		try {
			wait();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}
