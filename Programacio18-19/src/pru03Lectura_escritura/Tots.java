package pru03Lectura_escritura;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
public class Tots {

	public static void main(String[] args) {
		try {
			BufferedReader br_pars = new BufferedReader(new FileReader(args[0]));
			BufferedReader br_senars = new BufferedReader(new FileReader(args[1]));
			BufferedWriter bw_tots = new BufferedWriter(new FileWriter(args[2]));
			System.out.println(args[0]+ args[1]+ args[2]);
			String llegir_pars = "";
			String llegir_senars = "";
			
			int contador = 1;
			while (contador <= 500) {
				if ((contador%2) == 0) {
					llegir_pars = br_pars.readLine();
					bw_tots.write(llegir_pars+"\n");
				}
				if ((contador%2) != 0) {
					llegir_senars = br_senars.readLine();
					bw_tots.write(llegir_senars+"\n");
				}
				contador++;
			}
			br_pars.close();
			br_senars.close();
			bw_tots.close();
			
		} catch (IOException e) {
			System.out.println("No s'ha pogut obrir el fitxer");
		} 

	}

}
