package Z5_HP2016A3_Ismail_Nikolai;

public class Tab_2PktRegel extends Tabelle {

	public Tab_2PktRegel() {

	}

	@Override
	public void berechnePunkte(Mannschaft pMannschaft) {

		int pPunkte = (pMannschaft.gibAnzahlSiege() * 2) + pMannschaft.gibAnzahlUnentscheiden();
		pMannschaft.addierePunkte(pPunkte);
	}
}
