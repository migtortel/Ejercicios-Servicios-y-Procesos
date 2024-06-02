package ejercicio_4;

public class RnHilo extends Thread{

	int rangoIni, rangoFin, sumaPares, sumaImpares;
	int[][] mat;
	public RnHilo(int rangoInicial, int rangoFinal, int[][] matriz) {
		this.rangoIni = rangoInicial;
		this.rangoFin = rangoFinal;
		this.mat = matriz;
	}

	@Override
	public void run() {
		for (int i = this.rangoIni; i < this.rangoFin; i++) {
			for (int j = 0; j < this.mat[i].length; j++) {
				if (mat[i][j] % 2 == 0 ) 
					sumaPares += mat[i][j];
				else 
					sumaImpares += mat[i][j];
			}
		}
	}

	public int getSumaPares() {
		return sumaPares;
	}

	public int getSumaImpares() {
		return sumaImpares;
	}

}
