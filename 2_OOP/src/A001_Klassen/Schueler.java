package A001_Klassen;

import java.util.Date;

import javax.swing.JOptionPane;

public class Schueler {
	
	//Objektattribute
	private String name;
	private String vorname;
	private Date gebDatum;
	
	//Klassenattribute
	public static int anzErzeugterSchueler = 0;

	//Konstruktor mit Übergabeparametrn
	//Alle Objektattribute initialisieren
	public Schueler(String name, String vorname) {
		anzErzeugterSchueler++;
		setName(name);
		setVorname(vorname);
		gebDatum = null;
		
	}
	
	//getter und setter
	public void setName(String pName) {
		if(pName.length()>=3) {
			name = pName;
			return;
		}
	}

	public String getVorname() {
		return vorname;
	}

	public void setVorname(String vorname) {
		this.vorname = vorname;
	}

	public Date getGebDatum() {
		return gebDatum;
	}

	public void setGebDatum(Date gebDatum) {
		this.gebDatum = gebDatum;
	}

	public static int getAnzErzeugterSchueler() {
		return anzErzeugterSchueler;
	}

	public static void setAnzErzeugterSchueler(int anzErzeugterSchueler) {
		Schueler.anzErzeugterSchueler = anzErzeugterSchueler;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "Schueler [name=" + name + ", vorname=" + vorname + ", gebDatum=" + gebDatum + "]";
	}
	
	@Override
	protected void finalize() throws Throwable {
		
		System.out.println("Finalize aufgerufen");
		// TODO Auto-generated method stub
		super.finalize();
		anzErzeugterSchueler--;
		
	}
	
}
