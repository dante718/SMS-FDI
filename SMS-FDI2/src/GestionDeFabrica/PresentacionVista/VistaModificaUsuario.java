package GestionDeFabrica.PresentacionVista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import GestionDeFabrica.PresentacionControlador.ControladorDeFabrica;
import GestionDeFabrica.TransfersObjects.PedidosTransfer;
import GestionDeFabrica.TransfersObjects.TransferUsuarioImp;
import GestionDeFabrica.TransfersObjects.UsuarioTransfer;

import javax.swing.JComboBox;

public class VistaModificaUsuario extends JFrame {
	private JTextField nombre;
	private JTextField apellido1;
	private JTextField apellido2;
	private JTextField telefono;
	private JTextField proyecto;

	private JComboBox dni;
	private DefaultComboBoxModel<String> dniModel;
	
	private JComboBox dis;
	private DefaultComboBoxModel<String> disModel;
	
	private List<UsuarioTransfer> usuarios;
	
	public VistaModificaUsuario(ControladorDeFabrica ctrl) {
		
		this.dniModel = new DefaultComboBoxModel<String>();
		dniModel.removeAllElements();
		usuarios = ctrl.getListaUsuarios();
		
		for ( UsuarioTransfer us : usuarios) {
			
			dniModel.addElement(us.getDNI());
		}
		
		this.disModel = new DefaultComboBoxModel<String>();
		disModel.removeAllElements();
		disModel.addElement("Disponible");
		disModel.addElement("No Disponible");
		
		setTitle("Gestoria de Fabrica");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 430);
		
		setBackground(Color.ORANGE);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.ORANGE);
		getContentPane().add(panel, BorderLayout.NORTH);
		
		JLabel lblCrearNuevoUsuario = new JLabel("Modificar Usuario");
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
		btnNewButton.setBounds(146, 275, 112, 41);
		btnNewButton.addActionListener(new ActionListener(){
			

			@Override
			public void actionPerformed(ActionEvent e) {
			
				TransferUsuarioImp nuevoUsuario = new TransferUsuarioImp();
				
				if(nombre.getText().contentEquals("")) {
					
					nuevoUsuario.setNombre(ctrl.getUsuario((String) dni.getSelectedItem()).getNombre());
				}
				else {
					nuevoUsuario.setNombre(nombre.getText());
				}
				if(apellido1.getText().equals("")) {
					
					nuevoUsuario.setApellido1(ctrl.getUsuario((String) dni.getSelectedItem()).getApellido1());
				}
				else {
					nuevoUsuario.setApellido1(apellido1.getText());
				}
				if(apellido2.getText().equals("")) {
					
					nuevoUsuario.setApellido2(ctrl.getUsuario((String) dni.getSelectedItem()).getApellido2());
				}
				else {
					nuevoUsuario.setApellido2(apellido2.getText());
				}
				if(telefono.getText().equals("")) {
					
					nuevoUsuario.setTelefono(ctrl.getUsuario((String) dni.getSelectedItem()).getTelefono());
				}
				else {
					nuevoUsuario.setTelefono(telefono.getText());
				}
				if(proyecto.getText().equals("")) {
					
					nuevoUsuario.setProyecto(ctrl.getUsuario((String) dni.getSelectedItem()).getProyecto());
				}
				else {
					nuevoUsuario.setProyecto(proyecto.getText());
				}
				
				nuevoUsuario.setDNI((String) dni.getSelectedItem());
				if(dis.getSelectedItem().equals("Disponible")){
					nuevoUsuario.setDisponibilidad(true);
				}
				else {
					nuevoUsuario.setDisponibilidad(false);
				}
				
				ctrl.modificaUsuario(nuevoUsuario);
				
				VistaModificaUsuario.this.dispose();
			}
		});
		panel_1.add(btnNewButton);
		
		dni = new JComboBox<String>(dniModel);
		dni.setBounds(199, 22, 129, 22);
		panel_1.add(dni);
		
		JLabel lblDisponibilidad = new JLabel("Disponibilidad");
		lblDisponibilidad.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblDisponibilidad.setBounds(63, 201, 103, 14);
		panel_1.add(lblDisponibilidad);
		
		dis = new JComboBox<String>(disModel);
		dis.setBounds(199, 196, 129, 22);
		panel_1.add(dis);
		
		JLabel lblProyecto = new JLabel("Proyecto");
		lblProyecto.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblProyecto.setBounds(63, 230, 86, 14);
		panel_1.add(lblProyecto);
		
		proyecto = new JTextField();
		proyecto.setBounds(199, 228, 129, 20);
		panel_1.add(proyecto);
		proyecto.setColumns(10);
		
		this.setVisible(true);
	}
}

