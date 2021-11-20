package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import controller.Calculadora;
import controller.MouseHover;
import controller.PulsaRaton;
import controller.PulsaTecla;

public class Ventana extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel pantallaResultado = new JLabel(" ");
	private JPanel panelLogging = new JPanel();
	private JPanel panelBotones = new JPanel();
	private JButton[] botones = {     new JButton("C")/* 0 */,  new JButton("/")/* 1 */,  new JButton("*")/* 2 */,
			new JButton("-")/* 3 */,  new JButton("7")/* 4 */,  new JButton("8")/* 5 */,  new JButton("9")/* 6 */,
			new JButton("+")/* 7 */,  new JButton("4")/* 8 */,  new JButton("5")/* 9 */,  new JButton("6")/* 10 */,
			new JButton("=")/* 11 */, new JButton("1")/* 12 */, new JButton("2")/* 13 */, new JButton("3")/* 14 */,
			new JButton(".")/* 15 */, new JButton("0")/* 16 */, new JButton("Identificate")/* 17 */
	};

	private Calculadora calcu = new Calculadora(pantallaResultado);
	private Image iconoPropio = Toolkit.getDefaultToolkit()
			.getImage(getClass().getResource("/resources/calculator.png"));

	public Ventana() {

		setResizable(false);
		setIconImage(iconoPropio);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 295, 544);
		setLocationRelativeTo(null);
		init();

		
		this.setVisible(true);
	} 
	
	private void init() {
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		try {
			Font font = Font.createFont(Font.TRUETYPE_FONT,
					getClass().getResourceAsStream("/resources/Technology-Bold.ttf"));
			pantallaResultado.setForeground(Color.WHITE);
			pantallaResultado.setBackground(new Color(17, 17, 17));
			pantallaResultado.setOpaque(true);
			pantallaResultado.setFont(font.deriveFont(Font.BOLD, 35f));
		} catch (FontFormatException | IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		PulsaRaton pr = new PulsaRaton(calcu);
		PulsaTecla pt = new PulsaTecla(calcu);
		MouseHover mh = new MouseHover();

		panelLogging.setBackground(Color.GREEN);
		panelLogging.setBounds(0, 465, 280, 47);
		contentPane.add(panelLogging);
		panelLogging.setLayout(null);

		panelBotones.setBackground(Color.DARK_GRAY);
		panelBotones.setBounds(0, 114, 280, 351);
		contentPane.add(panelBotones);
		panelBotones.setLayout(null);

		botones[0].setBounds(0, 0, 70, 70);
		panelBotones.add(botones[0]);

		botones[1].setBounds(70, 0, 70, 70);
		panelBotones.add(botones[1]);

		botones[2].setBounds(140, 0, 70, 70);
		panelBotones.add(botones[2]);

		botones[3].setBounds(210, 0, 70, 70);
		panelBotones.add(botones[3]);

		botones[4].setBounds(0, 70, 70, 70);
		panelBotones.add(botones[4]);

		botones[5].setBounds(70, 70, 70, 70);
		panelBotones.add(botones[5]);

		botones[6].setBounds(140, 70, 70, 70);
		panelBotones.add(botones[6]);

		botones[7].setBounds(210, 70, 70, 140);
		panelBotones.add(botones[7]);

		botones[8].setBounds(0, 140, 70, 70);
		panelBotones.add(botones[8]);

		botones[9].setBounds(70, 140, 70, 70);
		panelBotones.add(botones[9]);

		botones[10].setBounds(140, 140, 70, 70);
		panelBotones.add(botones[10]);

		botones[12].setBounds(0, 210, 70, 70);
		panelBotones.add(botones[12]);

		botones[13].setBounds(70, 210, 70, 70);
		panelBotones.add(botones[13]);

		botones[14].setBounds(140, 210, 70, 70);
		panelBotones.add(botones[14]);

		botones[16].setBounds(0, 280, 140, 70);
		panelBotones.add(botones[16]);

		botones[15].setBounds(140, 280, 70, 70);
		panelBotones.add(botones[15]);

		botones[11].setBounds(210, 210, 70, 140);
		panelBotones.add(botones[11]);

		botones[17].setBounds(0, 0, 280, 47);
		botones[17].setBackground(new Color(60, 59, 58));
		botones[17].setForeground(Color.WHITE);
		botones[17].setBorder(new LineBorder(Color.DARK_GRAY));
		botones[17].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton origen = (JButton) e.getSource();
				String texto = origen.getText();
				if (texto.equals("Identificate")) {

					LoginForm vNueva = new LoginForm() {
						// Con esto cuando llamemos a dispose de vNueva abrimos la principal
						@Override
						public void dispose() {
							// Hacemos visible la principal
							getFrame().setVisible(true);
							for (int i = 0; i < botones.length - 1; i++) {
								botones[i].setEnabled(true);
							}
							botones[17].setText("Desconexión");
							// Cerramos vNueva
							super.dispose();
						}
					};

					// Hacemos visible a vNueva
					vNueva.setVisible(true);
					// Cerramos la principal
					dispose();
				} else {
					botones[17].setText("Identificate");
					for (int i = 0; i < botones.length - 1; i++) {
						botones[i].setEnabled(false);
					}
				}

			}
		});

		panelLogging.add(botones[17]);

		for (int i = 0; i < botones.length - 1; i++) {
			botones[i].setFocusPainted(false);
			botones[i].setEnabled(false);
			if (i == 0 || i == 1 || i == 2 || i == 3 || i == 7 || i == 11) {
				botones[i].setBackground(new Color(230, 126, 34));
				botones[i].setForeground(Color.WHITE);
				botones[i].addActionListener(pr);
				botones[i].addKeyListener(pt);
				botones[i].setBorder(new LineBorder(Color.DARK_GRAY));
				botones[i].setFont(new Font("Arial", Font.BOLD, 17));
				mh.fontColor(botones[i], 0, 0, 0, 255, 255, 255);

			} else {

				botones[i].setBackground(new Color(208, 211, 212));
				botones[i].setForeground(Color.BLACK);
				botones[i].addActionListener(pr);
				botones[i].addKeyListener(pt);
				botones[i].setBorder(new LineBorder(Color.DARK_GRAY));
				botones[i].setFont(new Font("Arial", Font.BOLD, 15));
				mh.fontColor(botones[i], 255, 255, 255, 0, 0, 0);

			}

		}

		pantallaResultado.setBounds(0, 0, 280, 115);
		contentPane.add(pantallaResultado);
		pantallaResultado.setText("0");
		pantallaResultado.setHorizontalAlignment(JLabel.RIGHT);
	}

	private JFrame getFrame() {
		return this;
	}

}
