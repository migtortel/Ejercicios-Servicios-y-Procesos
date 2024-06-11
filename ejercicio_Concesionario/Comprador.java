package ejercicio_Concesionario;

public class Comprador implements Runnable{
	Concesionario concesionario;
	int idCliente;
	
	public Comprador(int idComprador, Concesionario concesionario) {
		this.idCliente = idComprador;
		this.concesionario = concesionario;
	}

	@Override
	public void run() {
		while(true) {
			this.concesionario.comprarCoche(idCliente);
		}
		
	}

}
