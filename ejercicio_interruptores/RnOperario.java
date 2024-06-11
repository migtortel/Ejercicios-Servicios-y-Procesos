package ejercicio_interruptores;

public class RnOperario implements Runnable {

	private String nombre;
	private Panel panel;
	static boolean seguir = true;

	public RnOperario(String ope, Panel panel) {
		this.nombre = ope;
		this.panel = panel;
	}

	@Override
	public void run() {
		while (this.panel.pulsar(this.nombre));
	}
}
