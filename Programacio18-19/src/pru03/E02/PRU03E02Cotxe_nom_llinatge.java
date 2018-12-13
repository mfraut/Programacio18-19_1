package pru03.E02;

public class PRU03E02Cotxe_nom_llinatge extends CotxeAbstracte implements InterfaceCotxe {
	EstatsMotorCotxe motor = EstatsMotorCotxe.Aturat;
	public PRU03E02Cotxe_nom_llinatge(String marca, String model, TipusCanvi tipuscanvi) {
		super(marca, model, tipuscanvi);
		this.marca=marca;
		this.model=model;
		this.tipuscanvi=tipuscanvi;
	}

	
	public void arrancarMotor() throws Exception {
		if (comprovaMotor().equals(EstatsMotorCotxe.EnMarxa)) {
			throw new Exception("El motor ja està encés, maricó");
		}
		else {
			System.out.println("BRUUUUUUM BRUUUUUUUUM");
			this.motor=EstatsMotorCotxe.EnMarxa;
		}
	}

	
	public EstatsMotorCotxe comprovaMotor() {
		return this.motor;
	}

	
	public int getRevolucions() {
		if (comprovaMotor().equals(EstatsMotorCotxe.EnMarxa)) {
			return (int)((Math.random() * ((6500 - 1) + 1)) + 6500);
		}
		else{
			return 0;	
		}
		
	}

	
	public void aturarMotor() throws Exception {
		if (comprovaMotor().equals(EstatsMotorCotxe.Aturat)) {
			throw new Exception("El motor ja està apagat, maricó");
		}
		else {
			System.out.println("BRUUUUUum brumm...");
			this.motor=EstatsMotorCotxe.Aturat;
		}
		
	}
}