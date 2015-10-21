package Proj1_DateiOeffnenUndSpeichern;
 
import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JFileChooser;

public class TextFile {
	JFileChooser fc;
	File file;
	StringBuffer sb;
	String str="";
	
	public TextFile(){
		
	}
	
	public String openTextFile(){
		JFileChooser fc = new JFileChooser();
		int auswahl = fc.showOpenDialog(null);

		if (auswahl == JFileChooser.APPROVE_OPTION) {
			file = fc.getSelectedFile();

			try {
				FileInputStream fis = null;
				BufferedInputStream bis = null;
				DataInputStream dis = null;

				fis = new FileInputStream(file);
				bis = new BufferedInputStream(fis);
				dis = new DataInputStream(bis);
				
				
				sb = new StringBuffer();

				while (dis.available() != 0) {
					//System.out.println(dis.readLine());
					sb.append(dis.readLine());
					
				
				}
				fis.close();
				bis.close();
				dis.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			str = sb.toString();
			
		}
		return str;
	}
	
	public void saveTextFile(){
		JFileChooser fc = new JFileChooser();
		fc.showSaveDialog(null);
		
	}

}
