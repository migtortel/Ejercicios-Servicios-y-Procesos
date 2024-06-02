package ejercicio_13;

public class EscribeTres implements Runnable {

	private EscribeUnoDosTres esc;
	
	public EscribeTres(EscribeUnoDosTres escribeUnoDosTres) {
		this.esc = escribeUnoDosTres;
	}

	@Override
	public void run() {
		while(true) {
			esc.escribeTres();
		}
	}

}
