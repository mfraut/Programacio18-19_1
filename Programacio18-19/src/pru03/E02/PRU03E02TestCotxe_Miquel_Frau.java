package pru03.E02;

public class PRU03E02TestCotxe_Miquel_Frau {

	public static void main(String[] args) throws Exception {
		PRU03E02Cotxe_Miquel_Frau cotxe1= new PRU03E02Cotxe_Miquel_Frau("Toyota", "Yaris", TipusCanvi.CanviManual);
		PRU03E02Cotxe_Miquel_Frau cotxe2= new PRU03E02Cotxe_Miquel_Frau("Lexus", "CT200h", TipusCanvi.CanviAutomatic);
		
		System.out.println(cotxe1.marca +"\t"+cotxe1.model+"\t"+cotxe1.tipuscanvi);
		System.out.println(cotxe2.marca +"\t"+cotxe2.model+"\t"+cotxe2.tipuscanvi);
		
		cotxe1.arrancarMotor();
		System.out.println(cotxe1.comprovaMotor());
		System.out.println("Vas a "+cotxe1.getRevolucions()+" revolucions.");
		
		cotxe2.arrancarMotor();
		

		

	}

}
