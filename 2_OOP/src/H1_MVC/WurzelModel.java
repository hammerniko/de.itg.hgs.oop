/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package H1_MVC;

/**
 * Das Model ist komplett unabhängig von den anderen
 * Klassen und weiß nicht was um ihn herum geschieht.
 * Es ist völlig egal ob man dieses Model aus einem
 * Fenster oder einer Konsolen Eingabe verwendet -
 * beiden würde funktionieren.
 */
public class WurzelModel {

    long value;

    public WurzelModel(){
        zurueckSetzen();
    }

    public void zurueckSetzen(){
        this.value = 0;
    }

    public void berechneWurzel(long wert){
        this.value =  (wert * wert);
    }

    public long getWurzel(){
        return this.value;
    }
}
