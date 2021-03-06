package C1_BidirektionaleAssoziation_n_m_DAO_Pattern;

public class Bewertung {
	
	int schuelerNr;
	int fachNr;
	
	double note;
	double gewichtung;
	
	public Bewertung(int schuelerNr, int fachNr, double note, double gewichtung) {
	    super();
	    this.schuelerNr = schuelerNr;
	    this.fachNr = fachNr;
	    this.note = note;
	    this.gewichtung = gewichtung;
    }

	@Override
	public String toString() {
		return "Bewertung [schuelerNr=" + schuelerNr + ", fachNr=" + fachNr
				+ ", note=" + note + ", gewichtung=" + gewichtung + "]";
	}
	
	
	
	
}
