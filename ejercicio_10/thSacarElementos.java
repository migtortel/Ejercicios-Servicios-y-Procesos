package ejercicio_10;

public class thSacarElementos implements Runnable{

	Elementos elementos;
	
	public thSacarElementos(Elementos elementos) {
		this.elementos = elementos;
	}

	@Override
	public void run() {
		while(true) {
			int numEliminado = this.elementos.sacarElemento();
			if(numEliminado == -1)
				System.out.println("Sin elementos");
			else
				System.out.println("Extraido el elemento " + numEliminado);
		}
		
	}

}
