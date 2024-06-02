package ejercicio_12;

public class EscribePingPong {

	private boolean turnoPing = true;

	public synchronized void escribePing() {
		if (turnoPing) {
			System.out.println("ping");
			this.turnoPing = false;
			try {
				notify();
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public synchronized void escribePong() {
		if (!turnoPing) {
			System.out.println("pong");
			this.turnoPing = true;
			try {
				notify();
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
