package Sesion3;

public class Cuenta {
	
	private double saldo;
	
	public Cuenta() {
		saldo = 0;
	}
	
	public double getSaldo() { return saldo;}
	
	
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}



	public void ingresar(double importe) {
		this.setSaldo(this.getSaldo() + importe);
	}
	
	public void retirar(double importe) {
		this.setSaldo(this.getSaldo() - importe);
	}
}
