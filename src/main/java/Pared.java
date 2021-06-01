package main.java;

public class Pared extends Casillero {

	public Pared(int posicion) {
		super(posicion, TipoDeCasillero.PARED);
	}
	@Override
	public String toString() {
		return "Pared";
	}

}
