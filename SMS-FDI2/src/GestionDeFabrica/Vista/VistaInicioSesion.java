package GestionDeFabrica.Vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

public class VistaInicioSesion extends JFrame {

	private JPanel panelPrincipal;
	private JToolBar barraPrincipal;
	private JButton botonExit;
	
	private JPanel barraInferior;
	private JLabel vistaActual;
	private JLabel fechaActual;
	
	public VistaInicioSesion() {
		
		setTitle("Gestoria de Fabrica");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 300);
		
	}
}
