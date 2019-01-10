package pru03Lectura_escritura;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
public class Senars {

	public static void main(String[] args) {
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Temp\\senars.dat"));
			
			for (int i = 1; i<500; i = i +2) {
				bw.write(i+"\n");
			}
			bw.close();
		} catch (IOException e) {
			System.out.println("No s'ha pogut obrir el fitxer");
		} 

	}

}
