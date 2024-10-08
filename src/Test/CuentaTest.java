package Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Sesion3.Cuenta;

class CuentaTest {
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {		
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testIngresar() {
		Cuenta c = new Cuenta();
		assertEquals(500, c.getSaldo());
	}
	
	@Test
	void testRetirar() {
		Cuenta c = new Cuenta();
		assertEquals(500, c.getSaldo());
	}
		

}
