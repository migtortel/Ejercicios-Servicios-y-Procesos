package ejercicio_Concesionario;

public class Main_Concesionario {

	public static void main(String[] args) {
		/*
Implementa un programa que simule la compra (consumidor) y la fabricacion (productor) 
de coches,siguiendo las siguiente condiciones:

Existiran cinco tipos de compradores con identificadores 1,2,3,4,5 y representados 
cada uno por un hilo (todos pertenecen a la misma clase Comprador). 
Cada comprador intentara adquirir nuevamente coches de las siguientes marcas: 
1: "Audi"),2 "Seat"), 3 "BMW"), 4 "Renault") y 5 "Mercedes").

Cuando no se hayan fabricado coches de las marcas solicitadas por un comprador, 
este debera esperar hasta que se produzca su coche. 
No intentara comprar otro coche hasta que el suyo sea fabricado.

Habra un unico fabricante de coches, el cual producira de manera continua coches de 
las marcas de manera aleatoria. El fabricante solo entrara en accion cuando no haya 
ningun coche disponible. Ademas, fabricara un coche de un modelo especifico de manera aleatoria. 

El fabricante descansara cuando haya un coche fabricado hasta que sea comprado por el
comprador correspondiente. Luego, el fabricante comenzara a fabricar un solo coche a la vez.

El proceso se repetira de forma infinita y debera optimizarse la utilizacion de la 
CPU con señales y notificacion y espera entre los hilos cuando corresponda.
		 */
		
		Concesionario concesionario = new Concesionario();
		
		for (int i = 0; i < 5; i++) {
			Comprador comprador = new Comprador(i+1,concesionario);
			new Thread(comprador).start();
		}
		Fabricante fabricante = new Fabricante(concesionario);
		new Thread(fabricante).start();
	}

}
