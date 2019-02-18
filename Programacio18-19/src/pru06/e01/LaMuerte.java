package pru06.e01;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class LaMuerte {
	public void iniciarLaMuerte() {
		JFrame la_muerte = new JFrame("La muerte aplication");
		JOptionPane mensaje = new JOptionPane();
		JOptionPane.showMessageDialog(la_muerte, "Amo a Dabyt. Att. Maiko.", "LaMuerte DabytSimulator", 1);
	}
	public static void main (String[] args) {
		LaMuerte la_muerte = new LaMuerte();
		la_muerte.iniciarLaMuerte();
	}
}
