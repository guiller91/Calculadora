package controller;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.util.EventListener;

import javax.swing.JButton;
import javax.swing.event.MouseInputListener;

public class MouseHover implements EventListener {
	
	public MouseHover() {
		
	}
	
	public void fontColor(JButton boton, int r, int g, int b,int r2, int g2, int b2) {
		boton.addMouseListener(new MouseInputListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				boton.setForeground(new Color(r,g,b));
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				boton.setForeground(new Color(r2,g2,b2));
				
			}

			@Override
			public void mouseDragged(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseMoved(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			
			

		});
		
			
	}
}
