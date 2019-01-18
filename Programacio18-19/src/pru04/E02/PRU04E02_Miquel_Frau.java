package pru04.E02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class PRU04E02_Miquel_Frau {
	
	//Mètode que circula per la linea i agafa el que es troba entre les dues posicions donades.
	
	public static String trobarParaula (String linea, int posicio_inicial, int posicio_final) {
		String palabra = "";
		
		for (int i = posicio_inicial; i <= posicio_final;  i++) {
			if (linea.charAt(i) != 32) {
				palabra += linea.charAt(i);
			}
		}
		return palabra;
	}
	
	//Mètode que escriu a l'arxiu final la linea separada per ";" i amb un espai al final.
	
	
	public static String escriureLinea(String emp_no, String birth_date, String first_name, String last_name, String gender, String hire_date) {
		String linea_procesada = "";
		String separador = ";";
		String espacio = "\n";
		linea_procesada = emp_no+separador+birth_date+separador+first_name+separador+last_name+separador+gender+separador+hire_date+espacio;
		return linea_procesada;
	}
	public static void main (String[] args) {
		try {
			BufferedReader br = new BufferedReader(new FileReader(args[0]));
			BufferedWriter bw = new BufferedWriter(new FileWriter(args[1]));
			
			String linea, emp_no, birth_date, first_name, last_name, gender, hire_date;
			
			//Revisa la lin
		do {
			linea = br.readLine();
			if (linea != null) {
				
				linea += "";
				
				emp_no = trobarParaula(linea, 0, 5);
				birth_date = trobarParaula(linea, 6, 15);
				first_name = trobarParaula(linea, 16, 26);
				last_name = trobarParaula(linea, 27, 40);
				gender = trobarParaula(linea, 41, 47);
				hire_date = trobarParaula(linea, 48, 57);
				
				bw.write(escriureLinea(emp_no, birth_date, first_name, last_name, gender, hire_date));
				
				
			}
			
		}while (linea != null);
		
		br.close();
		bw.close();
		
		} catch (IOException e) {
			System.out.println("Error lectura/escritura");
		}
	}
}
