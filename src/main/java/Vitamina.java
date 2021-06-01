package main.java;

public class Vitamina implements Equipables {
	int contenido;

	/**
	 * Constructor
	 * 
	 * @param vitaminas
	 */
	public Vitamina(int vitaminas) {
		this.contenido = vitaminas;
	}

	/**
	 * Redenicion de activar.
	 */
	@Override
	public PacSim activar(PacSim miPacSim) {
		miPacSim.setVidasExtras(miPacSim.getVidasExtras() + this.getContenido());
		System.out.println("Obtuvo " + this.getContenido() + " vitaminas.");
		return miPacSim;
	}

	/**
	 * Devuelve el contenido.
	 * 
	 * @return
	 */
	public int getContenido() {
		return contenido;
	}
}
