package ejercicio_3;

public class RnCorredor implements Runnable {

	int dorsal;
	Meta meta;

	public RnCorredor(int dorsal, Meta meta) {
		this.dorsal = dorsal;
		this.meta = meta;
	}

	@Override
	public void run() {
		for (int i = 0; i < 10000; i++) {
			
		}
		//this.meta.llegada(this.dorsal);
		//System.out.println("El corredor " + dorsal + " ha llegado a la meta.");
		this.meta.llegada(this.dorsal);
	}
}
