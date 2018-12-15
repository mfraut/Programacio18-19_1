package pru03.E03;

public class PRU03E03Cotxe_Miquel_Frau extends CotxeAbstracte implements InterfaceCotxe {
	EstatsMotorCotxe motor = EstatsMotorCotxe.Aturat;
	private CanviarMarxaAutomatic marxa_auto;
	private CanviarMarxaManual marxa_manual;

	public PRU03E03Cotxe_Miquel_Frau(String marca, String model, TipusCanvi tipuscanvi) {
		super(marca, model, tipuscanvi);
		if (tipuscanvi.equals(TipusCanvi.CanviAutomatic)) {
			this.marxa_auto = CanviarMarxaAutomatic.N;
		}
		if (tipuscanvi.equals(TipusCanvi.CanviManual)) {
			this.marxa_manual = CanviarMarxaManual.PRIMERA;
		}
		this.marca = marca;
		this.model = model;
		this.tipuscanvi = tipuscanvi;
		
		String[] marxes_automatic = {"R", "N", "F"};
		String[] marxes_manual = {"Primera", "Segona", "Tercera", "Quarta", "Cinquena", "Sexta", "R"};
	}

	public void arrancarMotor() throws Exception {
		if (comprovaMotor().equals(EstatsMotorCotxe.EnMarxa)) {
			throw new Exception("El motor ja està encés");
		} else {
			System.out.println("S'encén el cotxe");
			this.motor = EstatsMotorCotxe.EnMarxa;
		}
	}

	public EstatsMotorCotxe comprovaMotor() {
		return this.motor;
	}

	public int getRevolucions() {
		if (comprovaMotor().equals(EstatsMotorCotxe.EnMarxa)) {
			return (int) ((Math.random() *6500) + 1);
		} else {
			return 0;
		}

	}

	public void aturarMotor() throws Exception {
		if (comprovaMotor().equals(EstatsMotorCotxe.Aturat)) {
			throw new Exception("El motor ja està apagat.");
		} else {
			System.out.println("S'apaga el cotxe.");
			this.motor = EstatsMotorCotxe.Aturat;
		}

	}
	
	private int ComprovarMarxaAutomatic(){ //comprova de forma interna la marxa automàtica. Retorna -2 si hi ha un error a les marxes
		int marxa;
		if (marxa_auto.equals(CanviarMarxaAutomatic.N)) {
			marxa = 0;
		}
		else if (marxa_auto.equals(CanviarMarxaAutomatic.F)) {
			marxa = 1;
		}
		else if (marxa_auto.equals(CanviarMarxaAutomatic.R)) {
			marxa = -1;
		}
		else {
			marxa = -2;
		}
		return marxa;
	}
	
	public CanviarMarxaAutomatic getMarxaAutomatic() {
			
		return marxa_auto;
	}
	
	private int ComprovarMarxaManual(){ //comprova de forma interna la marxa manual. Retorna -2 si hi ha un error a les marxes
		int marxa;
		if (marxa_manual.equals(CanviarMarxaManual.PRIMERA)) {
			marxa = 0;
		}
		else if (marxa_manual.equals(CanviarMarxaManual.SEGONA)) {
			marxa = 1;
		}
		else if (marxa_manual.equals(CanviarMarxaManual.TERCERA)) {
			marxa = 2;
		}
		else if (marxa_manual.equals(CanviarMarxaManual.QUARTA)) {
			marxa = 3;
		}
		else if (marxa_manual.equals(CanviarMarxaManual.CINQUENA)) {
			marxa = 4;
		}
		else if (marxa_manual.equals(CanviarMarxaManual.SISENA)) {
			marxa = 5;
		}
		else if (marxa_manual.equals(CanviarMarxaManual.R)) {
			marxa = -1;
		}
		else {
			marxa = -2;
		}
		return marxa;
	}
	
	public CanviarMarxaManual getMarxaManual() {
		return marxa_manual;
	}
	
	public void PujarMarxaAutomatic() throws Exception{
		if (this.tipuscanvi.equals(TipusCanvi.CanviAutomatic)) {
			if (motor.equals(EstatsMotorCotxe.EnMarxa)) {
				if (ComprovarMarxaAutomatic() == -1 || ComprovarMarxaAutomatic() == 0) {
				marxa_auto = CanviarMarxaAutomatic.F;
				}
				else {
					throw new Exception("No pots pujar la marxa si estàs al màxim que pots pujar, batraci.");
				}
			}
			else {
				throw new Exception("No pots pujar la marxa si el cotxe no està en marxa");
			}
		}
		else {
			throw new Exception("Estàs intentant fer un canvi de marxa automàtic per a un cotxe manual :facepalm:");
		}
	}
	
