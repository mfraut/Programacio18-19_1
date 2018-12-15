package pru03.E02;

public class PRU03E02Cotxe_Miquel_Frau extends CotxeAbstracte implements InterfaceCotxe {
	EstatsMotorCotxe motor = EstatsMotorCotxe.Aturat;


	public PRU03E02Cotxe_Miquel_Frau(String marca, String model, TipusCanvi tipuscanvi) {
		super(marca, model, tipuscanvi);
		this.marca = marca;
		this.model = model;
		this.tipuscanvi = tipuscanvi;
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
			return (int) (((Math.random()*6500) + 1));
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

}