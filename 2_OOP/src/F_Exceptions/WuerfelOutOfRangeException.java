package F_Exceptions;

public class WuerfelOutOfRangeException  extends NumberFormatException{

	public WuerfelOutOfRangeException() {
		super("Der Wert fuer einen Wuerfel muss zwischen 1 und 6 liegen.");
	}
}
