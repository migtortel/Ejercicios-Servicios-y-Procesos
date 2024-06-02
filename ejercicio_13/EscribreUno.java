package ejercicio_13;

public class EscribreUno implements Runnable {

	private EscribeUnoDosTres esc;
	
	public EscribreUno(EscribeUnoDosTres escribeUnoDosTres) {
		this.esc = escribeUnoDosTres;
	}

	@Override
	public void run() {
		while(true) {
			esc.escribeUno();
		}
	}
}
