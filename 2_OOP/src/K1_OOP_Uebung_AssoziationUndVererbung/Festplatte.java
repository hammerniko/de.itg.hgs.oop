package K1_OOP_Uebung_AssoziationUndVererbung;

public class Festplatte extends Bauteil {
	
	private int kapazitaet;
	private int einbauArt;
	private int speicherTyp;
	
	public static final int EINBAU_INTERN = 0;
	public static final int EINBAU_EXTERN = 1;
	public static final int SPEICHERTYP_SSD = 0;
	public static final int SPEICHERTYP_SATA = 1;
	public static final int SPEICHERTYP_HYBRID = 2;
	
	
	
	
	public Festplatte(Hersteller h, String bezeichnung, int kapazitaet) {
		super(h,bezeichnung);
		this.kapazitaet=kapazitaet;
		einbauArt = EINBAU_INTERN;
		speicherTyp = SPEICHERTYP_SSD;
	}

}
