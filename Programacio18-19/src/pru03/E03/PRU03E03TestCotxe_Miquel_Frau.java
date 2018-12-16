package pru03.E03;
//import java.util.Scanner;

public class PRU03E03TestCotxe_Miquel_Frau {
	
	public static void main(String[] args) throws Exception {
		PRU03E03Cotxe_Miquel_Frau cotxe1= new PRU03E03Cotxe_Miquel_Frau("Toyota", "Yaris", TipusCanvi.CanviManual);
		PRU03E03Cotxe_Miquel_Frau cotxe2= new PRU03E03Cotxe_Miquel_Frau("Lexus", "CT200h", TipusCanvi.CanviAutomatic);
		
		System.out.println(cotxe1.marca +"\t"+cotxe1.model+"\t"+cotxe1.tipuscanvi);
		System.out.println(cotxe2.marca +"\t"+cotxe2.model+"\t"+cotxe2.tipuscanvi);
		
		cotxe1.arrancarMotor();
		System.out.println(cotxe1.comprovaMotor());
		System.out.println("Vas a "+cotxe1.getRevolucions()+" revolucions.");
		
		cotxe2.arrancarMotor();
		
		cotxe2.PujarMarxaAutomatic();
		System.out.println(cotxe2.getMarxaAutomatic());
		cotxe2.BaixarMarxaAutomatic();
		System.out.println(cotxe2.getMarxaAutomatic());
		
		for (int i = 0; i<5; i++){
			cotxe1.PujarMarxaManual();
		}
		
		System.out.println(cotxe1.getMarxaManual());
		
		for (int i = 5; i>0; i--){
			cotxe1.BaixarMarxaManual();
		}
		System.out.println(cotxe1.getMarxaManual());
		
	}

}
