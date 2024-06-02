package ejercicio_14;

public class CajaFuerte {

	
	private boolean seguir = true;
	private int totalLingotes;
	private boolean turno1 = true;
	
	public CajaFuerte(int n) {
		this.totalLingotes = n;
	}

	public synchronized void sacarLingotes(int idLadron, int lingotes) {
		if(turno1) {
			if(lingotes <= totalLingotes) {
				System.out.println("El ladrón " + idLadron + " ha sacado " + lingotes);
				turno1 = false;
				notify();
				try {
					wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

}
