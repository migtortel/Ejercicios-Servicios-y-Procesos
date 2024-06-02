package ejercicio_5;

public class RnInversa extends Thread{
	
	int[][] mat;
	int suma;
	
	public RnInversa(int[][] matriz) {
		this.mat = matriz;
	}

	@Override
	public void run() {
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[i].length; j++) {
				if(i+j == mat.length - 1)
					suma += mat[i][j]; 
			}
		}
	}
	public int getSumaInversa() {
		return suma;
	}
}
