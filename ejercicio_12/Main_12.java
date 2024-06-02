package ejercicio_12;

public class Main_12 {

	public static void main(String[] args) {
		/*12. Sincroniza dos hilos, uno encargado de escribir ping y otro pong, para que el
		resultado de la ejecución sea la secuencia infinita ping, pong, ping, pong, ping,
		pong ... 
		 */
		EscribePingPong escribePingPong = new EscribePingPong();
		Thread thPing = new Thread(new EscribePing(escribePingPong));
		Thread thPong = new Thread(new EscribePong(escribePingPong));
		thPong.start();
		thPing.start();
	}

}
