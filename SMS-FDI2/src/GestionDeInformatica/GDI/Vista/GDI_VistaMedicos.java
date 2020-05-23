package GestionDeInformatica.GDI.Vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import GestionDeInformatica.GDI.Controlador.GDI_Controlador;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Label;
import javax.swing.JDesktopPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GDI_VistaMedicos extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GDI_VistaMedicos frame = new GDI_VistaMedicos();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	public GDI_VistaMedicos(String nombre) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 500);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 222, 173));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEligeMedico = new JLabel("Eliga medico para el estudio: ");
		lblEligeMedico.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEligeMedico.setBounds(45, 32, 185, 35);
		contentPane.add(lblEligeMedico);
		
		JLabel lblNombreEstudio = new JLabel(nombre);
		lblNombreEstudio.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNombreEstudio.setBounds(240, 37, 234, 25);
		contentPane.add(lblNombreEstudio);
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBackground(new Color(255, 228, 225));
		desktopPane.setBounds(240, 32, 197, 35);
		contentPane.add(desktopPane);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"\"Eliga a un Medico\"", "Antonio Gonzalez        Hospital HM Madrid", "Jose Rodriguez             Hospital La Paz", "Manuel Hernandez      Hospital Infanta Sofia", "Franciso Lopez             Hospital Puerta de Hierro", "Javier Sanchez              Hospital La Paz"}));
		comboBox.setBounds(98, 126, 263, 35);
		contentPane.add(comboBox);
		
		JLabel lblLogo = new JLabel("Informatico");
		lblLogo.setBounds(402, 11, 72, 14);
		contentPane.add(lblLogo);
		
		JButton btnSave = new JButton("GUARDAR");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				GDI_Controlador.getInstancia().pantalla1();
			}
		});
		btnSave.setBounds(324, 414, 113, 23);
		contentPane.add(btnSave);
	}
}
