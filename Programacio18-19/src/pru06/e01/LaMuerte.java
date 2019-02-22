package pru06.e01;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Component;

public class LaMuerte {
	JFrame la_muerte;
	JTextField escrotir;
	JOptionPane respuesta;
	public void iniciarLaMuerte() {
		la_muerte = new JFrame("La muerte aplication");
		la_muerte.pack();
		la_muerte.setLocation(500, 300);
		la_muerte.setVisible(true);
		la_muerte.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		escrotir = new JTextField(20);
		respuesta = new JOptionPane();
		la_muerte.add(respuesta);

		//respuesta = new JOptionPane();
		//respuesta.add(escrotir);
		//escrotir.addActionListener(new Listener());
	}
	public static void main (String[] args) {
		
		LaMuerte la_muerte = new LaMuerte();
		la_muerte.iniciarLaMuerte();
	}
}
