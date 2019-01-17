import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class PRU04E01_1_Miquel_Fra_alt {

	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new FileReader(args[0]));
			BufferedWriter bw = new BufferedWriter(new FileWriter(args[0]+"_sorted.txt"));
			
			ArrayList<String> paraules = new ArrayList<String>();
			
			String linea = "";
			while (linea != null) {
				linea = br.readLine();
				paraules.add(linea);
			}
			Collections.sort(paraules);
			
			for (int i = 1; i < paraules.size(); i++) {
				bw.write(paraules.get(i));
			}
			br.close();
			bw.close();
		} catch (FileNotFoundException e) {
			System.out.println("No es pot obrir el fitxer.");
		} catch (IOException e) {
			System.out.println("Error d'entrada/sortida.");
		}

	}

}
