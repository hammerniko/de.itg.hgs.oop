package Z5_HP2016A3_Ismail_Nikolai;

public abstract class Tabelle {

	Mannschaft inTabZeile[];

	protected int anzahlZeilen;

	public Tabelle() {

	}

	public abstract void berechnePunkte(Mannschaft pMannschaft);

	public void hinzufuegenMannschaft(Mannschaft pMannschaft) {

	}

	public void sortiereTabelle() {

	}

	public Mannschaft gibMannschaftInZeile(int pZeile) {

		return null;
	}
}
