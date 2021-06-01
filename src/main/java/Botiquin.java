package main.java;

import java.util.Iterator;
import java.util.LinkedList;

public class Botiquin implements Equipables {

	private LinkedList<Botiquin> listaBotiquin = new LinkedList<Botiquin>();
	private Vitamina vitaminas;
	private Escudo escudos;
/**
 * Constructor
 * 
 * @param vitaminas
 * @param escudos
 */
	public Botiquin(Vitamina vitaminas, Escudo escudos) {
		this.vitaminas = vitaminas;
		this.escudos = escudos;
	}
/**
 * Recibe como parametro un Botiquin y lo agrega a la lista
 * @param miBotiquin
 */
	public void agregarBotiquin(Botiquin miBotiquin) {
		try {
			if (this != miBotiquin) {
				listaBotiquin.add(miBotiquin);
			} else {
				throw new Error("Genera loop infinito");
			}	
		}catch (Exception e) {
			System.err.println(e);
		}
		
	}
/**
 * Redefinicion de activar
 */
	@Override
	public PacSim activar(PacSim miPacSim) {
		System.out.println("\nBotiquin:");
		if (this.vitaminas != null) {
			this.vitaminas.activar(miPacSim);
		}
		if (this.escudos != null) {
			this.escudos.activar(miPacSim);
		}
		if (!listaBotiquin.isEmpty()) {
			Iterator<Botiquin> itr = listaBotiquin.iterator();
			while (itr.hasNext()) {
				System.out.println("\n**Incluye otro botiquin**");
				itr.next().activar(miPacSim);
			}
		}

		return miPacSim;
	}

}
