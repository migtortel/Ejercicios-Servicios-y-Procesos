package ejercicio_7;

public class RnFichero implements Runnable {

	private int id;
	private LecturaFichero fichero;

	public RnFichero(int id, LecturaFichero fichero) {
		this.id = id;
		this.fichero = fichero;
	}

	@Override
	public void run() {
		while (true) {
			fichero.leerFichero(this.id);
			fichero.mostrarPalabras();
		}
	}
}
