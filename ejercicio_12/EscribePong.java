package ejercicio_12;

public class EscribePong implements Runnable {
	EscribePingPong escribePingPong;

	public EscribePong(EscribePingPong escribePingPong) {
		this.escribePingPong = escribePingPong;
	}

	@Override
	public void run() {
		while (true) {
			escribePingPong.escribePong();
		}
	}

}
