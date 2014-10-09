package A02_Klassen_Uebung_Wetter;

import java.util.Calendar;
import java.util.Date;

public class Wetter {
    
	//Klassenvariable
    public static int anzahl=0;
	
    //Konstanten
	public static final int SUED = 0;
    public static final int NORD = 1;
    public static final int OST = 2;
    public static final int WEST = 3;
    
    public void setWindrichtung(int windrichtung) {
		if(windrichtung>=0 && windrichtung <4){
			this.windrichtung = windrichtung;
		}
	}


	//Objektvariable
	private int id=0;
    private String ort=null;
    private Date date=null;
    private double temperatur=0;
    private double niederschlagsmenge=0;
    private double regenwahrscheinlichkeit=0;
    private int windrichtung=0;
    private int windstaerke=0; //in bft
       
        
    //Konstruktor mit minimaler Anforderung
    public Wetter(String ort){
    	anzahl++;
    	id=anzahl;
    	this.date = getDate();
    	this.ort = ort;
    }
    
    
    
    
    
    public Wetter(String ort, double temperatur,
			double niederschlagsmenge, double regenwahrscheinlichkeit,
			int windrichtung, int windstaerke) {
		this(ort); //sucht Konstruktor mit Übergabeparameterdatentyp String innerhalb der Klasse
		this.temperatur = temperatur;
		this.niederschlagsmenge = niederschlagsmenge;
		this.regenwahrscheinlichkeit = regenwahrscheinlichkeit;
		this.windrichtung = windrichtung;
		this.windstaerke = windstaerke;
	}
    
    public Wetter(String ort, double temperatur,
			double niederschlagsmenge, double regenwahrscheinlichkeit,
			int windrichtung) {
		this(ort);
		this.temperatur = temperatur;
		this.niederschlagsmenge = niederschlagsmenge;
		this.regenwahrscheinlichkeit = regenwahrscheinlichkeit;
		this.windrichtung = windrichtung;
	}
    
    public Wetter(String ort, double temperatur,
			double niederschlagsmenge, double regenwahrscheinlichkeit) {
		this(ort);
		this.ort = ort;
		this.temperatur = temperatur;
		this.niederschlagsmenge = niederschlagsmenge;
		this.regenwahrscheinlichkeit = regenwahrscheinlichkeit;
	}
    
    public Wetter(String ort, double temperatur,
			double niederschlagsmenge) {
		this(ort);
		this.ort = ort;
		this.temperatur = temperatur;
		this.niederschlagsmenge = niederschlagsmenge;
	}

    public Wetter(String ort, double temperatur) {
		this(ort);
		this.ort = ort;
		this.temperatur = temperatur;
	}


	@Override
	protected void finalize() throws Throwable {
		anzahl--;
	}


	public String getOrt() {
        return ort;
    }


    public double getTemperatur() {
        return temperatur;
    }

    public double getNiederschlagsmenge() {
        return niederschlagsmenge;
    }

    public double getRegenwahrscheinlichkeit() {
        return regenwahrscheinlichkeit;
    }

    public int getWindrichtung() {
        return windrichtung;
    }

    public int getWindstaerke() {
        return windstaerke;
    }

    public Date getDate(){
    	Date date = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime( date );
        //cal.set( Calendar.HOUR_OF_DAY, 0 );
        //cal.set( Calendar.MINUTE, 0 );
        //cal.set( Calendar.SECOND, 0 );
        //cal.set( Calendar.MILLISECOND, 0 );
        //date = cal.getTime();
        return date;
    }








	@Override
	public String toString() {
		return "Wetter [id=" + id + ", ort=" + ort + ", \ndate=" + date
				+ ", \ntemperatur=" + temperatur + ", niederschlagsmenge="
				+ niederschlagsmenge + ", \nregenwahrscheinlichkeit="
				+ regenwahrscheinlichkeit + ", windrichtung=" + windrichtung
				+ ", \nwindstaerke=" + windstaerke + "]"
						+ "\n--------------------------";
	}
    
    

}
