package ejercicio_14;

public class CajaFuerte {

	private int totalLingotes;
	private boolean haRobadoUno = false;
	private int numLadrones = 2;

	public CajaFuerte(int n) {
		this.totalLingotes = n;
	}


	public synchronized boolean sacarLingotes(int idLadron, int lingotes) {
	
			if((!haRobadoUno) && (idLadron !=1)) {
				notify();
				try {
					wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return true;
			}

			haRobadoUno = true;
			
			if(lingotes <= totalLingotes) {
				totalLingotes -=lingotes;
				System.out.println("El ladrón " + idLadron + " ha sacado " + lingotes+".");
				notify();
				if(numLadrones>1) {
					try {
						wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				return true;
				
			}else {
				System.out.println("El ladrón " + idLadron + " no puede sacar " + lingotes+" y finaliza.");
				numLadrones--;
				notify();
				return false;
			}

		
	}

}
