package main.java;

public abstract class Casillero {
	private int posicion;
	private TipoDeCasillero tipo;

	/**
	 * Constructor
	 * 
	 * @param posicion
	 */
	public Casillero(int posicion, TipoDeCasillero tipo) {
		this.posicion = posicion;
		this.tipo=tipo;
	}

	/**
	 * Devuelve la posicion del Casillero (int)
	 * 
	 * @return
	 */
	public int getPosicion() {
		return posicion;
	}

	
	/**
	 * Devuelve el tipo de Casillero
	 * 
	 * @param tipoDeCasillero
	 */
	public TipoDeCasillero getTipoCasillero() {
		return this.tipo;
	}
	
	
}
