package GestionDeInformatica.GDI.Vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import GestionDeInformatica.GDI.Controlador.GDI_Controlador;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Color;

public class GDI_VistaPrincipal extends JFrame {
	
	private JPanel contentPane;
	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GDI_VistaPrincipal frame = new GDI_VistaPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	/**
	 * Create the frame.
	 */
	public GDI_VistaPrincipal() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 500);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 222, 173));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton btnNewButton = new JButton("ESTUDIOS");
		btnNewButton.setBounds(163, 156, 140, 51);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				GDI_Controlador.getInstancia().pantalla2();
				
			}
		});
		contentPane.setLayout(null);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("PERSONAL");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				GDI_Controlador.getInstancia().pantalla3();

			}
		});
		btnNewButton_1.setBounds(163, 217, 140, 51);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("LISTA ERRORES");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				GDI_Controlador.getInstancia().pantalla4();
				
			}
		});
		btnNewButton_2.setBounds(163, 289, 140, 51);
		contentPane.add(btnNewButton_2);
		
		JLabel lblLogo = new JLabel("Informatico");
		lblLogo.setBounds(402, 27, 72, 14);
		contentPane.add(lblLogo);
	}
}
