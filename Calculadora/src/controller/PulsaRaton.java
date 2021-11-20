package controller;

import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PulsaRaton implements ActionListener {

	Calculadora calculadora;

	public PulsaRaton(Calculadora calculadora) {
		this.calculadora = calculadora;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton origen = (JButton) e.getSource();
		String texto = origen.getText();
		calculadora.accion(texto);
	}

}
