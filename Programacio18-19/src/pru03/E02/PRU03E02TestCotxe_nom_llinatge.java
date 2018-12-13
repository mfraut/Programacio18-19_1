package pru03.E02;

public class PRU03E02TestCotxe_nom_llinatge {

	public static void main(String[] args) throws Exception {
		PRU03E02Cotxe_nom_llinatge cotxe1= new PRU03E02Cotxe_nom_llinatge("toiota", "iaris", TipusCanvi.CanviManual);
		PRU03E02Cotxe_nom_llinatge cotxe2= new PRU03E02Cotxe_nom_llinatge("brom", "bram", TipusCanvi.CanviAutomatic);
		
		System.out.println(cotxe1.marca +"\t"+cotxe1.model+"\t"+cotxe1.tipuscanvi);
		System.out.println(cotxe2.marca +"\t"+cotxe2.model+"\t"+cotxe2.tipuscanvi);
		
		cotxe1.arrancarMotor();
		System.out.println(cotxe1.comprovaMotor());
		int revolutions = cotxe1.getRevolucions();
		if (revolutions < 2000) {
			System.out.println("Vas to lento pavo");
		}
		else {
			System.out.println("Vas to rapido loco te me vas a matar");
		}
		cotxe1.aturarMotor();
		
		cotxe2.arrancarMotor();
		cotxe2.arrancarMotor();
		
		

	}

}
