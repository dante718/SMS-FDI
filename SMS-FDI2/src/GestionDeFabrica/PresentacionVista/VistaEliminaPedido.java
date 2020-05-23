package GestionDeFabrica.PresentacionVista;

import javax.swing.JFrame;
import javax.swing.JPanel;

import GestionDeFabrica.PresentacionControlador.ControladorDeFabrica;
import GestionDeFabrica.TransfersObjects.PedidosTransfer;
import GestionDeFabrica.TransfersObjects.TransferPedidoImp;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.Color;

public class VistaEliminaPedido extends JFrame {

	private ControladorDeFabrica controlador;
	private String titulo;
	private String type;
	
	private JComboBox identificador;
	private DefaultComboBoxModel<String> identificadorModel;
	
	public VistaEliminaPedido(ControladorDeFabrica ctrl, String type, String titulo, List<PedidosTransfer> pedidos) {
		
		this.controlador = ctrl;
		this.titulo = titulo;
		this.type = type;
		
		this.identificadorModel = new DefaultComboBoxModel<String>();
		identificadorModel.removeAllElements();
		
		for ( PedidosTransfer pedido : pedidos) {
			
			identificadorModel.addElement(pedido.getIdPedido());
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
				
				TransferPedidoImp nuevoPedido = new TransferPedidoImp();
				
				nuevoPedido.setType(type);
				nuevoPedido.setIdPedido((String) identificador.getSelectedItem());
				nuevoPedido.setUsuario("null");
				nuevoPedido.setNombre("null");
				nuevoPedido.setCompuesto("null");
				nuevoPedido.setProducto("null");
				nuevoPedido.setCantidad(0);
				nuevoPedido.setEstadoPedido("null");
				
				controlador.eliminaPedido(nuevoPedido);
				
				VistaEliminaPedido.this.dispose();
			}
		});
		panel_1.add(btnConfirmar);
		
		this.setVisible(true);
	}
}
