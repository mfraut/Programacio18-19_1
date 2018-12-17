package pru03.E05;

public class PRU03E05PizzaTest_Miquel_Frau {

	public static void main(String[] args) throws Exception {
		PRU03E05Pizza_Miquel_Frau p1 = new PRU03E05Pizza_Miquel_Frau("margarita", "mitjana");
		PRU03E05Pizza_Miquel_Frau p2 = new PRU03E05Pizza_Miquel_Frau("funghi", "familiar");
		PRU03E05Pizza_Miquel_Frau p3 = new PRU03E05Pizza_Miquel_Frau("quatre formatges", "mitjana");

		System.out.println(p1);
		System.out.println(p2);
		System.out.println(p3);

		p1.Servir();
		p1.Servir();
		p2.Servir();

		System.out.println(p1);
		System.out.println(p2);
		System.out.println(p3);

		System.out.println("Demanades: " + PRU03E05Pizza_Miquel_Frau.getTotalDemanades());
		System.out.println("Servides: " + PRU03E05Pizza_Miquel_Frau.getTotalServides());

	}

}
