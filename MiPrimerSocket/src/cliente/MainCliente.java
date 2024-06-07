package cliente;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class MainCliente {
	public static void main(String[] args) {
		String host = "localhost";
		int puerto = 6000;
		try {
			Socket cliente = new Socket(host, puerto);
			Scanner sc = new Scanner(System.in);

			OutputStream salida = cliente.getOutputStream();
			DataOutputStream flujoSalida = new DataOutputStream(salida);
			String ecribe_a_servidor = "";

			System.out.println("Escribe al servidor:\t ");
			ecribe_a_servidor = sc.nextLine();
			flujoSalida.writeUTF(ecribe_a_servidor);

			InputStream entrada = cliente.getInputStream();
			DataInputStream flujoEntrada = new DataInputStream(entrada);

			System.out.println("Recibiendo mensaje del servidor:\n\t " + flujoEntrada.readUTF());
			sc.close();
			flujoEntrada.close();
			flujoSalida.close();
			cliente.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
