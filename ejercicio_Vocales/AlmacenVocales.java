package ejercicio_Vocales;

public class AlmacenVocales {

	private char[] palabra;
	private char[] palabreja;      // Para ocultar las vocales
	private boolean turno1 = true; // Para determinar el jugador que empieza
	private int jugadores = 2;    //  Hay que controlar cuando un jugador termina
	private char[] posicionVocales = new char[2];  // A cada jugador le corresponde una letra

	public AlmacenVocales(String palabra) {
		this.palabra = palabra.toCharArray();
		this.palabreja = new char[palabra.length()];
		this.palabreja = ocultarVocales(palabra);
		this.posicionVocales = guardarPosicionVocales();
	}

	public synchronized boolean pruebaVocal(int jugador, char c) {
		// Si no entra el jugador 1 se va a dormir
		if (turno1 && jugador != 0) {
			notify();
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		turno1 = false;
		// Aqui comprobamos que la letra que envia el jugador corresponde con la letra que hemos guardado
		if (this.posicionVocales[jugador] == c) {
			System.out.print("El jugador " + (jugador + 1) + " ha acertado y la palabra ha quedado así: ");
			notify();
			mostrarPalabra(c);
			jugadores--;
			return false;
		}else {
			System.out.println("El jugador " + (jugador + 1) + " no ha acertado y la palabra ha quedado así: " + new String(palabreja));
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
	// Sustituye la X por la vocal que corresponda, el break es por si la letra esta repetida
	private void mostrarPalabra(char c) {
		for (int i = 0; i < this.palabreja.length; i++) {
			if(this.palabra[i] == c && this.palabreja[i] == 'X') {
				this.palabreja[i]= c;
				break;
			}
		}
		System.out.println(new String(this.palabreja));
	}
	// Guardamos la posicion en un array porque el jugador 1 intenta solo la primera vocal
	private char[] guardarPosicionVocales() {
		int posicion = 0;
		char[] arrayVocales = { 'A', 'E', 'I', 'O', 'U' };
		for (int i = 0; i < palabra.length; i++) {
			for (int j = 0; j < arrayVocales.length; j++) {
				if (palabra[i] == arrayVocales[j]) {
					posicionVocales[posicion] = arrayVocales[j];
					posicion++;
				}
			}
		}
		return this.posicionVocales;
	}
	// Compara las vocales de la palabra con el array de vocales y sustituye con X
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
}