package main.java;

import java.util.Iterator;
import java.util.LinkedList;

public class Comun extends Ocupable {

	private Mina mina;
	private LinkedList<Equipables> listaDeRecursos = new LinkedList<Equipables>();
	private static TipoDeCasillero comun = TipoDeCasillero.COMUN;

	/**
	 * Constructor posicion-mina
	 * 
	 * @param posicion
	 * @param mina
	 */
	public Comun(int posicion, Mina mina) {
		super(posicion, comun);
		this.mina = mina;
	}

	/**
	 * Constructor posicion-lista-mina
	 * 
	 * @param posicion
	 * @param lista
	 * @param mina
	 */
	public Comun(int posicion, LinkedList<Equipables> lista, Mina mina) {
		super(posicion, comun);
		this.listaDeRecursos = lista;
		this.mina = mina;
	}

	/**
	 * Constructor posicion-vitamina-mina
	 * 
	 * @param posicion
	 * @param miVitamina
	 * @param mina
	 */
	public Comun(int posicion, Vitamina miVitamina, Mina mina) {
		super(posicion, comun);
		this.listaDeRecursos.add(miVitamina);
		this.mina = mina;
	}

	/**
	 * posicion-escudo-mina
	 * 
	 * @param posicion
	 * @param miEscudo
	 * @param mina
	 */
	public Comun(int posicion, Escudo miEscudo, Mina mina) {
		super(posicion, comun);
		this.listaDeRecursos.add(miEscudo);
		this.mina = mina;
	}

	/**
	 * posicion-botiquin-mina
	 * 
	 * @param posicion
	 * @param miBotiquin
	 * @param mina
	 */
	public Comun(int posicion, Botiquin miBotiquin, Mina mina) {
		super(posicion, comun);
		this.listaDeRecursos.add(miBotiquin);
		this.mina = mina;
	}

	/**
	 * posicion-vitamina-escudo-botiquin-mina
	 * 
	 * @param posicion
	 * @param miVitamina
	 * @param miEscudo
	 * @param miBotiquin
	 * @param mina
	 */
	public Comun(int posicion, Vitamina miVitamina, Escudo miEscudo, Botiquin miBotiquin, Mina mina) {
		super(posicion, comun);
		this.listaDeRecursos.add(miVitamina);
		this.listaDeRecursos.add(miEscudo);
		this.listaDeRecursos.add(miBotiquin);
		this.mina = mina;
	}

	/**
	 * Devuelve una lista de Equipables (LinkedList<Equipables>)
	 * 
	 * @return
	 */
	public LinkedList<Equipables> getRecursos() {
		return this.listaDeRecursos;
	}

	/**
	 * Devuelve una mina si existe o null (Mina)
	 * 
	 * @return
	 */
	public Mina getMina() {
		return this.mina;
	}

	/**
	 * Recibe como un Equipable y lo añade a la lista
	 * 
	 * @param equipables
	 */
	public void setRecursos(Equipables equipables) {
		listaDeRecursos.add(equipables);
	}

	/**
	 * Recibe una lista y cambia la existente por esta ultima.
	 * 
	 * @param equipables
	 */
	public void setRecursos(LinkedList<Equipables> equipables) {
		listaDeRecursos = equipables;
	}

	/**
	 * Toma los recursos si existen
	 * 
	 * 
	 * @param PacSim
	 */
	@Override
	public PacSim activar(PacSim miPacSim) {
		Iterator<Equipables> itrTemP = this.listaDeRecursos.iterator();
		while (itrTemP.hasNext()) {
			itrTemP.next().activar(miPacSim);
		}
		this.vaciarRecursos();
		if (this.getMina() != null) {
			System.out.println("Ups!");
			getMina().explotar(miPacSim);
			this.mina = null;
		}
		return miPacSim;
	}

	/**
	 * Vacia lista luego de que hayan sido tomados los recursos.
	 */
	private void vaciarRecursos() {
		while (!listaDeRecursos.isEmpty()) {
			listaDeRecursos.poll();
		}
	}
	@Override
	public String toString() {
		return "Comun";
	}
}
