package ejercicio_1;

import java.io.EOFException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class MainLectura {

	public static void main(String[] args) throws IOException {

		RandomAccessFile raf = new RandomAccessFile("01 - QueSera.bin", "rw");

		try {
			raf.seek(0); // me posicion al inicio del fichero
			int numRegistros = raf.readByte(); // leo el numero de registros que hay en el fichero
			System.out.println("el fichero contiene " + numRegistros + " registros");
			int contador = 1; // utilizo un contador para controlar la posicion del puntero
			while (raf.getFilePointer() < raf.length()) {
				try {
					int posicionRegistro = raf.readShort(); // leo donde se encuentra el registro
					raf.seek(posicionRegistro); //me situo en esa posicion
					int longRegistro = raf.readShort(); // leo la longitud del registro
					byte[] registro = new byte[longRegistro]; // genero un array de bytes con esa longitud
					raf.readFully(registro); // leo los bytes
					String registroString = new String(registro, "UTF-8"); // genero un string
					System.out.println(registroString); // lo muestro por pantalla
					contador += 2; // sumo dos bytes que contienen la posicion del registro al inicio del fichero
					raf.seek(contador); // me situo al inicio del fichero para comenzar a procesar el siguiente registro
				}catch(EOFException e) {
					raf.close();
					System.out.println("\nCerrando fichero"); // hemos llegado al final del fichero, salgo del bucle
					break;
				}
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
