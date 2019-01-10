package pru03Lectura_escritura;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
public class Pars {

	public static void main(String[] args) {
		try {
			BufferedReader br_pars = new BufferedReader(new FileReader("C:\\Temp\\pars.dat"));
			BufferedReader br_senars = new BufferedReader(new FileReader("C:\\Temp\\senars.dat"));
			BufferedWriter bw_pars = new BufferedWriter(new FileWriter("C:\\Temp\\pars.dat"));
			BufferedWriter bw_senars = new BufferedWriter(new FileWriter("C:\\Temp\\senars.dat"));
			BufferedWriter bw_tots = new BufferedWriter(new FileWriter("C:\\Temp\\tots.dat"));
			
			String llegir_pars = "";
			String llegir_senars = "";
			
			for (int i = 0; i<=500; i++) {
				if (i%2 == 0) {
					llegir_pars = br_pars.readLine();
					bw_tots.write(llegir_pars);
				}
				if (i%2 == 1) {
					llegir_senars = br_senars.readLine();
					bw_tots.write(llegir_senars);
				}
			}
			br_pars.close();
			br_senars.close();
			bw_pars.close();
			bw_senars.close();
			bw_tots.close();
			
		} catch (IOException e) {
			System.out.println("No s'ha pogut obrir el fitxer");
		} 

	}

}
