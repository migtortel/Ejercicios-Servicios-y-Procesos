package ejercicio_12;

public class EscribePing implements Runnable {
	EscribePingPong escribePingPong;
	public EscribePing(EscribePingPong escribePingPong) {
		this.escribePingPong = escribePingPong;
	}

	@Override
	public void run() {
		while(true) {
			escribePingPong.escribePing();
		}

	}

}
