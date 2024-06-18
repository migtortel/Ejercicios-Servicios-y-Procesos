package ejercicio_2;

public class EscribeExam {

	
	private static final int TURNO_E = 1;
	private static final int TURNO_X = 2;
	private static final int TURNO_A = 3;
	private static final int TURNO_M = 4;
	private static volatile boolean Parar = false;
	
	public static int contE =0;
	public static int contX =0;
	public static int contA =0;
	public static int contM =0;
	
	private int turnoActual = TURNO_E;
	private int tope;
	
	
	public EscribeExam(int numVeces) {
		this.tope = numVeces;
	}
	
	
	public synchronized void escribeE() {
		if (turnoActual == TURNO_E) {
			System.out.print("E");
			turnoActual= TURNO_X;
		}else {
			switch(turnoActual) {
			case TURNO_X:
				contX++;
				break;
			case TURNO_A: 
				contA++;
				break;
			case TURNO_M: 
				contM++;
				break;
			}
		}
		notify();
		try {
			wait();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public synchronized void escribeX() {
		if (turnoActual == TURNO_X) {
			System.out.print("X");
			turnoActual= TURNO_A;
		}else {
			switch(turnoActual) {
			case TURNO_E:
				contE++;
				break;
			case TURNO_A: 
				contA++;
				break;
			case TURNO_M: 
				contM++;
				break;
			}
		}
		notify();
		try {
			wait();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public synchronized void escribeA() {
		if (turnoActual == TURNO_A) {
			System.out.print("A");
			turnoActual= TURNO_M;
		}else {
			switch(turnoActual) {
			case TURNO_X:
				contX++;
				break;
			case TURNO_E: 
				contE++;
				break;
			case TURNO_M: 
				contM++;
				break;
			}
		}
		notify();
		try {
			wait();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public synchronized void escribeM() {
		if (turnoActual == TURNO_M) {
			System.out.println("M");
			turnoActual= TURNO_E;
			tope--;
			if (tope == 0) {
				setParar(true);
			}
		}else {
			switch(turnoActual) {
			case TURNO_X:
				contX++;
				break;
			case TURNO_A: 
				contA++;
				break;
			case TURNO_E: 
				contE++;
				break;
			}
		}
		notify();
		try {
			if(!isParar())
			wait();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}


	public static boolean isParar() {
		return Parar;
	}


	public static void setParar(boolean parar) {
		Parar = parar;
	}


}
