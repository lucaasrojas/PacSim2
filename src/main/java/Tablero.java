package main.java;

public class Tablero {
	private int ancho, alto, contador = 0;
	private Casillero[][] tablero;
	private int posicionEntrada,posicionSalida;
	private PacSim miPac;
	
	/*
	 * 0:pidra
	 * 1:comun vacio
	 * 2:comun con mina
	 * 3:comun con vitamina
	 * 4:entrada
	 * 5:salida
	 * 
	 * tablero:
	 * 4,1,1,1,0
	 * 0,2,0,0,0
	 * 0,0,0,0,0
	 * 0,0,0,0,0
	 * 1,1,1,1,1
	 */
	private int []listaDeTodo= {4,1,1,1,0,0,2,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1};
/**
 * Constructor
 * 
 * @param ancho
 * @param alto
 * @param listaMinas
 * @param listaRecursos
 * @param listaDeCasilleros
 */
	public Tablero(int ancho, int alto) {
		this.ancho = ancho;
		this.alto = alto;
		tablero = new Casillero[ancho][alto];
		for (int i = 0; i <this.ancho; i++) {
			for (int j = 0; j < this.alto; j++) {
				if(listaDeTodo[contador]==1) {
					tablero[i][j]=new Pared(contador);
				}
				if(listaDeTodo[contador]==0) {
					tablero[i][j]=new Comun(contador,null);
				}
				if(listaDeTodo[contador]==2) {
					tablero[i][j]=new Entrada(contador);
					this.posicionEntrada=contador;
					miPac=new PacSim(5, this.getEntrada());
					
					posicionEntrada=contador;
				}
				if(listaDeTodo[contador]==3) {
					tablero[i][j]=new Salida(contador);
					posicionSalida=contador;
				}
				if(listaDeTodo[contador]==4) {
					tablero[i][j]=new Salida(contador);
					posicionSalida=contador;
				}
				
				contador++;
			}
		}
	}

	public Casillero[][] obtenerTablero() {
		return tablero;
	}
	/**
	 * Devuelve la posicion de la salida
	 * @return
	 */
	public int getSalida() {
		return this.posicionSalida;
	}
	/**
	 * Devuelve la posicion de la entrada
	 * @return
	 */
	public int getEntrada() {
		return this.posicionEntrada;
	}
	public int getAncho() {
		return this.ancho;
	}
	public int getAlto() {
		return this.alto;
	}
	public Casillero obtenerCasillero(int x, int y) {
		return tablero[x][y];
	}
	public void mostrar() {
		for(int i=0;i<this.alto;i++) {
			for (int j=0;j<this.ancho;j++){
				System.out.print(tablero[i][j].toString()+" ");
			}

			System.out.println(" ");
		}
	}

	public static void main(String []args) {
		Tablero miTablero=new Tablero(5, 5);
		miTablero.mostrar();
	}
}
