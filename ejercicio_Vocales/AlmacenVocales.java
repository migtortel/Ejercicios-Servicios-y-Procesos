package ejercicio_Vocales;

public class AlmacenVocales {

	private String palabra;
	private char[] palabreja;
	private boolean turno1 = true;
	private int jugadores = 2;
	private int[] posicionVocales = new int[2];

	public AlmacenVocales(String palabra) {
		this.palabra = palabra;
		this.palabreja = new char[palabra.length()];
		this.palabreja = ocultarVocales(this.palabra);
		this.posicionVocales = guardarPosicionVocales();
	}

	public synchronized boolean pruebaVocal(int jugador, char c) {
		if (turno1 && jugador != 0) {
			notify();
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		turno1 = false;

		if (this.posicionVocales[jugador] == c) {
			System.out.println("El jugador " + (jugador + 1) + " ha acertado y la palabra ha quedado así: ");
			notify();
			mostrarPalabra(jugador, c);
			jugadores--;
			return false;
		}else {
			System.out.print("El jugador " + (jugador + 1) + " no ha acertado y la palabra ha quedado así: ");
			mostrarPalabreja();
		}
		notify();
		if(jugadores > 1) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		return true;

	}

	private void mostrarPalabra(int jugador, char c) {
		String palabrita = "";
		for (int i = 0; i < this.palabreja.length; i++) {
			if(posicionVocales[jugador] == c) {
				palabrita += c;
			}
			palabrita += this.palabreja[i];
		}
		System.out.println(palabrita);
	}

	private int[] guardarPosicionVocales() {
		int posicion = 0;
		char[] arrayVocales = { 'A', 'E', 'I', 'O', 'U' };
		for (int i = 0; i < palabra.length(); i++) {
			for (int j = 0; j < arrayVocales.length; j++) {
				if (palabra.charAt(i) == arrayVocales[j]) {
					posicionVocales[posicion] = arrayVocales[j];
					posicion++;
				}
			}
		}
		return this.posicionVocales;
	}

	private char[] ocultarVocales(String palabra) {
		char[] arrayVocales = { 'A', 'E', 'I', 'O', 'U' };
		for (int i = 0; i < palabra.length(); i++) {
	        for (int j = 0; j < arrayVocales.length; j++) {
	            if (palabra.charAt(i) == arrayVocales[j]) {
	                this.palabreja[i] = 'X';
	                break;
	            } else {
	                this.palabreja[i] = palabra.charAt(i);
	            }
	        }
	    }
	    return this.palabreja;
	}

	private void mostrarPalabreja() {
		String palabrita = "";
		for (int i = 0; i < palabreja.length; i++) {
			palabrita += this.palabreja[i];
		}
		System.out.println(palabrita);
	}
}