package pru03.E05;

public class PRU03E05Pizza_Miquel_Frau {
	/*
	 * Se creen variables est�tiques per a emmagatzemar la quantitat de pizzes
	 * demanades i servides. A m�s d'aix�, es creen els atributs corresponents a
	 * cada pizza.
	 */
	public static int demanades = 0;
	public static int servides = 0;
	String mida;
	String tipus;
	String estat;

//	Constructor de dos par�metres (tipus i mida) que comprova que el valor que se li ha donat estigui dins dels par�metres corresponents. A 	m�s d'aix�, s'inicitalitza la pizza com a demanada i s'augmenta en 1 la quantitat de pizzes demanades.
	
	public PRU03E05Pizza_Miquel_Frau(String tipus, String mida) throws Exception {
		if (tipus.equals("margarita") || tipus.equals("funghi") || tipus.equals("quatre formatges")) {
			this.tipus = tipus;
		} else {
			throw new Exception("No has introdu�t cap tipus correcte");
		}
		if (mida.equals("familiar") || mida.equals("mitjana")) {
			this.mida = mida;
		} else {
			throw new Exception("No has introdu�t cap mida correcta");
		}

		this.estat = "demanada";
		demanades++;

	}

	@Override
	public String toString() {
		return "Pizza " + this.mida + " " + this.tipus + ". Aquesta pizza est� " + this.estat;
	}
//	M�tode que verifica si la pizza ja s'ha servit o encara est� demanada. Si no s'havia servit encara, canvia l'estat de la pizza a servida i 	resta un al valor que controla la quantitat de pizzes servides, ja que s'assumeix que quan una pizza que est� demanada ja es serveix, 	s'elimina de la llista de pizzes demanades per no crear confusi� al personal del restaurant
	public void Servir() {
		if (this.estat.equals("demanada")) {
			this.estat = "servida";
			servides++;
			demanades--;
			System.out.println("S'ha servit la pizza " + this.tipus + " " + this.mida);
		} else {
			System.out.println("Aquesta pizza ja est� servida.");
		}
	}

	public static int getTotalDemanades() {
		return demanades;
	}

	public static int getTotalServides() {
		return servides;
	}
}
