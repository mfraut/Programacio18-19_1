package pru03.E04;

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

	public String SumaTemps(int hores, int minuts, int segons) {
		int segons_restar = 0;
		int minuts_afegir = 0;
		int minuts_restar = 0;
		int hores_afegir = 0;
		
		if ((this.segons + segons) > 60) {
			for (int i = (this.segons + segons) / 60; i > 0; i--) {
				segons_restar += 60;
				minuts_afegir += 1;
			}
		}
		if ((this.minuts + minuts + minuts_afegir) > 60) {
			for (int i = (this.minuts + minuts) / 60; i > 0; i--) {
				minuts_restar +=60;
				hores_afegir += 1;
			}
		}
		
		this.segons = this.segons+segons-segons_restar;
		this.minuts = this.minuts+minuts+minuts_afegir-minuts_restar;
		this.hores += this.hores+hores+hores_afegir;
		
		return "La suma d'ambdós temps és: "+this.hores+"h"+this.minuts+"m"+this.segons+"s";
	}
	
	public void RestaTemps(int hores, int minuts, int segons) {
		int segons_afegir = 0;
		int minuts_afegir = 0;
		int minuts_restar = 0;
		int hores_restar = 0;
		
		do {
			if ((this.segons - segons) < 0){
				segons_afegir += 60;
			}
			
		} while ((this.segons - segons + segons_afegir) < 0);
		do {
			if ((this.minuts - minuts) < 0){
				segons_afegir += 60;
			}
			
		} while ((this.segons - segons + segons_afegir) < 0);
		
		
	}
}
