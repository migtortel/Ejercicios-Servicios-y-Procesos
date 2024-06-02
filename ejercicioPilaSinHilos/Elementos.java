package ejercicioPilaSinHilos;

public class Elementos {
	
	int cima;
	int []pila;
	public Elementos(int num) {
		this.cima=0;
		pila = new int[num];		
	}
	
	public int sacarElemento() {
		//estamos en el caso de que la pila está vacía
		if (this.cima==0) {
			return -1;
		}else {
			cima--;
			return pila[cima];
		}
	}
	
	public boolean ponerElemento(int elemento) {
		//si cima está al máximo, la pila está llena y no podemos insertar
		if (this.cima==pila.length) {
			return false;
		}else {
			//miramos si el elemento se encuentra en la pila
			for(int i=0;i<this.cima;i++) {
				if (pila[i]==elemento)//el elemento ya está en la pila					
					return false;
			}
			
			pila[cima]=elemento;
			cima++;
			
		}
		
		return true;
	}
	

}
