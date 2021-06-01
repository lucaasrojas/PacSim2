package main.java;

public abstract class Ocupable extends Casillero implements Ocupables{

	Ocupable(int posicion,TipoDeCasillero tipo) {
		super(posicion, tipo);
	}

}
