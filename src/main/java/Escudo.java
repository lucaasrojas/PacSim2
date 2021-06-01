package main.java;

public class Escudo implements Equipables {
	int contenido;

	/**
	 * Constructor
	 * 
	 * @param cantidadDeEscudos
	 */
	public Escudo(int cantidadDeEscudos) {
		this.contenido = cantidadDeEscudos;
	}

	/**
	 * Redenicion de activar.
	 */
	@Override
	public PacSim activar(PacSim miPacSim) {
		miPacSim.setEscudos(miPacSim.getEscudos() + this.getContenido());
		System.out.println("Obtuvo " + this.getContenido() + " escudos.");
		return miPacSim;
	}

	/**
	 * Devuelve el contenido del escudo
	 * 
	 * @return
	 */
	public int getContenido() {
		return this.contenido;
	}
}
