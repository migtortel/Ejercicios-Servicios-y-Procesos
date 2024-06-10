package servidor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class MainServidor {
	public static void main(String[] args) throws IOException {

		int numeroPuerto = 6000; // Puerto
		ServerSocket servidor = new ServerSocket(numeroPuerto);
		String clienteDice, servidorDice = "";
		System.out.println("Esperando conexión...");
		Socket clienteConectado = servidor.accept();
		System.out.println("Cliente conectado.");
		
		// Flujo de salida al cliente
		PrintWriter fsalida = new PrintWriter(clienteConectado.getOutputStream(), true);
		// Flujo de entrada del cliente
		BufferedReader fentrada = new BufferedReader(
				new InputStreamReader(clienteConectado.getInputStream()));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		while(servidorDice != null) { 
			clienteDice = fentrada.readLine(); //Recibo cadena del cliente
			System.out.println("Recibiendo: " + clienteDice);
			System.out.println(" Escribe al cliente");
			servidorDice = in.readLine(); 
			fsalida.println(servidorDice); // Envio cadena al cliente
			if(clienteDice.equals("*")) break;			
		}
		// Cerrando conexiones
		System.out.println("Cerrando conexiones...");
		fentrada.close();
		fsalida.close();
		in.close();
		clienteConectado.close();
		servidor.close();
	}
}
