package pru06.e01;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Color;

public class LaMuerte {
	JFrame la_muerte = new JFrame("La muerte aplication");
	JTextField escrotir = new JTextField();
	JOptionPane respuesta = new JOptionPane();
	public void iniciarLaMuerte() {
		respuesta.add(escrotir);
		escrotir.addActionListener(new Listener());
	}
	public static void main (String[] args) {
		LaMuerte la_muerte = new LaMuerte();
		la_muerte.iniciarLaMuerte();
	}
}
