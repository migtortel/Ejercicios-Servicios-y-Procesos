package ejercicio_interruptores;

import java.util.Random;

public class Panel {

	private boolean[] panel;

	public Panel(int numInterruptores) {
		this.panel = new boolean[numInterruptores];
	}

	public synchronized boolean pulsar(String nombre) {
		Random rand = new Random();
		int interruptor = rand.nextInt(this.panel.length);
		System.out.println("El operario " + nombre + " ha pulsado el interruptor " + interruptor);
		mostrarPanel(interruptor);
		notify();
		if (comprobarPanel() != 0) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(comprobarPanel()==0)
			return false;
		return true;
	}

	private int comprobarPanel() {
		int todosTrue = this.panel.length;
		for (boolean b : panel) {
			if (b == true)
				todosTrue--;
		}
		return todosTrue;
	}

	private void mostrarPanel(int interruptor) {
		this.panel[interruptor] = !this.panel[interruptor];
		for (boolean b : panel) {
			if (!b)
				System.out.print("off\t");
			else
				System.out.print("on\t");
		}
		System.out.println();
	}

}
