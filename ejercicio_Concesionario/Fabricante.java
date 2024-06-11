package ejercicio_Concesionario;

import java.util.Random;

public class Fabricante implements Runnable{
	
	Concesionario concesionario;
	
	public Fabricante(Concesionario concesionario) {
		this.concesionario = concesionario;
	}

	@Override
	public void run() {
		Random rand = new Random();
		while(true) {
			this.concesionario.fabricarCoche(rand.nextInt(1,6));
		}
	}

}
