package ejercicio_2;

public class EscribeA extends Thread{
	
	EscribeExam almacen;

	public EscribeA(EscribeExam al) {
		this.almacen=al;
	}

	@Override
	public void run() {
		while (!EscribeExam.isParar()) {
			almacen.escribeA();
		}
	}

}
