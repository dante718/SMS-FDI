package GestionDeFabrica.PresentacionVista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JTextField;

import GestionDeFabrica.PresentacionControlador.ControladorDeFabrica;
import GestionDeFabrica.TransfersObjects.PedidosTransfer;
import GestionDeFabrica.TransfersObjects.TransferPedidoImp;

import javax.swing.JSpinner;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.SpinnerNumberModel;

public class VistaModificaPedido extends JFrame {
	
	private ControladorDeFabrica controlador;
	private String titulo;
	private String type;
	
	private JComboBox identificador;
	private DefaultComboBoxModel<String> identificadorModel;
	
	private JComboBox estado;
	private DefaultComboBoxModel<String> estadoModel;
	
	private List<PedidosTransfer> pedidos;
	
	private JSpinner cantidad;
	
	private JTextField producto;
	private JTextField descripcion;

	public VistaModificaPedido(ControladorDeFabrica controlador, String titulo, String type, List<PedidosTransfer> pedidos) {
		
		this.controlador = controlador;
		this.titulo = titulo;
		this.type = type;
		this.pedidos = pedidos;
		
		this.identificadorModel = new DefaultComboBoxModel<String>();
		identificadorModel.removeAllElements();
		
		for ( PedidosTransfer pedido : pedidos) {
			
			identificadorModel.addElement(pedido.getIdPedido());
		}
		
		this.estadoModel = new DefaultComboBoxModel<String>();
		estadoModel.removeAllElements();
		estadoModel.addElement("ACEPTADO");
		estadoModel.addElement("EN_PROCESO");
		estadoModel.addElement("CANCELAR");
		
		this.initGUI();
	}
	
	private void initGUI() {
		
		setTitle("Gestoria de Fabrica");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 360);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.ORANGE);
		getContentPane().add(panel, BorderLayout.NORTH);
		
		JLabel lblModificar = new JLabel("Modificar " + this.titulo);
		lblModificar.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		panel.add(lblModificar);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.ORANGE);
		getContentPane().add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(null);
		
		//identificadorModel = new DefaultComboBoxModel<String>();
		identificador = new JComboBox<String>(identificadorModel);
		identificador.setBounds(234, 11, 114, 29);
		panel_1.add(identificador);
		
		JLabel lblIdentificador = new JLabel("Identificador");
		lblIdentificador.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblIdentificador.setBounds(46, 18, 97, 14);
		panel_1.add(lblIdentificador);
		
		JLabel lblProducto = new JLabel("Producto");
		lblProducto.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblProducto.setBounds(46, 53, 82, 14);
		panel_1.add(lblProducto);
		
		producto = new JTextField();
		producto.setBounds(206, 51, 142, 20);
		panel_1.add(producto);
		producto.setColumns(10);
		
		JLabel lblDescripcion = new JLabel("Descripcion");
		lblDescripcion.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblDescripcion.setBounds(46, 92, 82, 14);
		panel_1.add(lblDescripcion);
		
		descripcion = new JTextField();
		descripcion.setBounds(206, 90, 142, 20);
		panel_1.add(descripcion);
		descripcion.setColumns(10);
		
		JLabel lblCantidad = new JLabel("Cantidad");
		lblCantidad.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblCantidad.setBounds(46, 127, 97, 14);
		panel_1.add(lblCantidad);
		
		cantidad = new JSpinner();
		cantidad.setModel(new SpinnerNumberModel(1, 1, 100, 1));
		cantidad.setBounds(206, 121, 70, 24);
		panel_1.add(cantidad);
		
		JLabel lblEstado = new JLabel("Estado");
		lblEstado.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblEstado.setBounds(46, 162, 48, 14);
		panel_1.add(lblEstado);
		
		//estadoModel = new DefaultComboBoxModel<String>();
		estado = new JComboBox<String>(estadoModel);
		estado.setBounds(234, 156, 114, 29);
		panel_1.add(estado);
		
		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.setBackground(Color.WHITE);
		btnConfirmar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnConfirmar.setBounds(155, 209, 121, 35);
		btnConfirmar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				TransferPedidoImp nuevoPedido = new TransferPedidoImp();
				
				nuevoPedido.setType(type);
				nuevoPedido.setIdPedido((String) identificador.getSelectedItem());
				nuevoPedido.setUsuario("Gestor Fabrica");
				nuevoPedido.setNombre(descripcion.getText());
				nuevoPedido.setCompuesto("null");
				nuevoPedido.setProducto(producto.getText());
				nuevoPedido.setCantidad((int) cantidad.getValue());
				nuevoPedido.setEstadoPedido((String) estado.getSelectedItem());
				
				controlador.modificaPedido(nuevoPedido);
				
				VistaModificaPedido.this.dispose();
			}
		});
		panel_1.add(btnConfirmar);
		
		this.setVisible(true);
	}
}
