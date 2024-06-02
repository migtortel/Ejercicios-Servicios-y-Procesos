package ejercicio_7;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class LecturaFichero {

	private BufferedReader br = null;
	private String linea;
	private File f1 = new File("fichero1.txt");
	private File f2 = new File("fichero2.txt");
	private String[] palabras = new String[4];

	public synchronized void leerFichero(int idHilo) {
		try {
			if (idHilo == 1) {
				leerFichero(this.f1);
				notify(); // Avisamos al otro hilo
				wait(); // Este hilo se queda esperando
			} else {
				leerFichero(this.f2);
				notify(); // Avisamos al otro hilo
				wait(); // Este hilo se queda esperando
			}
		} catch (InterruptedException | IOException e) {
			e.printStackTrace();
		}
	}

	private void leerFichero(File f12) throws IOException {
		if (f12 == this.f1) {
			this.linea = ""; // Reiniciamos lo que contiene linea para cada nueva iteracion
			this.br = new BufferedReader(new FileReader(this.f1));
			this.linea += this.br.readLine() + " "; // Añadimos un espacio al final para poder separar las palabras
			
		} else {
			this.br = new BufferedReader(new FileReader(this.f2));
			this.linea += this.br.readLine() + " ";

			this.palabras = this.linea.split(" "); // Separamos las palabras y las guardamos en un array
		}

	}

	public void mostrarPalabras() {
		// Mostramos las palabras alternadas, segun pide el enunciado
		System.out.println(palabras[0] + " " + palabras[2] + " " + palabras[1] + " " + palabras[3]);
	}

}