	public void BaixarMarxaAutomatic() throws Exception{
		if (this.tipuscanvi.equals(TipusCanvi.CanviAutomatic)) {
			if (motor.equals(EstatsMotorCotxe.EnMarxa)) {
				if (ComprovarMarxaAutomatic() == 0 || ComprovarMarxaAutomatic() == 1) {
				marxa_auto = CanviarMarxaAutomatic.R;
				}
				else {
					throw new Exception("No pots baixar la marxa si estàs al màxim que pots baixar, cap de faba amb orelles.");
				}
			}
			else {
				throw new Exception("No pots baixar la marxa si el cotxe no està en marxa");
			}
		}
		else {
			throw new Exception("Estàs intentant fer un canvi de marxa automàtic per a un cotxe manual :facepalm:");
		}
	}
	
	public void PujarMarxaManual() throws Exception{
		if (this.tipuscanvi.equals(TipusCanvi.CanviManual)) {
			if (motor.equals(EstatsMotorCotxe.EnMarxa)) {
				if (ComprovarMarxaManual() == -1) {
					marxa_manual = CanviarMarxaManual.PRIMERA;
				}
				if (ComprovarMarxaAutomatic() == 0) {
					marxa_manual = CanviarMarxaManual.SEGONA;
				}
				else if (ComprovarMarxaManual() == 1) {
					marxa_manual = CanviarMarxaManual.TERCERA;
				}
				else if (ComprovarMarxaManual() == 2) {
					marxa_manual = CanviarMarxaManual.QUARTA;
				}
				else if (ComprovarMarxaManual() == 3) {
					marxa_manual = CanviarMarxaManual.CINQUENA;
				}
				else if (ComprovarMarxaManual() == 4) {
					marxa_manual = CanviarMarxaManual.SISENA;
				}
				else {
					throw new Exception("No pots pujar més la marxa si ja estàs al màxim");
				}
			}
			else {
				throw new Exception("Estás intentant fer un canvi de marxa amb el cotxe apagat.");
			}
		}
		else {
			throw new Exception("Estàs intentant fer un canvi de marxa manual per a un cotxe automàtic :facepalm:");
		}
	}
	
	public void BaixarMarxaManual() throws Exception{
		if (this.tipuscanvi.equals(TipusCanvi.CanviManual)) {
			if (motor.equals(EstatsMotorCotxe.EnMarxa)) {
				if (ComprovarMarxaManual() == 5) {
					marxa_manual = CanviarMarxaManual.CINQUENA;
				}
				if (ComprovarMarxaAutomatic() == 4) {
					marxa_manual = CanviarMarxaManual.QUARTA;
				}
				else if (ComprovarMarxaManual() == 3) {
					marxa_manual = CanviarMarxaManual.TERCERA;
				}
				else if (ComprovarMarxaManual() == 2) {
					marxa_manual = CanviarMarxaManual.SEGONA;
				}
				else if (ComprovarMarxaManual() == 1) {
					marxa_manual = CanviarMarxaManual.PRIMERA;
				}
				else if (ComprovarMarxaManual() == 0) {
					marxa_manual = CanviarMarxaManual.R;
				}
				else {
					throw new Exception("No pots baixar més la marxa si ja estàs al mínim");
				}
			}
			else {
				throw new Exception("Estás intentant fer un canvi de marxa amb el cotxe apagat.");
			}
		}
		else {
			throw new Exception("Estàs intentant fer un canvi de marxa manual per a un cotxe automàtic :facepalm:");
		}
	}
	
	
//	public void CanviarMarxaAutomatic(int canviarmarxa) throws Exception {
//		if (this.tipuscanvi.equals(TipusCanvi.CanviAutomatic)) {
//			if (motor.equals(EstatsMotorCotxe.EnMarxa)) {
//				switch (canviarmarxa) {
//					case 1:	if (marxa_auto.equals(CanviarMarxaAutomatic.F)){
								//throw new Exception("La marcha está en F ya, no puedes cambiarla a la que ya está")
								//}
//								else {
//									this.marxa_auto = CanviarMarxaAutomatic.F;
//								}
//							break;
//					case 2: this.marxa_auto = CanviarMarxaAutomatic.N;
//							break;
//					case 3: this.marxa_auto = CanviarMarxaAutomatic.R;
//							break;
//					default: throw new Exception ("No has introduit cap marxa correcta. A conseqüència d'això, has romput el cotxe. Enhorabona 												  mestre. Crack.");
//				}
//			} else {
//				throw new Exception(
//						"Estàs intentant canviar de marxa amb el cotxe apagat. Que escolta, ho pots fer, però serveix per al	mateix que tú. Per res");
//			}
//		} else {
//			throw new Exception("Estàs intentant fer un canvi de marxa automàtic quan el cotxe es manual :facepalm:");
//		}
//	}	public void CanviarMarxaManual() {


}