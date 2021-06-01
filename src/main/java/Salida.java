package main.java;

public class Salida extends Ocupable {

	Salida(int posicion) {
		super(posicion, TipoDeCasillero.SALIDA);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Determina si gano
	 */
	@Override
	public PacSim activar(PacSim miPacSim) {
		return null;
	}
	@Override
	public String toString() {
		return "Salida";
	}
}
