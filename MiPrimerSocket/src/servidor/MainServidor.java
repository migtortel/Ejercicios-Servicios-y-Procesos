package servidor;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class MainServidor {

	public static void main(String[] args) {
		int puerto = 6000;
		ServerSocket servidor = null;
		Socket clienteConectado = null;
		InputStream entrada = null;
		DataInputStream flujoEntrada = null;
		OutputStream salida = null;
		DataOutputStream flujoSalida = null;
		try {
			Scanner sc = new Scanner(System.in);

			servidor = new ServerSocket(puerto, 3);
			int numCliente = 1;
			
			System.out.println("El servidor esta escuchando el puerto: " + servidor.getLocalPort());
			clienteConectado = null;
			do {
			clienteConectado = servidor.accept();
			entrada = clienteConectado.getInputStream();
			flujoEntrada = new DataInputStream(entrada);
			System.out.println("Recibiendo mensaje del cliente:\n\t " + flujoEntrada.readUTF());
			

			

			salida = clienteConectado.getOutputStream();
			 flujoSalida = new DataOutputStream(salida);
			String escribe_a_cliente = "Buenos días, eres el cliente número "+ numCliente;
			numCliente++;

			//System.out.println("Responde al cliente: \t");
			//escribe_a_cliente = sc.nextLine();
			flujoSalida.writeUTF(escribe_a_cliente);
			sc.close();
			entrada.close();
			flujoEntrada.close();
			salida.close();
			flujoSalida.close();
			clienteConectado.close();
			servidor.close();
			}while(numCliente < 4);
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
