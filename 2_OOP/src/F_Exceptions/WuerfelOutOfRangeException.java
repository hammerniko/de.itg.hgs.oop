package F_Exceptions;

public class WuerfelOutOfRangeException  extends NumberFormatException{

	public WuerfelOutOfRangeException() {
		super("Der Wert f�r einen W�rfel muss zwischen 1 und 6 liegen.");
	}
}
