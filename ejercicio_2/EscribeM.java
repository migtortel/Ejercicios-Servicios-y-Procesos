package ejercicio_2;

public class EscribeM extends Thread{
	
	EscribeExam almacen;

	public EscribeM(EscribeExam al) {
		this.almacen=al;
	}

	@Override
	public void run() {
		while (!EscribeExam.isParar()) {
			almacen.escribeM();
		}
	}

}
