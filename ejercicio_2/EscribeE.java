package ejercicio_2;

public class EscribeE extends Thread{

	EscribeExam almacen;
	

	public EscribeE(EscribeExam al) {
		this.almacen=al;
	}

	@Override
	public void run() {
		while (!EscribeExam.isParar()) {
			almacen.escribeE();
		}
	}
}
