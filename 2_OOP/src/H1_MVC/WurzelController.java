package H1_MVC;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * Der Controller muss die View und das Model kennen
 * da dieser für die Kommunikation zwischen den Beiden sorgt
 */
public class WurzelController {

    private WurzelView dieGuiKomponente;
    private WurzelModel dasModel;

    public WurzelController(WurzelView view, WurzelModel model){
        this.dasModel = model;
        this.dieGuiKomponente = view;

        addListener();
    }

    /**
     * Die Listener, die wir aus den Internen Klassen generieren
     * werden der View bekannt gemacht, sodass diese mit
     * uns (dem Controller) kommunizieren kann
     */
    private void addListener(){
        dieGuiKomponente.setWurzelBerechnenListener(new WurzelBerechnenListener());
        dieGuiKomponente.setResetFormListener(new ResetFormListener());
    }

    /**
     * Inneren Listener Klassen implementieren das Interface ActionListener
     *
     * 1: Hier wird erst der eingegebene Wert aus der View geholt
     * 2: Der Wert wird dem Model übergeben und die Wurzel berechnet
     * 3: Die berechnete Wurzel wird aus dem Model geladen und
     * 4: Wieder der View zum Darstellen übergeben
     *
     * ACHTUNG: Fehlerprüfung muss noch implementiert werden
     */
    class WurzelBerechnenListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
        	
        	//hole Wert von der Gui
            long wert = Long.valueOf(dieGuiKomponente.getEingabe());
            
            //Gebe den Wert an das Model und rechne damit
            dasModel.berechneWurzel(wert);
            
            //lade das Ergebnis vom Model und zeige das Ergebnis in der View
            dieGuiKomponente.setErgebnis(String.valueOf(dasModel.getWurzel()));
        }
    }

    /**
     * Hier wird dem View und dem Model gesagt ihre gespeicherten
     * Werte zu löschen.
     */
    class ResetFormListener implements ActionListener{
    	
        public void actionPerformed(ActionEvent e) {
            dieGuiKomponente.resetView();


            dasModel.zurueckSetzen();


          

        }
    }
}
