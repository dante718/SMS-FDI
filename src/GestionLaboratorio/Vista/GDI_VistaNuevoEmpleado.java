package GestionDeInformatica.GDI.Vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import GestionDeInformatica.GDI.Controlador.GDI_Controlador;
import GestionDeInformatica.GDI.Modelo.DaoEmpleados;
import GestionDeInformatica.GDI.Modelo.TransferEmpleados;

import java.awt.Color;
import javax.swing.JDesktopPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class GDI_VistaNuevoEmpleado extends JFrame {

	private JPanel contentPane;
	private JTextField textNombre;
	private JTextField textDni;
	private JTextField textPuesto;
	private JTextField textApellido1;
	private JTextField textApellido2;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GDI_VistaNuevoEmpleado frame = new GDI_VistaNuevoEmpleado();
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
	public GDI_VistaNuevoEmpleado() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 500);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 222, 173));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBackground(new Color(255, 228, 225));
		desktopPane.setBounds(10, 31, 464, 419);
		contentPane.add(desktopPane);
		
		JLabel lblNombre = new JLabel("NOMBRE :");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNombre.setBounds(30, 120, 81, 14);
		desktopPane.add(lblNombre);
		
		JLabel lblDni = new JLabel("DNI : ");
		lblDni.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDni.setBounds(30, 68, 81, 14);
		desktopPane.add(lblDni);
		
		JLabel lblPuesto = new JLabel("PUESTO : ");
		lblPuesto.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPuesto.setBounds(30, 292, 81, 14);
		desktopPane.add(lblPuesto);
		
		textNombre = new JTextField();
		textNombre.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textNombre.setBounds(140, 119, 140, 20);
		desktopPane.add(textNombre);
		textNombre.setColumns(10);
		
		textDni = new JTextField();
		textDni.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textDni.setBounds(140, 65, 140, 20);
		desktopPane.add(textDni);
		textDni.setColumns(10);
		
		textPuesto = new JTextField();
		textPuesto.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textPuesto.setText("");
		textPuesto.setBounds(140, 289, 140, 20);
		desktopPane.add(textPuesto);
		textPuesto.setColumns(10);
		
		textApellido1 = new JTextField();
		textApellido1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textApellido1.setBounds(140, 173, 140, 20);
		desktopPane.add(textApellido1);
		textApellido1.setColumns(10);
		
		textApellido2 = new JTextField();
		textApellido2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textApellido2.setBounds(140, 228, 140, 20);
		desktopPane.add(textApellido2);
		textApellido2.setColumns(10);
		
		JButton btnGuardar = new JButton("GUARDAR");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
// AQUI LEO LOS ESPACIOS	
				
				String dni = textDni.getText();
				String nombre = textNombre.getText();
				String apellido1 = textApellido1.getText();
				String apellido2 = textApellido2.getText();
				String puesto = textPuesto.getText();
				
				TransferEmpleados persona = new TransferEmpleados(dni,nombre,apellido1,apellido2,puesto,"Disponible","Trabajador");
				GDI_Controlador.getInstancia().anadirEmpleado(persona);
				
				dispose();
				GDI_Controlador.getInstancia().pantalla3();
				
			}
		});
		btnGuardar.setBounds(319, 373, 116, 23);
		desktopPane.add(btnGuardar);
		
		JLabel lblApellido1 = new JLabel("APELLIDO 1 :");
		lblApellido1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblApellido1.setBounds(30, 174, 91, 14);
		desktopPane.add(lblApellido1);
		
		JLabel lblApellido2 = new JLabel("APELLIDO 2 :");
		lblApellido2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblApellido2.setBounds(30, 229, 99, 14);
		desktopPane.add(lblApellido2);

		
		JLabel lblLogo = new JLabel("Informatico");
		lblLogo.setBounds(402, 11, 72, 14);
		contentPane.add(lblLogo);
	}
}
