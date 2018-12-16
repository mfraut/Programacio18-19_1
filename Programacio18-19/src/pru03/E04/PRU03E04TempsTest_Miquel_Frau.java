package pru03.E04;

public class PRU03E04TempsTest_Miquel_Frau {

	public static void main(String[] args) {
		PRU03E04Temps_Miquel_Frau temps1 = new PRU03E04Temps_Miquel_Frau(1, 30, 30);
		PRU03E04Temps_Miquel_Frau temps2 = new PRU03E04Temps_Miquel_Frau(2, 30, 45);
		
		System.out.println(temps1.toString());
		System.out.println(temps2.toString());
		
		System.out.println(temps1.SumaTemps(temps2.hores, temps2.minuts, temps2.segons));
	}

}
