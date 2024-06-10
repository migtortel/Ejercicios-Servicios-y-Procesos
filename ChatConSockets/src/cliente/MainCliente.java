package cliente;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class MainCliente {
	public static void main(String[] args) throws IOException {
		String host = "localhost";
		int puerto = 6000;
		Socket cliente = new Socket(host, puerto);
		
		// Flujo de salida al servidor
		PrintWriter fsalida = new PrintWriter(cliente.getOutputStream(),true);
		// Flujo de entrada del servidor
		BufferedReader fentrada = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
		// Flujo para entrada estandar
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String cadena,eco = "";
		System.out.println("Introduce cadena: ");
		cadena = in.readLine(); // lectura por teclado
		while(!cadena.equals("salir")) {
			fsalida.println(cadena); // envio cadena al servidor
			eco = fentrada.readLine(); // recibo cadena del servidor
			System.out.println("   -> Servidor dice: " + eco);
			System.out.println("Introduce cadena: ");
			cadena = in.readLine(); //lectura por teclado
		}
		fsalida.close();
		fentrada.close();
		in.close();
		cliente.close();
	}
}
