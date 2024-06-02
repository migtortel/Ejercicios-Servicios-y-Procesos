package ejercicio_13;

public class EscribeDos implements Runnable {

	private EscribeUnoDosTres esc;
	
	public EscribeDos(EscribeUnoDosTres escribeUnoDosTres) {
		this.esc = escribeUnoDosTres;
	}

	@Override
	public void run() {
		while(true) {
			esc.escribeDos();
		}
	}
}
