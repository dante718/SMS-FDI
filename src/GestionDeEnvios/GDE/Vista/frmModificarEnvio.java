package GestionDeEnvios.GDE.Vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class frmModificarEnvio extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmModificarEnvio frame = new frmModificarEnvio();
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
	public frmModificarEnvio() {
		setTitle("Modificar Env\u00EDo");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(5, 5, 424, 1);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ID: AAAA");
		lblNewLabel.setBounds(15, 17, 66, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Repartido: Pepito Campo");
		lblNewLabel_1.setBounds(91, 17, 160, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Contacto: xxxxxx");
		lblNewLabel_2.setBounds(282, 17, 104, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Direcci\u00F3n: \"YYYYYYYYYYYYYYYY\"");
		lblNewLabel_3.setBounds(10, 58, 184, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Entregador a : Hospital \"X\"");
		lblNewLabel_4.setBounds(10, 97, 154, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Fecha de Envi\u00F3: 11/04/19");
		lblNewLabel_5.setBounds(10, 141, 139, 14);
		contentPane.add(lblNewLabel_5);
		
		JButton btnNewButton = new JButton("Guardar Cambios");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 frmListadoEnvio verventana = new  frmListadoEnvio();
					
					verventana.show();
			}
		});
		btnNewButton.setBackground(new Color(153, 153, 153));
		btnNewButton.setBounds(69, 179, 154, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cancelar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmListadoEnvio verventana = new  frmListadoEnvio();
				
				verventana.show();
			}
		});
		btnNewButton_1.setBackground(new Color(153, 153, 153));
		btnNewButton_1.setBounds(248, 179, 104, 23);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_6 = new JLabel("Fecha de Entrega: 11/10/20");
		lblNewLabel_6.setBounds(228, 58, 169, 14);
		contentPane.add(lblNewLabel_6);
	}

}
