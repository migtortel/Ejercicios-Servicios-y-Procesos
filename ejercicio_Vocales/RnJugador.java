package ejercicio_Vocales;

import java.util.Random;

public class RnJugador implements Runnable {

	private AlmacenVocales almacen;
	private int jugador;
	private Random rand = new Random();
	private char[] vocales = {'A', 'E', 'I', 'O', 'U'};
	
	public RnJugador(AlmacenVocales almacenv, int id) {
		this.almacen = almacenv;
		this.jugador =id;
	}

	@Override
	public void run() {
		while(this.almacen.pruebaVocal(this.jugador, vocales[rand.nextInt(0,5)]));
	}

}