package pru03.E04;

import java.util.Scanner;

public class PRU03E04Temps_Miquel_Frau {
	int hores;
	int minuts;
	int segons;

	public PRU03E04Temps_Miquel_Frau(int hores, int minuts, int segons) {
		this.hores = hores;
		this.minuts = minuts;
		this.segons = segons;
	}

	@Override
	public String toString() {
		String temps = hores + "h" + minuts + "m" + segons + "s";
		return temps;
	}

	public String SumaTemps() {
		int hores;
		int minuts;
		int segons;
		int segons_restar = 0;
		int minuts_afegir = 0;
		int minuts_restar = 0;
		int hores_afegir = 0;

		Scanner sc = new Scanner(System.in);
		System.out.println("Introdueix les hores a sumar (en cas de no voler sumar cap hora, introduir un 0)");
		hores = sc.nextInt();
		System.out.println("Introdueix els minuts a sumar (en cas de no voler sumar cap minut, introduir un 0)");
		minuts = sc.nextInt();
		System.out.println("Introdueix els segons a sumar (en cas de no voler sumar cap segon, introduir un 0)");
		segons = sc.nextInt();
		if ((this.segons + segons) >= 60) {
			for (int i = (this.segons + segons) / 60; i > 0; i--) {
				segons_restar += 60;
				minuts_afegir += 1;
			}
		}
		if ((this.minuts + minuts + minuts_afegir) >= 60) {
			for (int i = (this.minuts + minuts) / 60; i > 0; i--) {
				minuts_restar += 60;
				hores_afegir += 1;
			}
		}

		this.segons = this.segons + segons - segons_restar;
		this.minuts = this.minuts + minuts + minuts_afegir - minuts_restar;
		this.hores = this.hores + hores + hores_afegir;

		return "La suma d'ambdós temps és: " + this.hores + "h" + this.minuts + "m" + this.segons + "s";
	}

	public String RestaTemps() {
		int hores;
		int minuts;
		int segons;
		int segons_afegir = 0;
		int minuts_afegir = 0;
		int minuts_restar = 0;
		int hores_restar = 0;

		Scanner sc_resta = new Scanner(System.in);
		System.out.println("Introdueix les hores a restar (en cas de no voler restar cap hora, introduir un 0)");
		hores = sc_resta.nextInt();
		System.out.println("Introdueix els minuts a restar (en cas de no voler restar cap minut, introduir un 0)");
		minuts = sc_resta.nextInt();
		System.out.println("Introdueix els segons a restar (en cas de no voler restar cap segon, introduir un 0)");
		segons = sc_resta.nextInt();

		do {
			if ((this.segons - segons) < 0) {
				segons_afegir += 60;
				minuts_restar += 1;
			}

		} while ((this.segons - segons + segons_afegir) < 0);
		do {
			if ((this.minuts - minuts) < 0) {
				minuts_afegir += 60;
				hores_restar += 1;
			}

		} while (((this.minuts - minuts - minuts_restar) + minuts_afegir) < 0);

		this.segons = this.segons - segons + segons_afegir;
		this.minuts = this.minuts - minuts - minuts_restar + minuts_afegir;
		this.hores = this.hores - hores - hores_restar;

		return "La resta d'ambdós temps és: " + this.hores + "h" + this.minuts + "m" + this.segons + "s";
	}
}
