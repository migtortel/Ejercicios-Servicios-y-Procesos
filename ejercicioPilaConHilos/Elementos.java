package ejercicioPilaConHilos;

public class Elementos {
	
	int cima;
	int []pila;
	public Elementos(int num) {
		this.cima=0;
		pila = new int[num];		
	}
	
	public synchronized int sacarElemento() {
		//estamos en el caso de que la pila está vacía
		if (this.cima==0) {
			try {
				notify();
				wait();//
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return -1;
		}else {
			cima--;			
			return pila[cima];
		}
	}
	
	public synchronized boolean ponerElemento(int elemento) {
		//si cima está al máximo, la pila está llena y no podemos insertar
		if (this.cima==pila.length) {
			System.out.println("No hay sitio");
			try {
				notify();
				wait();//, thP
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return false;
		}else {
			//no se pueden introducir elementos negativos
			if (elemento<0)
				return false;
			//miramos si el elemento se encuentra en la pila
			for(int i=0;i<this.cima;i++) {
				//el elemento ya está en la pila
				if (pila[i]==elemento) {
					System.out.println("El elemento "+elemento+" ya existe");
					return false;
				}
					
			}
			
			pila[cima]=elemento;
			cima++;
			
		}
		
		return true;
	}
	

}
