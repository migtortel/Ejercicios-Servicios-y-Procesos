package ejercicio_14;

import java.util.Scanner;

public class Main_14 {

	public static void main(String[] args) {
/*
	14. Se dispone de una caja fuerte con N lingotes de oro y acceden a robar dos
	ladrones (1 y 2) que deciden repartirse el botín de la siguiente manera:
	
		• Empezando por el ladrón 1, tirarán por turnos un dado y extraerán de la caja,
			si es posible, el número que haya salido.
			
		• En el momento en que un ladrón no pudiera extraer el número de lingotes
			indicado en el dado, deja de participar y el otro ladrón seguirá el mismo
			proceso pero en solitario.
*/
		Scanner sc = new Scanner(System.in);
		System.out.print("Número de lingotes iniciales en la caja fuerte: ");
		int N = sc.nextInt();
		sc.close();
		CajaFuerte caja = new CajaFuerte(N);
		RnLadron ladron1 = new RnLadron(1, caja);
		RnLadron ladron2 = new RnLadron(2, caja);
		new Thread(ladron1).start();
		new Thread(ladron2).start();
	}

}
