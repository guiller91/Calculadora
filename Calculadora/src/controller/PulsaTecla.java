package controller;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JLabel;

public class PulsaTecla extends KeyAdapter {
	
	private Calculadora calculadora;
	
	public PulsaTecla(Calculadora calculadora) {
		this.calculadora = calculadora;
		
	}
	@Override
    public void keyPressed(KeyEvent e) {
		
		
        if ((	e.getKeyCode()>=KeyEvent.VK_0 && 
                e.getKeyCode()<=KeyEvent.VK_9) ||
                e.getKeyCode() == KeyEvent.VK_COMMA ||
                e.getKeyCode() == KeyEvent.VK_PERIOD ||
                e.getKeyCode() == KeyEvent.VK_DECIMAL ||
                e.getKeyCode() == KeyEvent.VK_ADD ||
                e.getKeyCode() == KeyEvent.VK_SUBTRACT ||
                e.getKeyCode() == KeyEvent.VK_MULTIPLY ||
                e.getKeyCode() == KeyEvent.VK_DIVIDE ||
                e.getKeyCode() == KeyEvent.VK_C ||
                (e.getKeyCode()>=KeyEvent.VK_NUMPAD0 && 
                e.getKeyCode()<=KeyEvent.VK_NUMPAD9)){
            calculadora.accion(""+e.getKeyChar());
        } else if (e.getKeyCode() == KeyEvent.VK_ENTER){
            calculadora.accion("=");
        }
    }

}
