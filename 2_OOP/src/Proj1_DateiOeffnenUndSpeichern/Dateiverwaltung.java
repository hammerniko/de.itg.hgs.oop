package Proj1_DateiOeffnenUndSpeichern;

import java.io.File;



public interface Dateiverwaltung {
	
	public File openFile(File file);
	
	public void saveFile(File file);
	
	public void saveAsFile(File file, String path);

}
