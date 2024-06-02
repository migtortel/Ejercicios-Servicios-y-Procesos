package ejercicio_3;

import java.util.Arrays;

public class Meta {

	int [] meta;
	int posicion;
	
	public Meta(int tope) {
		this.meta = new int[tope];
		this.posicion = 0;
	}

	public synchronized void llegada(int dorsal) {
		meta[posicion]= dorsal;
		posicion++;
	}

	@Override
	public String toString() {
		return  Arrays.toString(meta) ;
	}

	
}
