package K1_OOP_Uebung_AssoziationUndVererbung;

public class StartePCBauteile {

	public static void main(String[] args) {
		//Hersteller 
		Hersteller gigabyte = new Hersteller("Gigabyte");
		Hersteller asus = new Hersteller("Asus");
		Hersteller nvidia = new Hersteller("NVidia");
		Hersteller samsung = new Hersteller("Samsung");
		Hersteller msi = new Hersteller("MSI");
		
		//Bauteile
		Grafikkarte g1 = new Grafikkarte(msi,"GTX 980");
		g1.setAnschluesseHDMI(1);
		g1.setAnschluesseDVI(1);
		g1.setAnschluesseDisplayPort(2);
				
		Bauteil g2 = new Grafikkarte(gigabyte, "GTX 1050");
		Bauteil hd1 = new Festplatte(samsung, "850 EVO", 500);
		Bauteil hd2 = new Festplatte(samsung, "850 EVO", 250);
		
		
		//PCs
		PC pc1 = new PC();
		pc1.addBautiel(g1);
		pc1.addBautiel(hd2);
		
		
		
		//Ausgabe
		System.out.println(pc1);
		
		

	}

}
