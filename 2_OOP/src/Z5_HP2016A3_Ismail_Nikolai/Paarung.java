package Z5_HP2016A3_Ismail_Nikolai;

public class Paarung {

	private int index_M1;
	private int index_M2;
	private int tore_M1;
	private int tore_M2;

	public Paarung(int pIndex_M1, int pIndex_M2) {

		index_M1 = pIndex_M1;
		index_M2 = pIndex_M2;
	}

	public void eintragenErgebnis(int pTore_M1, int pTore_M2) {

		tore_M1 = pTore_M1;
		tore_M2 = pTore_M2;
	}

	public int gibIndex_Mx(int x) {

		if (x == 1) {
			return index_M1;
		} else if (x == 2) {
			return index_M2;
		} else {
			return x;
		}
	}

	public int gibTore_Mx(int x) {

		if (x == 1) {
			return tore_M1;
		} else if (x == 2) {
			return tore_M2;
		} else {
			return x;
		}
	}
}
