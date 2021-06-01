package test.java;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.LinkedList;

import org.junit.Before;
import org.junit.Test;

import main.java.Botiquin;
import main.java.Comun;
import main.java.Equipables;
import main.java.Escudo;
import main.java.Mina;
import main.java.Ocupable;
import main.java.PacSim;
import main.java.Vitamina;

public class PacSimTest {

	PacSim pacSim;
	Vitamina vitamina;
	Escudo escudo;
	Botiquin botiquin1;
	Botiquin botiquin2;
	LinkedList<Equipables> miLista;
	Ocupable casillero;
	Mina mina;

	/**
	 * Se instancia un PacSim con 0 vidas extras y en la posicion 8,una Vitamina con
	 * valor 1, un Escudo con valor 2, dos botiquines uno con 1V y otro con 2E y una
	 * lista de Equipables.
	 */

	@Before
	public void before() {
		System.out.println("\n");
		pacSim = new PacSim(0, 8);
		vitamina = new Vitamina(1);
		escudo = new Escudo(2);
		botiquin1 = new Botiquin(vitamina, null);
		botiquin2 = new Botiquin(null, escudo);
		miLista = new LinkedList<Equipables>();

	}

	@Test(expected = Error.class)
	public void pacSimInstanciadoEnPosicionErronea() {
		System.out.println("Test: pacSimInstanciadoEnPosicionErronea");
		pacSim = new PacSim(0, -10);
		System.out.println("Esto no debe aparecer en la consula.");
	}

	@Test(expected = Error.class)
	public void pacSimInstanciadoConVidasExtrasNegativas() {
		System.out.println("Test: pacSimInstanciadoConVidasExtrasNegativas");
		pacSim = new PacSim(-1, 8);
		System.out.println("Esto no debe aparecer en la consula.");
	}

	@Test
	public void pacSimEstaVivoTieneCeroVidasExtrasEstaEnLaPosicionOchoNoTieneEscudos() {
		System.out.println("Test: pacSimEstaVivoTieneCeroVidasExtrasEstaEnLaPosicionOchoNoTieneEscudos");
		System.out.println("PacSim est· vivo: "+pacSim.estaVivo());
		System.out.println("Vidas extras: "+pacSim.getVidasExtras());
		assertTrue(pacSim.estaVivo());
		assertEquals(0, pacSim.getVidasExtras());
		assertEquals(0, pacSim.getEscudos());
		assertEquals(8, pacSim.getPosicion());
	}

	@Test
	public void pacSimEst·EnUnCasilleroQueCuentaConUnaListaConUnBotiquinConUnaVitaminaQueIncluyeOtroConDosEscudosMasDosEscudos() {
		System.out.println("Test: pacSimEst·EnUnCasilleroQueCuentaConUnaListaConUnBotiquinConUnaVitaminaQueIncluyeOtroConDosEscudosMasDosEscudos");
		System.out.println("Vidas extras: "+pacSim.getVidasExtras());
		System.out.println("Escudos: "+pacSim.getEscudos());
		botiquin1.agregarBotiquin(botiquin2);
		miLista.add(botiquin1);
		miLista.add(escudo);
		casillero = new Comun(8, miLista, null);
		assertTrue(casillero.getPosicion() == pacSim.getPosicion());
		pacSim.pisar(casillero);
		System.out.println("\nPacSim tomÛ los recursos disponibles.");
		assertEquals(1, pacSim.getVidasExtras());
		assertEquals(4, pacSim.getEscudos());
		System.out.println("Vidas extras: "+pacSim.getVidasExtras());
		System.out.println("Escudos: "+pacSim.getEscudos());
	}

	@Test
	public void pacSimEst·EnLaPosicionOchoQueNoCuentaConRecursosIntentaTomarLosDeLaSieteQueSÌTieneNoDebeSurtirEfecto() {
		System.out.println("Test: pacSimEst·EnLaPosicionOchoQueNoCuentaConRecursosIntentaTomarLosDeLaSieteQueSÌTieneNoDebeSurtirEfecto");
		casillero = new Comun(7, botiquin1, null);
		System.out.println("Vidas Extras: "+pacSim.getVidasExtras());
		System.out.println("Escudos: "+pacSim.getEscudos());
		assertTrue(casillero.getPosicion() != pacSim.getPosicion());
		pacSim.pisar(casillero);
		System.out.println("\nIntentÛ tomar los recursos de otra posicion.");
		assertEquals(0, pacSim.getVidasExtras());
		assertEquals(0, pacSim.getEscudos());
		System.out.println("Vidas Extras: "+pacSim.getVidasExtras());
		System.out.println("Escudos: "+pacSim.getEscudos());
	}

	@Test
	public void pacSimEst·EnUnCasilleroQueTieneUnaMinaNoCuentaConVidasExtrasNiEscudosSeEsperaQueMuera() {
		System.out.println("Test: pacSimEst·EnUnCasilleroQueTieneUnaMinaNoCuentaConVidasExtrasNiEscudosSeEsperaQueMuera");
		System.out.println("PacSim est· vivo: "+pacSim.estaVivo());
		System.out.println("Vidas Extras: "+pacSim.getVidasExtras());
		assertTrue(pacSim.estaVivo());
		assertEquals(0, pacSim.getVidasExtras());
		mina = new Mina();
		casillero = new Comun(8, mina);
		pacSim.pisar(casillero);
		System.out.println("Vidas Extras: "+pacSim.getVidasExtras());
		assertEquals(-1, pacSim.getVidasExtras());
		assertFalse(pacSim.estaVivo());
		System.out.println("PacSim est· vivo: "+pacSim.estaVivo());
	}

	@Test
	public void pacSimEst·EnUnCasilleroQueTieneUnaMinaPeroCuentaConUnaVidaExtraNoTieneEscudoSeEsperaQueSobrevivaPeroQuePierdaUnaVida() {
		System.out.println("Test: pacSimEst·EnUnCasilleroQueTieneUnaMinaPeroCuentaConUnaVidaExtraNoTieneEscudoSeEsperaQueSobrevivaPeroQuePierdaUnaVida");
		pacSim.setVidasExtras(1);
		assertEquals(1, pacSim.getVidasExtras());
		System.out.println("Vidas Extras: "+pacSim.getVidasExtras());
		mina = new Mina();
		casillero = new Comun(8, mina);
		pacSim.pisar(casillero);
		assertEquals(0, pacSim.getVidasExtras());
		System.out.println("Esta vivo: "+pacSim.estaVivo());
		assertTrue(pacSim.estaVivo());
	}

	@Test
	public void pacSimEst·EnUnCasilleroQueTieneUnaMinaNoCuentaConVidasExtrasPeroSÌConUnEscudoSeEsperaQueSobrevivaPeroQuePierdaUnEscudo() {
		System.out.println("Test: pacSimEst·EnUnCasilleroQueTieneUnaMinaNoCuentaConVidasExtrasPeroSÌConUnEscudoSeEsperaQueSobrevivaPeroQuePierdaUnEscudo");
		System.out.println("Escudos: "+pacSim.getEscudos());
		assertEquals(0, pacSim.getVidasExtras());
		pacSim.setEscudos(1);
		assertEquals(1, pacSim.getEscudos());
		mina = new Mina();
		casillero = new Comun(8, mina);
		pacSim.pisar(casillero);
		assertEquals(0, pacSim.getEscudos());
		assertTrue(pacSim.estaVivo());
	}

}
