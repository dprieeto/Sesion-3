package Test;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

import Sesion3.Cuenta;

/**
 * Aqui se realizan las pruebas unitarias de la clase Cuenta
 * para gestionar las transacciones de una cuenta bancaria.
 * @author Prieto
 */
class CuentaTest {
	
private static Cuenta cuenta, c1, c2;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		cuenta = new Cuenta("2038 1234", "Prieto", 1000);
		c1 = new Cuenta("12345", "Paco", 50);
		c2 = new Cuenta("67890", "Pepe", 0);
		System.out.println("->Ejecutando Before all: configuracion antes de todas las pruebas");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		System.out.println("->Ejecutando After all: limpieza despues de todas las pruebas");
	}

	@BeforeEach
	void setUp() throws Exception {
		System.out.println("->Ejecutando Before each: configuracion antes de cada prueba");
	}

	@AfterEach
	void tearDown() throws Exception {
		System.out.println("->Ejecutando After each: limpieza despues de cada prueba");
	}
	
	@Test
	@DisplayName("Ingresar dinero")
	void testIngresar(TestInfo info) {
		System.out.println("Ejecutando prueba: " + info.getTestMethod().get().getName());
		double ingreso = 2500;
		double saldo = cuenta.getSaldo();
		cuenta.ingresar(ingreso);
		saldo += ingreso;
		assertEquals(saldo, cuenta.getSaldo());
	}

	@Test
	@DisplayName("Retirar dinero")
	void testRetirar(TestInfo info) {
		System.out.println("Ejecutando prueba: " + info.getTestMethod().get().getName());
		double retirar = 500;
		double saldo = cuenta.getSaldo();
		cuenta.retirar(retirar);
		saldo -= retirar;
		assertEquals(saldo, cuenta.getSaldo());
	}
	
	@Test
	@DisplayName("Test 0014")
	void testMovimiento(TestInfo info) {
		System.out.println("Ejecutando prueba: " + info.getTestMethod().get().getName());
		assertTrue(c1.retirar(200));
		assertTrue(c2.retirar(350));
		c1.ingresar(100);
		assertFalse(c2.retirar(200));
		assertTrue(c2.retirar(150));
		assertTrue(c1.retirar(200));
		c2.ingresar(50);
		assertFalse(c2.retirar(100));
		System.out.println(c1.toString() + c2.toString());
	}
}
