package main.java;

public class Mina {
	int valor;
	public Mina() {
	}
	/**
	 * Recibe como parametro un PacSim Si no puede resistir a la explosion el PacSim
	 * recibido resta una vida y si resiste un escudo. Infoma las vidas y escudos
	 * restantes. Y actualiza el estado si murió.
	 * 
	 * @param miPacSim
	 */
	public void explotar(PacSim miPacSim) {
		if (miPacSim.resistir()) {
			miPacSim.restarEscudo();
			System.out.println("Escudo utilizado.\nRestantes: " + miPacSim.getEscudos()+"\n");
		} else {
			System.out.println("Impacto directo.");
			miPacSim.restarVida();
			if (miPacSim.estaVivo()) {
				System.out.println("Vidas Extras: " + miPacSim.getVidasExtras());
			} else {
				System.out.println("Estas muerto.\n");
			}

		}
	}
}
