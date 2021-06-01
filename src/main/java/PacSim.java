package main.java;

public class PacSim {

	private int vidasExtras = 0, escudos = 0, posicion = 0, x, y;
	private Tablero mapa;

	/**
	 * Constructor
	 * 
	 * @param cantidadDeVidasExtras
	 * @param posicionInicial
	 */
	public PacSim(int cantidadDeVidasExtras, int posicionInicial) {
		try {
			if (cantidadDeVidasExtras >= 0 && posicionInicial >= 0) {
				this.vidasExtras = cantidadDeVidasExtras;
				this.posicion = posicionInicial;
			} else {
				throw new Error("Parametros inválido");
			}
		} catch (Exception e) {
			System.err.println("Error");
		}
	}

	/**
	 * Devuelve la posicion ocupada (int)
	 * 
	 * @return
	 */
	public int getPosicion() {
		return posicion;
	}

	/**
	 * Devuelve la cantidad de vidas restantes (int)
	 * 
	 * @return
	 */
	public int getVidasExtras() {
		return vidasExtras;
	}

	/**
	 * Devuelve true si tiene 0 o más vidas Devuelve false si tiene menos de 0
	 * 
	 * @return
	 */
	public boolean estaVivo() {
		return (vidasExtras >= 0);
	}

	/**
	 * Recibe como parametro un Ocupable.
	 * 
	 * Si además es Comun: Si la posicion en la misma y si el casillero tiene mina
	 * entonces explota. Si tiene recursos los toma.
	 * 
	 * Si además es Entrada: ++++++++++++++++++++ ++++++++++++++++++++
	 * 
	 * Si además es Salida: ++++++++++++++++++++ ++++++++++++++++++++
	 * 
	 * 
	 * @param miPacSim
	 * @return
	 */
	public PacSim pisar(Ocupable nuevoCasillero) {

		if (this.getPosicion() == nuevoCasillero.getPosicion()) {
			PacSim pacTem = nuevoCasillero.activar(this);
			this.setVidasExtras(pacTem.getVidasExtras());
			this.setEscudos(pacTem.getEscudos());
		}
		return this;
	}

	/**
	 * Recibe como parametro un tipo de direccion y devuelve el nuevo casillero si
	 * es Ocupable Sino devuelve el casillero actual, no se mueve.
	 * 
	 * @param direccion
	 */
	public Ocupable decidirMovimiento(Direccion direccion) {
		Casillero casilleroTemp = this.mapa.obtenerCasillero(x, y);
		if (direccion == Direccion.IZQUIERDA && this.x > 0) {
			this.x--;
			casilleroTemp = this.mapa.obtenerCasillero(x, y);
		}
		if (direccion == Direccion.DERECHA && x < this.mapa.getAncho()) {
			this.x++;
			casilleroTemp = this.mapa.obtenerCasillero(x, y);
		}
		if (direccion == Direccion.ARRIBA && y<this.mapa.getAlto()) {
			y++;
			casilleroTemp = this.mapa.obtenerCasillero(x, y);
		}
		if (direccion == Direccion.ABAJO && y>0) {
			y--;
			casilleroTemp = this.mapa.obtenerCasillero(x, y);
		}
		if (casilleroTemp.getClass() == Ocupable.class) {
			return (Ocupable) casilleroTemp;
		} else {
			return (Ocupable) casilleroTemp;
		}

	}

	/**
	 * 
	 * @param casilleroNuevo
	 */
	public void mover(Ocupable casilleroNuevo) {

	}

	/*
	 * Hacer todo: this.pisar(this.mover(this.decirMovimiento(Direccion)));
	 */

	/**
	 * Recibe como parametro un entero y lo asigna a vidas.
	 * 
	 * @param vidas
	 */
	public void setVidasExtras(int vidas) {
		this.vidasExtras = vidas;
	}

	/**
	 * Recibe como parametro un entero y lo asigna a escudos.
	 * 
	 * @param escudos
	 */
	public void setEscudos(int escudos) {
		this.escudos = escudos;
	}

	/**
	 * Devuelve la cantidad de escudos disponibles
	 * 
	 * @return
	 */

	public int getEscudos() {
		return this.escudos;
	}

	/**
	 * Determina si PacSim responde a una explosion con vida o escudo
	 * 
	 * @return
	 */
	public boolean resistir() {
		return (getEscudos() > 0);
	}

	/**
	 * Resta una vida
	 */
	public void restarVida() {
		this.vidasExtras--;
	}

	/**
	 * Resta un escudo
	 */
	public void restarEscudo() {
		this.escudos--;
	}
	@Override
	public String toString() {
		return "PacSim";
	}

	/**
	 * Una ejecucion
	 * 
	 * @param args
	 */
	/*
	 * public static void main(String[] args) { PacSim miPacSim = new PacSim(0, 0);
	 * System.out.println("PacSim NACIÓ" + "\nVidas Extras: " +
	 * miPacSim.getVidasExtras() + "\nEscudos: " + miPacSim.getEscudos());
	 * 
	 * Vitamina primeraVitamina = new Vitamina(1); Escudo primerEscudo = new
	 * Escudo(1); Vitamina segundaVitamina = new Vitamina(2);
	 * 
	 * Botiquin primerBotiquin = new Botiquin(primeraVitamina, primerEscudo); // 1-1
	 * Botiquin segundoBotiquin = new Botiquin(segundaVitamina, null); // 2
	 * primerBotiquin.agregarBotiquin(segundoBotiquin); LinkedList<Equipables>
	 * miLista = new LinkedList<Equipables>(); miLista.add(primeraVitamina);// 1
	 * miLista.add(primerEscudo);// 1 miLista.add(primerBotiquin);// 3-3
	 * 
	 * }
	 */
}
