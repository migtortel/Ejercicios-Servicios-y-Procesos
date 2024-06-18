package ejercicio_2;

public class EscribeX extends Thread{
	
	EscribeExam almacen;

	public EscribeX(EscribeExam al) {
		this.almacen=al;
	}

	@Override
	public void run() {
		while (!EscribeExam.isParar()) {
			almacen.escribeX();
		}
	}

}
