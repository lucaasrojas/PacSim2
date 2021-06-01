package main.java;

public class Juego {

	private LecturaDeConfiguracion nuevaLectura;
	private Tablero nuevoTablero;
	private PacSim miPacSim;

	/**
	 * Constructor
	 * 
	 * @param configuracion
	 */
	public Juego(LecturaDeConfiguracion configuracion) {

	}

	/**
	 * Determina si el juego termino contrastando los metodos gano y perdio si son
	 * distintos hubo ganador o perdedor sino el juego no termino.
	 * 
	 * @return
	 */
	public boolean termino() {
		return (gano() != perdio());
	}

	/**
	 * Determina si gano
	 * 
	 * @return
	 */
	public boolean gano() {
		return (miPacSim.getPosicion() == nuevoTablero.getSalida() && miPacSim.getVidasExtras() >= 0 && !perdio());
	}

	/**
	 * Determina si perdio
	 * 
	 * @return
	 */
	public boolean perdio() {
		return (miPacSim.getVidasExtras() < 0 && !gano());
	}

}
