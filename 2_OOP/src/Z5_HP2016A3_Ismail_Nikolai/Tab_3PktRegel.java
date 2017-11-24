package Z5_HP2016A3_Ismail_Nikolai;

public class Tab_3PktRegel extends Tabelle {

	public Tab_3PktRegel() {

	}

	@Override
	public void berechnePunkte(Mannschaft pMannschaft) {
		
		int pPunkte = (pMannschaft.gibAnzahlSiege() * 3) + pMannschaft.gibAnzahlUnentscheiden();
		pMannschaft.addierePunkte(pPunkte);
	}
}
