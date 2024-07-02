package operaciones_matrices;

public class HiloMultiplica extends Thread{
	
	int[][] matriz, resultado;
	int rangoInicial, rangoFinal, escalar;
	

	public HiloMultiplica(int[][] matriz1, int rangoInicial, int rangoFinal, int escalar, int[][] resultado) {
		// TODO Auto-generated constructor stub
		this.matriz = matriz1;
		this.rangoFinal = rangoFinal;
		this.rangoInicial = rangoInicial;
		this.escalar = escalar;
		this.resultado = resultado;
	}
	
	@Override 
	public void run() {
		for (int i = this.rangoInicial; i < this.rangoFinal; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				this.resultado[i][j] = this.matriz[i][j] * escalar;
			}
		}
	}

}
