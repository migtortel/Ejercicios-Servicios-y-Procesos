package ejercicioPilaConHilos;

import java.util.Random;

public class ThSacarElementos extends Thread{
	Elementos elmentos;
	ThSacarElementos(Elementos e) {
		this.elmentos = e;
	}
	
	@Override
	public void run() {
		Random r = new Random();
		while (true) {
			int ele=this.elmentos.sacarElemento();
			if (ele == -1) {
				System.out.println("Sin elementos");
			}else {
				System.out.println("Extraido el elemento "+ele);
			}
					
		}
	}
}
