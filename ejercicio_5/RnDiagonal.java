package ejercicio_5;

public class RnDiagonal extends Thread{
	
	int[][] mat;
	int suma;
	
	public RnDiagonal(int[][] matriz) {
		this.mat = matriz;
	}

	@Override
	public void run() {
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[i].length; j++) {
				if(i==j)
					suma += mat[i][j]; 
			}
		}
		
	}
	public int getSumaDiagonal() {
		return suma;
	}

}
