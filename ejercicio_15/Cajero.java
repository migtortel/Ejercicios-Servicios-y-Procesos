package ejercicio_15;

public class Cajero {

	private int saldoTotal;
	private int turno_reponedor = 2;
	private int turno_clientes = 1;
	private int turno = turno_reponedor;

	public Cajero(int saldoCajero) {
		this.saldoTotal = saldoCajero;
	}

	public synchronized void sacarDinero(int idCliente, int dinero) {
		try {
			if (turno == turno_clientes) {
				if (saldoTotal - dinero >= 0) {
					saldoTotal -= dinero;
					System.out.println("Cliente: " + idCliente + ". He retirado " + dinero + " euros. Quedan "
							+ saldoTotal + " euros.");
					if (saldoTotal == 0)
						turno = turno_reponedor;
				} else {
					System.out.println("Cliente: " + idCliente + ". No puedo sacar " + dinero + " euros");
				}
				notify();
				wait();
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public synchronized void reponerSaldo(int saldo) {
		if(turno == turno_reponedor) {
			this.saldoTotal = saldo;
			System.out.println("Se han repuesto " + saldo + " euros.");
			turno = turno_clientes;
		}else {
			notify();
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
