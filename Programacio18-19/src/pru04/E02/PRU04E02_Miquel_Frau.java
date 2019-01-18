package pru04.E02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class PRU04E02_Miquel_Frau {
	
	public static String trobarParaula (String linea, int posicio_inicial, int posicio_final) {
		String palabra = "";
		
		for (int i = posicio_inicial; i <= posicio_final;  i++) {
			if (linea.charAt(i) != 32) {
				palabra += linea.charAt(i);
			}
		}
		return palabra;
	}
	public static String escriureParaula(String emp_no, String birth_date, String first_name, String last_name, String gender, String hire_date) {
		String linea_procesada = "";
		return linea_procesada;
	}
	public static void main (String[] args) {
		try {
			BufferedReader br = new BufferedReader(new FileReader(args[0]));
			BufferedWriter bw = new BufferedWriter(new FileWriter(args[1]));
			
			String linea, emp_no, birth_date, first_name, last_name, gender, hire_date;
			
		do {
			linea = br.readLine();
			if (linea != null) {
				
				linea += "";
				
				emp_no = trobarParaula(linea, 1, 7);
				birth_date = trobarParaula(linea, 8, 17);
				first_name = trobarParaula(linea, 18, 28);
				last_name = trobarParaula(linea, 29, 42);
				gender = trobarParaula(linea, 43, 49);
				hire_date = trobarParaula(linea, 50, 59);
				
				
			}
			
		}while (linea != null);
		
		} catch (IOException e) {
			System.out.println("Error lectura/escritura");
		}
	}
}
