package ejercicio_Ahorcado;

import java.util.Random;

public class RnJugador implements Runnable {

	private Almacen almacen;
	private int idJugador;
	private int intentos;

	public RnJugador(int idJugador, Almacen almacen) {
		this.almacen = almacen;
		this.idJugador = idJugador;
		this.intentos = 10;
	}

	@Override
	public void run() {
		Random random = new Random();
		while (intentos > 0 && almacen.isSeguir()) {
			char letra = (char) (random.nextInt(26) + 'A');
			almacen.adivinaLetra(idJugador, letra);
			intentos--;
			if (intentos == 0) {
				System.out.println("El jugador " + idJugador + " ha agotado sus intentos.");
				Almacen.numJugadores--;
			}
		}
	}

}
