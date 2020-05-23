package GestionDeFabrica.PresentacionVista;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

import GestionDeFabrica.PresentacionControlador.ControladorDeFabrica;
import GestionDeFabrica.TransfersObjects.TransferUsuarioImp;
import GestionDeFabrica.TransfersObjects.UsuarioTransfer;

import javax.swing.JButton;

public class VistaCrearUsuario extends JFrame {
	
	private JTextField dni;
	private JTextField nombre;
	private JTextField apellido1;
	private JTextField apellido2;
	private JTextField telefono;

	public VistaCrearUsuario(ControladorDeFabrica ctrl) {
		
		setTitle("Gestoria de Fabrica");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 360);
		
		setBackground(Color.ORANGE);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.ORANGE);
		getContentPane().add(panel, BorderLayout.NORTH);
		
		JLabel lblCrearNuevoUsuario = new JLabel("Crear Nuevo Usuario");
		lblCrearNuevoUsuario.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		panel.add(lblCrearNuevoUsuario);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.ORANGE);
		getContentPane().add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(null);
		
		JLabel lblDni = new JLabel("DNI");
		lblDni.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblDni.setBounds(63, 25, 48, 14);
		panel_1.add(lblDni);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNombre.setBounds(63, 61, 66, 14);
		panel_1.add(lblNombre);
		
		JLabel lblApellido = new JLabel("Apellido (2)");
		lblApellido.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblApellido.setBounds(63, 133, 77, 14);
		panel_1.add(lblApellido);
		
		JLabel lblApellido_1 = new JLabel("Apellido (1)");
		lblApellido_1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblApellido_1.setBounds(63, 97, 86, 14);
		panel_1.add(lblApellido_1);
		
		JLabel lblTelefono = new JLabel("Telefono");
		lblTelefono.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblTelefono.setBounds(63, 167, 66, 14);
		panel_1.add(lblTelefono);
		
		dni = new JTextField();
		dni.setBounds(199, 23, 129, 20);
		panel_1.add(dni);
		dni.setColumns(10);
		
		nombre = new JTextField();
		nombre.setColumns(10);
		nombre.setBounds(199, 59, 129, 20);
		panel_1.add(nombre);
		
		apellido1 = new JTextField();
		apellido1.setColumns(10);
		apellido1.setBounds(199, 95, 129, 20);
		panel_1.add(apellido1);
		
		apellido2 = new JTextField();
		apellido2.setColumns(10);
		apellido2.setBounds(199, 131, 129, 20);
		panel_1.add(apellido2);
		
		telefono = new JTextField();
		telefono.setColumns(10);
		telefono.setBounds(199, 165, 129, 20);
		panel_1.add(telefono);
		
		JButton btnNewButton = new JButton("Confirmar");
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnNewButton.setBounds(150, 213, 112, 41);
		btnNewButton.addActionListener(new ActionListener(){
			

			@Override
			public void actionPerformed(ActionEvent e) {
			
				if (dni.getText().equals("")) {
					
					JOptionPane.showMessageDialog(VistaCrearUsuario.this, "Falta ingresar dato DNI");
				}
				if (ctrl.tieneUsuario(dni.getText())) {
					
					JOptionPane.showMessageDialog(VistaCrearUsuario.this, "Ya existe este DNI");
				}
				if(nombre.getText().contentEquals("")) {
					
					JOptionPane.showMessageDialog(VistaCrearUsuario.this, "Falta ingresar dato Nombre");
				}
				if(apellido1.getText().equals("")) {
					
					JOptionPane.showMessageDialog(VistaCrearUsuario.this, "Falta ingresar dato Apellido1");
				}
				if(apellido2.getText().equals("")) {
					
					JOptionPane.showMessageDialog(VistaCrearUsuario.this, "Falta ingresar dato Apellido2");
				}
				if(telefono.getText().equals("")) {
					
					JOptionPane.showMessageDialog(VistaCrearUsuario.this, "Falta ingresar dato Telefono");
				}
				
				TransferUsuarioImp nuevoUsuario = new TransferUsuarioImp();
				
				nuevoUsuario.setDNI(dni.getText());
				nuevoUsuario.setNombre(nombre.getText());
				nuevoUsuario.setApellido1(apellido1.getText());
				nuevoUsuario.setApellido2(apellido2.getText());
				nuevoUsuario.setDisponibilidad(true);
				nuevoUsuario.setProyecto("");
				nuevoUsuario.setTelefono(telefono.getText());
				
				ctrl.addUsuario(nuevoUsuario);
				
				VistaCrearUsuario.this.dispose();
			}
		});
		panel_1.add(btnNewButton);
		
		this.setVisible(true);
	}
}

//"dni": "null",
//"nombre": "null",
//"apellido1": "null",
//"apellido2": "null",
//"disponibilidad": false,
//"telefono": "null",
//"proyecto": ""
