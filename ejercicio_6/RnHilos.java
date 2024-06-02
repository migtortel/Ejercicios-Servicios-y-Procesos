package ejercicio_6;

public class RnHilos extends Thread{
	
	int[][] mat;
	int rangoIn, rangoFin, suma;
	
	public RnHilos(int rangoIni, int rangoFin, int[][] matriz) {
		this.mat = matriz;
		this.rangoFin = rangoFin;
		this.rangoIn = rangoIni;
	}

	@Override
	public void run() {
		for (int i = this.rangoIn; i < this.rangoFin; i++) {
			for (int j = 0; j < this.mat[i].length; j++) {
				suma += mat[i][j];
			}
		}
	}
	
	public int getSuma() {
		return suma;
	}

}
