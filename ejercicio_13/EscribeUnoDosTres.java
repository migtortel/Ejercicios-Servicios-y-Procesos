package ejercicio_13;

public class EscribeUnoDosTres {

	private boolean turno1 = true;
	private boolean turno2 = false;
	private boolean turno3 = false;

	public synchronized void escribeUno() {
		if (turno1) {
			System.out.println(1);
			turno1 = false;
			turno2 = true;
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			notifyAll();
		}
		try {
			wait();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public synchronized void escribeDos() {
		if (turno2) {
			System.out.println(2);
			turno2 = false;
			turno3 = true;
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			notifyAll();
		}
		try {
			wait();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public synchronized void escribeTres() {
		if (turno3) {
			System.out.println(3);
			turno3 = false;
			turno1 = true;
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			notifyAll();
		}
		try {
			wait();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
