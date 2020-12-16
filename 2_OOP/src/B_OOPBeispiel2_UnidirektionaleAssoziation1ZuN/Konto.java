package B_OOPBeispiel2_UnidirektionaleAssoziation1ZuN;

public class Konto {
	
	private int kontoNr;
	private double saldo;
	
	public Konto(int kontoNr, double saldo){
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
	
	public void abheben(double betrag){
		saldo = saldo -betrag;
	}
	
	public void einzahlen(double betrag){
		saldo = saldo + betrag;
	}

	@Override
	public String toString() {
		return "Konto2 [kontoNr=" + kontoNr + ", saldo=" + saldo + "]";
	}

	
}
