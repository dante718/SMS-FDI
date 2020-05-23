package GestionDeFabrica.PresentacionVista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.SpinnerNumberModel;

import GestionDeFabrica.PresentacionControlador.ControladorDeFabrica;
import GestionDeFabrica.TransfersObjects.TransferPedidoImp;

public class VistaCrearNuevoPedido extends JFrame {
	private JTextField id;
	private JTextField producto;
	private JTextField descripcion;
	private JSpinner cantidad;
	private ControladorDeFabrica ctrl;
	private String type;
	private String titulo;
	
	//public VistaCrearNuevoPedido(ControladorDeFabrica, String type) {
		
	//}
	
	public VistaCrearNuevoPedido(ControladorDeFabrica ctrl, String type, String titulo) {
		
		this.ctrl = ctrl;
		this.type = type;
		this.titulo = titulo;
		this.initGUI();
	}
	
	private void initGUI() {
		
		setTitle("Gestoria de Fabrica");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 360);
		
		setBackground(Color.ORANGE);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.ORANGE);
		getContentPane().add(panel, BorderLayout.NORTH);
		
		JLabel lblCrearNuevo = new JLabel("Crear Nuevo " + this.titulo);
		lblCrearNuevo.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		panel.add(lblCrearNuevo);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.ORANGE);
		getContentPane().add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(null);
		
		JLabel lblIdentificador = new JLabel("Identificador");
		lblIdentificador.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblIdentificador.setBounds(46, 11, 92, 14);
		panel_1.add(lblIdentificador);
		
		id = new JTextField();
		id.setToolTipText("Identificador");
		id.setBounds(168, 9, 178, 20);
		panel_1.add(id);
		id.setColumns(10);
		
		JLabel lblProducto = new JLabel("Producto");
		lblProducto.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblProducto.setBounds(46, 56, 92, 14);
		panel_1.add(lblProducto);
		
		JLabel lblCantidad = new JLabel("Cantidad");
		lblCantidad.setBackground(Color.WHITE);
		lblCantidad.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblCantidad.setBounds(46, 161, 92, 14);
		panel_1.add(lblCantidad);
		
		producto = new JTextField();
		producto.setToolTipText("Producto");
		producto.setBounds(168, 54, 178, 20);
		panel_1.add(producto);
		producto.setColumns(10);
		
		cantidad = new JSpinner();
		cantidad.setModel(new SpinnerNumberModel(1, 1, 100, 1));
		cantidad.setBounds(168, 156, 77, 27);
		panel_1.add(cantidad);
		
		JButton btnNewButton = new JButton("Confirmar");
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnNewButton.setBounds(168, 213, 124, 37);
		btnNewButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				if (id.getText().equals("")) {
					
					JOptionPane.showMessageDialog(VistaCrearNuevoPedido.this, "Debes de insertar un identificador");
				}
				if (ctrl.contienePedido(id.getText())) {
					
					JOptionPane.showMessageDialog(VistaCrearNuevoPedido.this, "Este identificador ya existe en la Base de Datos, debes cambiarlo");
				}
				if (producto.getText().equals("")) {
					
					JOptionPane.showMessageDialog(VistaCrearNuevoPedido.this, "Debes de insertar algun producto");
				}
				
				TransferPedidoImp nuevoPedido = new TransferPedidoImp();
				
				nuevoPedido.setType(type);
				nuevoPedido.setIdPedido(id.getText());
				nuevoPedido.setUsuario("Gestor Fabrica");
				nuevoPedido.setNombre(descripcion.getText());
				nuevoPedido.setCompuesto("null");
				nuevoPedido.setProducto(producto.getText());
				nuevoPedido.setCantidad((int) cantidad.getValue());
				nuevoPedido.setEstadoPedido("EN_PROCESO");
				
				ctrl.agregaPeidido(nuevoPedido);
				
				VistaCrearNuevoPedido.this.dispose();
				//VistaCrearNuevoPedido.this.setVisible(false);
			}
			
		});
		panel_1.add(btnNewButton);
		
		JLabel lblDescripcion = new JLabel("Descripcion");
		lblDescripcion.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblDescripcion.setBounds(46, 107, 89, 14);
		panel_1.add(lblDescripcion);
		
		descripcion = new JTextField();
		descripcion.setToolTipText("Producto");
		descripcion.setColumns(10);
		descripcion.setBounds(168, 105, 178, 20);
		panel_1.add(descripcion);
		
		this.setVisible(true);
	}
}
