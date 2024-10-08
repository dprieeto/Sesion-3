package Sesion3;

import java.util.ArrayList;
import java.util.List;

import Sesion3.Movimiento.Signo;

/**
 * Clase utilizada para la gestion de la cuenta de un cliente de un banco.
 * @author Prieto
 */
public class Cuenta {
	
	private String numero, titular;
	private double saldo;
	private final double saldo_inicial;
	private List<Movimiento> mMovimiento;
	private List<String> errores;

	/**
	 * Constructor de la clase. Inicializa las variables.
	 * @param numero
	 * @param titular
	 * @param saldo
	 */
	public Cuenta(String numero, String titular, double saldo) {
		super();
		this.numero = numero;
		this.titular = titular;
		this.saldo = this.saldo_inicial = saldo;
		this.mMovimiento = new ArrayList<>();
		this.errores = new ArrayList<String>();
	}

	/**
	 * @return el numero de cuenta.
	 */
	public String getNumero() {
		return numero;
	}

	/**
	 * @param numero. Modifica el numero de cuenta.
	 */
	public void setNumero(String numero) {
		this.numero = numero;
	}

	/**
	 * @return titular. Nombre del titular de la cuenta.
	 */
	public String getTitular() {
		return titular;
	}

	/**
	 * @param titular. Modifica el titular de la cuenta.
	 */
	public void setTitular(String titular) {
		this.titular = titular;
	}

	/**
	 * @return saldo. Saldo actual de la cuenta.
	 */
	public double getSaldo() {
		return saldo;
	}

	/**
	 * @param saldo. Modifica el saldo actual de la cuenta.
	 */
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
	/**
	 * @return the mMovimiento
	 */
	public List<Movimiento> getmMovimiento() {
		return mMovimiento;
	}

	/**
	 * @param mMovimiento the mMovimiento to set
	 */
	public void setmMovimiento(List<Movimiento> mMovimiento) {
		this.mMovimiento = mMovimiento;
	}

	/**
	 * Ingresa dinero y actualiza la cuenta del cliente.
	 * @param importex
	 */
	public void ingresar(double importe) {
		this.setSaldo( importe + this.getSaldo());
		this.mMovimiento.add(new Movimiento(importe, "Ingreso", Signo.H));
	}
	
	/**
	 
	 * @param importe
	 */
	/**
	 * * Retira dinero y actualiza la cuenta del cliente.
	 * @param importe
	 * @return true si permite hacer el reintegro, false en caso contrario
	 */
	public boolean retirar(double importe) {
		boolean correcto = false;
		if(permiteDescubierto(importe)) {
			this.setSaldo(this.getSaldo() - importe);
			this.mMovimiento.add(new Movimiento(importe, "Reintegro", Signo.D));
			correcto = true;
		} else {
			errores.add("\nTransaccion denegada: Reintegro de " + importe + "€");
		}
		return correcto;		
	}
	
	/**
	 * Verifica si se puede hacer un reintegro siempre que el saldo final sea menor a -500€.
	 * Devuelve true si se puede hacer el reintegro, false en caso contrario.
	 * @param reintegro
	 * @return
	 */
	private boolean permiteDescubierto(double reintegro) {
		boolean permitir = false;
		if(this.getSaldo() - reintegro >= -500)
			permitir = true;
		return permitir;
	}

	@Override
	public String toString() {
		String s = "\n##########################" + "\n-Cuenta: " + this.numero + "\nSaldo inicial: "+ this.saldo_inicial + "€";
		for(int i = 0; i < mMovimiento.size(); i++) {
			s += mMovimiento.get(i).toString();
		}
		for(int i = 0; i < errores.size(); i++) {
			s += errores.get(i).toString();
		}
		s += "\nSaldo final: " + this.getSaldo() + "€";
		return s;
	}	
}
