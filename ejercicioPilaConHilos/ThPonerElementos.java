package ejercicioPilaConHilos;

import java.util.Random;

public class ThPonerElementos extends Thread{
	
	
	Elementos elmentos;
	ThPonerElementos(Elementos e) {
		this.elmentos = e;
	}
	
	@Override
	public void run() {
		Random r = new Random();
		while (true) {
			int x = r.nextInt(0,100);
			if (this.elmentos.ponerElemento(x))
					System.out.println("Añadido el elemento "+x);
		}
	}

}
