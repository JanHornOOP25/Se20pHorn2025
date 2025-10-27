package anwendungssystem;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
public class AnwendungssystemModel {

	public void schribdateu(String text) throws IOException {
	    BufferedWriter aus = new BufferedWriter(new FileWriter("Text.txt"));
	       	aus.write(text);
	       	aus.close();
		
	}
	
	public String getUeberschrift(){
		 return "Hallo";
		 } 

}
