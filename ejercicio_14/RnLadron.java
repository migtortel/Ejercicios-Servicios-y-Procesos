package ejercicio_14;

import java.util.Random;

public class RnLadron implements Runnable {

	private CajaFuerte caja;
	private int id;
	private Random numLingotes;
	private boolean continua = true;

	public RnLadron(int i, CajaFuerte caja) {
		this.caja = caja;
		this.id = i;
	}

	@Override
	public void run() {
		numLingotes = new Random();
		while (caja.sacarLingotes(this.id,numLingotes.nextInt(6)+1));

		
		
	}

}
