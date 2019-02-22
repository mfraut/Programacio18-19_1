package pru06.e01;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Listener extends LaMuerte implements ActionListener {
	
	@Override
	public void actionPerformed(ActionEvent e) {
	String texto;	
	la_muerte.setTitle("CalaveraSimulator");
	texto = escrotir.getText();
	if (texto.equals("Billy")) {
		JOptionPane.showMessageDialog(la_muerte, "Matemos al tontolava este", "Calavera", JOptionPane.OK_OPTION);
	}
	else if (texto.equals("Mandy")) {
		JOptionPane.showMessageDialog(la_muerte, "A ver si nos va a matar a nosotros ambesil", "Calavera", JOptionPane.WARNING_MESSAGE);
	}
	else {
		JOptionPane.showMessageDialog(la_muerte, "A ver dabyt te quiero tio", "Calavera", JOptionPane.ERROR_MESSAGE);
	}
	
	}

}
