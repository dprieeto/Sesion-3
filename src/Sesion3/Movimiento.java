package Sesion3;

import Sesion3.Movimiento.Signo;

/**
 * Esta clase gestiona los movimientos de la cuenta del banco de un cliente.
 * @author Prieto
 */
public class Movimiento {

	/**
	 * Importe de la transaccion en la cuenta.
	 */
	private double importe;
	/**
	 * Tipo transaccion bancaria.
	 * D es un cargo en la cuenta.
	 * H un ingreso en la cuenta.
	 */
	public enum Signo { // publica para que pueda usarse fuera de la clase.
		D,
		H;
	}
	
	private Signo signo;
	
	/**
	 * Concepto de la retirada/ingreso del dinero.
	 */
	private String detalle;
	
	/**
	 * Constructor de la clase. Inicializa los atributos de la clase.
	 * @param importe
	 * @param detalle
	 * @param signo
	 */
	public Movimiento(double importe, String detalle, Signo signo) {
		super();
		this.importe = importe;
		this.detalle = detalle;
		this.signo = signo;
	}

	/**
	 * @return the importe. Devuelve el importe de la transaccion.
	 */
	public double getImporte() {
		return importe;
	}

	/**
	 * @param importe. Añade el importe de la transaccion.
	 */
	public void setImporte(double importe) {
		this.importe = importe;
	}

	/**
	 * @return the detalle. Devuelve el concepto de la transaccion.
	 */
	public String getDetalle() {
		return detalle;
	}

	/**
	 * @param detalle. Añade el concepto de la transaccion.
	 */
	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}
	
	/**
	 * @return the signo. Devuelve si es un ingreso o un reintegro.
	 */
	public Signo getSigno() {
		return signo;
	}

	/**
	 * @param signo. Modifica el signo de la transaccion.
	 */
	public void setSigno(Signo signo) {
		this.signo = signo;
	}

	@Override
	public String toString() {
		String s = "\n" + this.detalle + " de " + this.importe + "€";
		return s;
	}	
}
