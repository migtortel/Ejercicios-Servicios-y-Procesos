package ejercicio_Ahorcado;

public class Almacen {

	private String adivinaPalabra;
	private char[] palabreja;
	static int numJugadores;
	private boolean turno0 = true;
	private boolean seguir = true;

	public Almacen(String palabra, int numJugadores) {
		this.adivinaPalabra = palabra.toUpperCase();
		Almacen.numJugadores = numJugadores;
		this.palabreja = new char[this.adivinaPalabra.length()];
		llenarPalabreja();
	}

	public synchronized boolean adivinaLetra(int idJugador, char letra) {
		if (!seguir)
			return false;

		if (turno0 && (idJugador != 0)) {
			notifyAll();
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		turno0 = false;
		boolean acierto = comprobarLetra(letra);
		if (acierto) {
			System.out.println("El jugador " + idJugador + " ha adivinado la letra: " + letra + " en la palabra.");
			mostrarEstadoPalabra(letra);
			if (comprobarPalabra()) {
				seguir = false;
				System.out.println("¡El jugador " + idJugador + " ha adivinado la palabra completa!");
				notifyAll();
				return true;
			}
		} else {
			System.out.println(
					"Lo siento jugador " + idJugador + " letra: " + letra + " no encontrada, vuelve a intentarlo.");
		}
		notifyAll();
		if (Almacen.numJugadores > 2) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return acierto;
	}

	private boolean comprobarPalabra() {
		for (char letra : palabreja) {
			if (letra == '_') {
				return false;
			}
		}
		return true;

	}

	private void mostrarEstadoPalabra(char letra) {
		for (int i = 0; i < this.adivinaPalabra.length(); i++) {
			if (this.adivinaPalabra.charAt(i) == letra)
				this.palabreja[i] = letra;
		}
		System.out.println(this.palabreja);

	}

	private boolean comprobarLetra(char letra) {
		for (int i = 0; i < this.adivinaPalabra.length(); i++) {
			if (this.adivinaPalabra.charAt(i) == letra)
				return true;
		}
		return false;

	}

	private void llenarPalabreja() {
		for (int i = 0; i < this.adivinaPalabra.length(); i++) {
			palabreja[i] = '_';
		}
	}

	public boolean isSeguir() {
		return seguir;
	}

}
