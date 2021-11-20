package view;


import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;
import javax.swing.border.LineBorder;

import controller.GradientController;
import controller.PasswordField;
import controller.TxtField;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Window;
import java.awt.BorderLayout;
import java.awt.Dialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.io.File;
import java.io.IOException;
import java.net.URL;

public class LoginForm extends JDialog {

	private Clip music = null;
	private TxtField txtUsername;
	private PasswordField txtPassword;
	private String user = "rachel";
	private String pass = "1234";
	private int contador = 0;
	private int x, y;
	private long clipTime;
	private URL url = LoginForm.class.getResource("/resources/1.gif");
	private ImageIcon robot = new ImageIcon(
			new ImageIcon(url).getImage().getScaledInstance(220, 250, Image.SCALE_DEFAULT));
	private URL url2 = LoginForm.class.getResource("/resources/2.gif");
	private ImageIcon error = new ImageIcon(
			new ImageIcon(url2).getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
	private URL url3 = LoginForm.class.getResource("/resources/volumeOn.png");
	private ImageIcon volumeOn = new ImageIcon(new ImageIcon(url3).getImage());
	private URL url4 = LoginForm.class.getResource("/resources/volumeOff.png");
	private ImageIcon volumeOff = new ImageIcon(new ImageIcon(url4).getImage());
	private URL url5 = LoginForm.class.getResource("/resources/close.png");
	private ImageIcon close = new ImageIcon(new ImageIcon(url5).getImage());
	private URL url6 = LoginForm.class.getResource("/resources/volumeOn2.png");
	private ImageIcon volumeOn2 = new ImageIcon(new ImageIcon(url6).getImage());
	private URL url7 = LoginForm.class.getResource("/resources/volumeOff2.png");
	private ImageIcon volumeOff2 = new ImageIcon(new ImageIcon(url7).getImage());
	private URL url8 = LoginForm.class.getResource("/resources/close2.png");
	private ImageIcon close2 = new ImageIcon(new ImageIcon(url8).getImage());

	public LoginForm() {
		init();

	}

	
	private void init() {

		setBounds(100, 100, 700, 400);
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		setUndecorated(true);
		setBackground(new Color(1.0f, 1.0f, 1.0f, 0.0f));
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);

		GradientController panelCuadrado = new GradientController(Color.BLACK, Color.BLACK);

		// Movimiento de la ventana a traves del panel 
		panelCuadrado.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				setLocation(getX() + e.getX() - x, getY() + e.getY() - y);
			}
		});
		panelCuadrado.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				x = e.getX();
				y = e.getY();

			}
		});

		panelCuadrado.setBounds(0, 0, 400, 400);
		panelCuadrado.setArc(30);
		panelCuadrado.setBorderColor(Color.white);
		panelCuadrado.setBorderWidth(2);
		getContentPane().add(panelCuadrado);
		panelCuadrado.setLayout(null);

		JLabel etiquetaVolumen = new JLabel("");
		etiquetaVolumen.setIcon(volumeOn);
		etiquetaVolumen.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {

				//Con el contador controlo que solo se abra una sola vez la canción
				if (contador == 0) {
					try {
						music = AudioSystem.getClip();
						music.open(AudioSystem.getAudioInputStream(new File("src/resources/harder.wav")));
					} catch (LineUnavailableException | IOException | UnsupportedAudioFileException a) {
						a.printStackTrace();
					}
				}
				if (etiquetaVolumen.getIcon().equals(volumeOn2) || etiquetaVolumen.getIcon().equals(volumeOn)) {
					etiquetaVolumen.setIcon(volumeOff);
					music.start();
					contador++;
				} else {
					etiquetaVolumen.setIcon(volumeOn);
					clipTime = music.getMicrosecondPosition();
					music.stop();
					music.setMicrosecondPosition(clipTime);
					contador++;
				}

			}

			@Override
			public void mouseExited(MouseEvent e) {
				if (etiquetaVolumen.getIcon().equals(volumeOff2)) {
					etiquetaVolumen.setIcon(volumeOff);

				} else if (etiquetaVolumen.getIcon().equals(volumeOn2)) {
					etiquetaVolumen.setIcon(volumeOn);

				}

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				if (etiquetaVolumen.getIcon().equals(volumeOff)) {
					etiquetaVolumen.setIcon(volumeOff2);
				} else if (etiquetaVolumen.getIcon().equals(volumeOn)) {
					etiquetaVolumen.setIcon(volumeOn2);

				}

			}
		});

		etiquetaVolumen.setHorizontalAlignment(SwingConstants.CENTER);
		etiquetaVolumen.setForeground(Color.WHITE);

		etiquetaVolumen.setBounds(10, 11, 70, 70);
		panelCuadrado.add(etiquetaVolumen);

		JLabel etiquetaLogo = new JLabel("");
		etiquetaLogo.setIcon(robot);
		etiquetaLogo.setHorizontalAlignment(SwingConstants.CENTER);
		etiquetaLogo.setBounds(88, 40, 226, 286);
		panelCuadrado.add(etiquetaLogo);

		JLabel etiquetaTitulo = new JLabel("Calculator");
		etiquetaTitulo.setForeground(Color.WHITE);
		etiquetaTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		etiquetaTitulo.setFont(new Font("Tahoma", Font.BOLD, 20));
		etiquetaTitulo.setBounds(80, 322, 234, 36);
		panelCuadrado.add(etiquetaTitulo);

		GradientController panelLogin = new GradientController(Color.decode("#e65758"), Color.decode("#771d32"),
				GradientController.DIAGONAL_DOWN);
		panelLogin.setArc(10);
		panelLogin.setBorderColor(Color.white);
		panelLogin.setBorderWidth(2);
		panelLogin.setBounds(200, 50, 500, 300);
		getContentPane().add(panelLogin);
		panelLogin.setLayout(null);

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.WHITE);
		panel.setOpaque(false);
		panel.setBounds(229, 69, 250, 70);
		panelLogin.add(panel);

		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(Color.WHITE);
		panel_1.setOpaque(false);
		panel_1.setBounds(229, 150, 250, 70);
		panelLogin.add(panel_1);

		txtUsername = new TxtField();
		txtUsername.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtUsername.setBounds(0, -11, 250, 70);
		txtUsername.setOpaque(false);
		txtUsername.setLabelText("Usuario");
		txtUsername.setForeground(Color.BLACK);
		txtUsername.setLineColor(new Color(0, 0, 0));
		panel.add(txtUsername);

		txtPassword = new PasswordField();
		txtPassword.setBounds(0, -11, 250, 70);
		txtPassword.setOpaque(false);
		txtPassword.setLabelText("Contraseña");
		txtPassword.setForeground(Color.BLACK);
		txtPassword.setLineColor(new Color(0, 0, 0));
		panel_1.add(txtPassword);

		JButton botonLogin = new JButton("LOGIN");
		botonLogin.setBounds(229, 234, 250, 43);
		botonLogin.setBackground(Color.darkGray);
		botonLogin.setForeground(Color.WHITE);
		botonLogin.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				char clave[] = txtPassword.getPassword();
				String clavedef = new String(clave);

				if (etiquetaVolumen.getIcon().equals(volumeOff)) {
					clipTime = music.getMicrosecondPosition();
					music.stop();
					music.setMicrosecondPosition(clipTime);
					etiquetaVolumen.setIcon(volumeOn);

				}

				if (txtUsername.getText().equals(user) && clavedef.equals(pass)) {

					DialogWait wait = new DialogWait();

					SwingWorker<Void, Void> mySwingWorker = new SwingWorker<Void, Void>() {

						@Override
						protected Void doInBackground() throws Exception {

							// Here you put your long-running process...
							Thread.sleep(8000);
							dispose();

							wait.close();

							return null;
						}
					};

					mySwingWorker.execute();
					wait.makeWait(e);

				} else {

					try {
						Clip clip = AudioSystem.getClip();
						clip.open(AudioSystem.getAudioInputStream(new File("src/resources/error.wav")));
						clip.start();

					} catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
						System.out.println("Error al reproducir el sonido. " + ex);
					}
					JOptionPane.showMessageDialog(null,
							"Acceso denegado:\n" + "Por favor ingrese un usuario y/o contraseña correctos",
							"Acceso denegado", JOptionPane.PLAIN_MESSAGE, error);

				}

			}

		});
		panelLogin.add(botonLogin);

		JLabel etiquetaLogin = new JLabel("LOGIN");
		etiquetaLogin.setForeground(Color.WHITE);
		etiquetaLogin.setFont(new Font("Tahoma", Font.BOLD, 20));
		etiquetaLogin.setBounds(232, 31, 115, 19);
		panelLogin.add(etiquetaLogin);

		JLabel etiquetaExit = new JLabel("");
		etiquetaExit.setIcon(close);
		etiquetaExit.setBounds(453, 11, 37, 37);
		etiquetaExit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				if (JOptionPane.showConfirmDialog(null, "Estas a punto de cerrar la aplicación, ¿estas seguro?") == 0)
					System.exit(0);
			}

			@Override
			public void mouseExited(MouseEvent e) {

				etiquetaExit.setIcon(close);

			}

			@Override
			public void mouseEntered(MouseEvent e) {

				etiquetaExit.setIcon(close2);

			}

		});
		etiquetaExit.setHorizontalAlignment(SwingConstants.CENTER);

		panelLogin.add(etiquetaExit);

	}

	private class DialogWait {

		private JDialog dialog;

		public void makeWait(ActionEvent evt) {
			Clip clip;
			try {
				clip = AudioSystem.getClip();
				clip.open(AudioSystem.getAudioInputStream(new File("src/resources/jarvis.wav")));
				clip.start();
			} catch (LineUnavailableException | IOException | UnsupportedAudioFileException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			Window win = SwingUtilities.getWindowAncestor((AbstractButton) evt.getSource());
			dialog = new JDialog(win, Dialog.ModalityType.APPLICATION_MODAL);
			dialog.setUndecorated(true);
			JProgressBar progressBar = new JProgressBar();
			progressBar.setIndeterminate(true);

			progressBar.setBackground(Color.BLACK);
			progressBar.setStringPainted(true);
			progressBar.setForeground(Color.RED);
			progressBar.setBorder(new LineBorder(Color.WHITE));

			progressBar.setString("Preparando Calculadora");

			JPanel panel = new JPanel(new BorderLayout());
			panel.add(progressBar, BorderLayout.CENTER);
			panel.setBackground(Color.DARK_GRAY);

			dialog.getContentPane().add(panel);
			dialog.setBounds(0, 0, 300, 30);
			// dialog.pack();
			dialog.setLocationRelativeTo(win);
			dialog.setVisible(true);
		}

		public void close() {
			dialog.dispose();
		}
	}

}

	