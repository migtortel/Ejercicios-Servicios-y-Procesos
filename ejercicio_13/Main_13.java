package ejercicio_13;

public class Main_13 {

	public static void main(String[] args) {
/*
	13. Sincroniza tres hilos de tal manera que escriban la secuencia infinita uno, dos,
	tres, uno, dos, tres,... Cada uno de estos tres hilos se encarga de escribir un número
	de manera coordinada con el resto. La serie, indistintamente de cuál sea el hilo que
	comience, ha de empezar con uno. La clase EscribeUnoDosTres contendrá al menos
	tres métodos escribeUno(), escribeDos() y escribeTres() que serán invocados desde
	los Threads. El programa principal debe ser el siguiente:
*/

		EscribeUnoDosTres escribeUnoDosTres = new EscribeUnoDosTres();
		Thread thUno = new Thread(new EscribreUno(escribeUnoDosTres));
		Thread thDos = new Thread(new EscribeDos(escribeUnoDosTres));
		Thread thTres = new Thread(new EscribeTres(escribeUnoDosTres));
		thTres.start();
		thDos.start();
		thUno.start();
		
	}

}
