package GestionDeFabrica.PresentacionVista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import GestionDeFabrica.PresentacionControlador.ControladorDeFabrica;
import GestionDeFabrica.TransfersObjects.PedidosTransfer;
import GestionDeFabrica.TransfersObjects.TransferPedidoImp;
import GestionDeFabrica.TransfersObjects.TransferUsuarioImp;
import GestionDeFabrica.TransfersObjects.UsuarioTransfer;

public class VistaEliminarUsuario extends JFrame {

	private ControladorDeFabrica controlador;
	private String titulo;
	private String type;
	
	private JComboBox identificador;
	private DefaultComboBoxModel<String> identificadorModel;
	
	private List<UsuarioTransfer> usuarios;
	
	public VistaEliminarUsuario(ControladorDeFabrica ctrl) {
		
		this.controlador = ctrl;
		this.titulo = titulo;
		this.type = type;
		
		usuarios = ctrl.getListaUsuarios();
		
		this.identificadorModel = new DefaultComboBoxModel<String>();
		identificadorModel.removeAllElements();
		
		for ( UsuarioTransfer us : usuarios) {
			
			identificadorModel.addElement(us.getDNI());
		}
		
		this.initGUI();
	}
	
	private void initGUI() {
		
		setTitle("Gestoria de Fabrica");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 275);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.ORANGE);
		panel.setForeground(Color.BLACK);
		getContentPane().add(panel, BorderLayout.NORTH);
		
		JLabel lblEliminar = new JLabel("Eliminar " + this.titulo);
		lblEliminar.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		panel.add(lblEliminar);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.ORANGE);
		panel_1.setForeground(Color.ORANGE);
		getContentPane().add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(null);
		
		JLabel lblIdentificador = new JLabel("Identificador");
		lblIdentificador.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblIdentificador.setBounds(50, 22, 131, 31);
		panel_1.add(lblIdentificador);
		
		identificador = new JComboBox<String>(identificadorModel);
		identificador.setBounds(234, 11, 114, 29);
		panel_1.add(identificador);
		
		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnConfirmar.setBounds(151, 103, 130, 50);
		btnConfirmar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				TransferUsuarioImp nuevoUsuario = new TransferUsuarioImp();
				
				nuevoUsuario.setDNI((String) identificador.getSelectedItem());
				nuevoUsuario.setNombre("null");
				nuevoUsuario.setApellido1("null");
				nuevoUsuario.setApellido2("null");
				nuevoUsuario.setDisponibilidad(false);
				nuevoUsuario.setProyecto("");
				nuevoUsuario.setTelefono("null");
				
				controlador.eliminaUsuario(nuevoUsuario);
				
				VistaEliminarUsuario.this.dispose();
			}
		});
		panel_1.add(btnConfirmar);
		
		this.setVisible(true);
	}
}
