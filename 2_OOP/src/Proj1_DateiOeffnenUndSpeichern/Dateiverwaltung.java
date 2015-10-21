package Proj1_DateiOeffnenUndSpeichern;

import java.io.File;



public interface Dateiverwaltung {
	
	public void openFileClicked(); 
	
	public void saveFileClicked();
	
	public void saveAsFileClicked(File file, String path);

}
