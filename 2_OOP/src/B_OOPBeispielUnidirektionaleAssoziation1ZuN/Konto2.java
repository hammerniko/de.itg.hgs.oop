package B_OOPBeispielUnidirektionaleAssoziation1ZuN;

public class Konto2 {
	
	private int kontoNr;
	private double saldo;
	
	public Konto2(int kontoNr, double saldo){
		this.kontoNr = kontoNr;
		this.saldo = saldo;
	}

	public int getKontoNr() {
		return kontoNr;
	}

	public void setKontoNr(int kontoNr) {
		this.kontoNr = kontoNr;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	@Override
	public String toString() {
		return "Konto2 [kontoNr=" + kontoNr + ", saldo=" + saldo + "]";
	}

	
}
