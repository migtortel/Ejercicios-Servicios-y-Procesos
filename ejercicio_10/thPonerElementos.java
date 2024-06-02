package ejercicio_10;

import java.util.Random;

public class thPonerElementos implements Runnable {

	Elementos elementos;
	private Random random = new Random();
	private int numAnadido;

	public thPonerElementos(Elementos elementos) {
		this.elementos = elementos;
	}

	@Override
	public void run() {
		while(true) {
			numAnadido = random.nextInt(0,101);
			if (this.elementos.ponerElemento(numAnadido))
				System.out.println("Añadido el elemento " + numAnadido);				
		}
	}
}
