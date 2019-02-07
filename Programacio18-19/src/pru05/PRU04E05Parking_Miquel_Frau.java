package pru05;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class PRU04E05Parking_Miquel_Frau {
		
		protected final int places_no_discapacitats_constant;
		protected final int places_discapacitats_constant;
		protected int places_no_discapacitats;
		protected int places_discapacitats;
		protected HashMap<Integer, String> parking = new HashMap<Integer, String>(100);
	
		public PRU04E05Parking_Miquel_Frau (int places_no_discapacitats, int places_discapacitats) {
			this.places_discapacitats_constant = places_discapacitats;
			this.places_no_discapacitats_constant = places_no_discapacitats;
			this.places_discapacitats = places_discapacitats;
			this.places_no_discapacitats = places_no_discapacitats;
		}
		
		public void llegirMatricules(String path) throws Exception{
			Scanner sc_llegirMatricules = new Scanner(System.in);
			String opcio;
			String new_ruta;
			String opcio_new_ruta;
			try {
				DataInputStream file_reader = new DataInputStream(new FileInputStream(path));
				
			}
			catch (FileNotFoundException e){
				System.out.print(System.getProperty("line.separator")+"No s'ha trobat l'arxiu indicat als paràmetres.");
				boolean repetir = true;
				do {
					System.out.println(" Vols especificar una ruta fixa? (S/N)");
					opcio = sc_llegirMatricules.nextLine();
					if (opcio.equals("S")) {
						boolean repetir_newRoute = true;
						do {
							System.out.println("Per favor, introdueix la ruta en qüestió.");
							new_ruta = sc_llegirMatricules.nextLine();
							try {
								DataInputStream file_reader = new DataInputStream(new FileInputStream(new_ruta));
							}
							catch (FileNotFoundException a) {
								boolean repetir_newRouteConfirmacion = true;
								do {
								System.out.println("La ruta que has introduit manualment("+new_ruta+") no s'ha trobat. Vols tornar a introduir-la? (S/N)");
								opcio_new_ruta = sc_llegirMatricules.nextLine();
								if (opcio_new_ruta.equals("S")) {
									repetir_newRouteConfirmacion = false;
								}
								else if (opcio_new_ruta.equals("N")) {
									System.out.println("D'acord. Tornant al menú principal.");
									repetir = false;
									repetir_newRoute = false;
									repetir_newRouteConfirmacion = false;
								}
								else {
									System.out.println("No has introduit cap opció correcta. Has d'introduir \"S\" o \"N\"");
								}
								} while (repetir_newRouteConfirmacion);
								
							}
					}	while (repetir_newRoute);
				}
					else if (opcio.equals("N")) {
						System.out.println("D'acord. Tornant al menú principal.");
						repetir = false;
					}
					else {
						System.out.println("No has introduit cap opció correcta. Has d'introduir \"S\" o \"N\"");
					}
				} while (repetir); 
			}
			catch (IndexOutOfBoundsException a) {
				System.out.println("No has introduit cap argument. ");
			}
		}
		
		public int entraCotxe(String matricula) throws Exception{
			
			if (comprovarMatricula(matricula)) {
				parking.put(this.places_discapacitats_constant, matricula);
			}
			
		}
		
		public int entraCotxeDiscapacitat(String matricula) throws Exception{
			
		}
		
		public void surtCotxe(String matricula) throws Exception{
			
		}
		
		public void surtCotxeDiscapacitat(String matricula) throws Exception{
			
		}
		
		public int getPlacesOcupades(TipusPlacesParking tipus) {
			
		}
		
		public int getPlacesLliures(TipusPlacesParking tipus) {
			
		}
		
		public void guardarMatricules(String path) throws Exception{
			
		}
		
		private boolean comprovarMatricula(String matricula) {
			
			boolean matricula_comprobada = true;
			
			try {
				int[] matricula_numeros = new int[4];
				char[] matricula_letras = new char[3];
				
				
				for (int i = 0; i<matricula_numeros.length; i++) {
					String matricula_numeros_char="";
					matricula_numeros_char += matricula.charAt(i);
					matricula_numeros[i] = Integer.parseInt(matricula_numeros_char);
				}

				for (int i = matricula_numeros.length; i<matricula.length(); i++) {
					matricula_letras[i-(matricula_numeros.length)] = matricula.charAt(i); 
				}
			}
			catch(NumberFormatException e) {
				
				System.out.println("La matrícula no és correcta (no compleix el format 0000AAA)");
				matricula_comprobada = false;
				
			}
			catch (ArrayIndexOutOfBoundsException r) {
				
				System.out.println("La matrícula no és correcta (hi ha més digits dels que el format indica (format: 0000AAA))");
				matricula_comprobada = false;
				
			}
			
			return matricula_comprobada;
			
		}
		
		public static void main(String[] args) throws Exception {
			Scanner sc = new Scanner(System.in);
			PRU04E05Parking_Miquel_Frau parking = new PRU04E05Parking_Miquel_Frau(100, 5);
			
			boolean repeat_main = true;
			String matricula;
			int option;
			
			System.out.print("Benvingut a ParkingManager V.1.0.");
			do {
				
				System.out.print(" Per favor, trii una de les següents opcions introduint el nombre en qüestió de la opció.\n");
				System.out.println("1. Omplir parking a partir de fitxer.\n2. Entrar Cotxe.\n3. Entrar Cotxe Discapacitat.\n4. Sortir Cotxe.\n5. Sortir Cotxe Discapacitat.");
				System.out.println("6. Guardar llistat de matricules en fitxer.\n7. Sortir.");
				option = sc.nextInt();
				
				switch(option) {
					case 1: 
						parking.llegirMatricules(args[0]);
					break;
					case 2:
						
						boolean repetir_entrada_cotxe = true;
						do {
							
						} while(repetir_entrada_cotxe);
						
					case 3:
					case 4:
					case 5:
					case 6:
					case 7: 
						System.out.println("Gràcies per emprar ParkingManager V.1.0. ");
						repeat_main = false;
						break;
							
					default: System.out.println("No has introduit cap opció correcta. "); 
				}
				
			} while (repeat_main);
		

	}

}
