package operaciones_matrices;

public class HiloResta extends Thread{

	int[][] matriz1, matriz2, resultado;
	int rangoInicial, rangoFinal;
	

	public HiloResta(int[][] matriz1, int[][] matriz2, int rangoInicial, int rangoFinal) {
		this.matriz1 = matriz1;
		this.matriz2 = matriz2;
		this.rangoInicial = rangoInicial;
		this.rangoFinal = rangoFinal;
		this.resultado = new int[matriz1.length][matriz1.length];
	}
	@Override
	public void run() {
		for(int i = this.rangoInicial;i < this.rangoFinal; i++) {
			for(int j=0;j < this.matriz1[i].length; j++) {
				resultado[i][j] = this.matriz1[i][j] - this.matriz2[i][j];
				System.out.print(resultado[i][j] + " ");
			}
			System.out.println();
		}
	}
}
