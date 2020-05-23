package GestionDeFabrica.Vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import GestionDeFabrica.Controlador.ControladorDeFabrica;
import GestionDeFabrica.Modelo.EstadoPedido;
import GestionDeFabrica.Modelo.Fabrica;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.border.CompoundBorder;
import javax.swing.table.DefaultTableModel;

import org.json.JSONArray;
import org.json.JSONObject;

import javax.swing.border.LineBorder;
import javax.swing.JToolBar;
import javax.swing.JTextPane;
import javax.swing.JFormattedTextField;
import javax.swing.JEditorPane;

public class VistaFabrica extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	private ControladorDeFabrica _ctrl;
	
	private JButton botonFarmacos;
	private JLabel labelFarmacos;
	private JButton botonInventario;
	private JLabel labelInventario;
	private JButton botonPedidos;
	private JLabel labelPedidos;
	
	private VistaPedidoAlmacen vistaAlmacen;
	private VistaPedidoInventario vistaInventario;

	public VistaFabrica(ControladorDeFabrica ctrl) {
		// TODO Auto-generated method stub
		
		this._ctrl = ctrl;
		
		vistaAlmacen = new VistaPedidoAlmacen(ctrl);
		vistaInventario = new VistaPedidoInventario(ctrl);
		
		setTitle("Gestoria de Fabrica");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 750);
		contentPane = new JPanel();
		contentPane.setForeground(Color.WHITE);
		contentPane.setBackground(Color.ORANGE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("FARMACOS");
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				_ctrl.solicitaPedidos();
				new VistaPedidoProyecto(_ctrl);
				
				/*
				JSONObject jo = new JSONObject();
				
				String type = "nuevo pedido";
				String id = "Le123";
				String usuario = "pedro";
				String producto = "pepsi";
				int cantidad = 10;
				EstadoPedido estado = EstadoPedido.ACCEPTADO;
				jo.put("type", type);
				
				JSONArray ja = new JSONArray();
				
				JSONObject j1 = new JSONObject();
				
				j1.put("id", id);
				j1.put("usuario", usuario);
				j1.put("producto", producto);
				j1.put("cantidad", cantidad);
				j1.put("estado", estado.toString());
				
				ja.put(j1);
				
				jo.put("data", ja);
				
				try {
				String _outFile = "ejemplo.json";
				OutputStream out = _outFile == null ? System.out : new FileOutputStream(new File(_outFile));
				PrintStream print = new PrintStream(out);
				print.println(jo);
				}
				catch (Exception ex) {
					
				}*/
			}
		});
		btnNewButton.setBounds(86, 250, 164, 44);
		contentPane.add(btnNewButton);
		
		JButton btnPedidos = new JButton("PEDIDOS LABORATORIO");
		btnPedidos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//new VistaPedidosLaboratorio();
				new VistaPedidoLaboratorio(_ctrl);
			}
		});
		btnPedidos.setBackground(Color.WHITE);
		btnPedidos.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btnPedidos.setBounds(695, 250, 219, 44);
		contentPane.add(btnPedidos);
		
		JButton btnNewButton_1 = new JButton("INVENTARIO");
		btnNewButton_1.addActionListener( 
				new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						//new VistaPedidoInventario(_ctrl);
						vistaInventario.setVisible(true);
					}
				});
		btnNewButton_1.setBackground(Color.WHITE);
		btnNewButton_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btnNewButton_1.setBounds(86, 376, 164, 44);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("FABRICA");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 50));
		lblNewLabel.setBounds(397, 38, 246, 90);
		contentPane.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 644, 953, 44);
		contentPane.add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JLabel lblPaginaPrincipal = new JLabel("Pagina Principal");
		lblPaginaPrincipal.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		panel_1.add(lblPaginaPrincipal, BorderLayout.WEST);
		
		JLabel lblMadridDe = new JLabel("Madrid, 26 de abril del 2020");
		lblMadridDe.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		panel_1.add(lblMadridDe, BorderLayout.EAST);
		
		JButton btnPedidosAlmacen = new JButton("PEDIDOS ALMACEN");
		btnPedidosAlmacen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//new VistaPedidoAlmacen(_ctrl);
				vistaAlmacen.setVisible(true);
			}
		});
		btnPedidosAlmacen.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btnPedidosAlmacen.setBackground(Color.WHITE);
		btnPedidosAlmacen.setForeground(Color.BLACK);
		btnPedidosAlmacen.setBounds(695, 442, 219, 44);
		contentPane.add(btnPedidosAlmacen);
		
		JToolBar toolBar = new JToolBar();
		toolBar.setBounds(10, 139, 953, 44);
		contentPane.add(toolBar);
		
		JButton btnNewButton_2 = new JButton("New button");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_2.setBounds(86, 530, 164, 44);
		contentPane.add(btnNewButton_2);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(468, 250, 7, 20);
		contentPane.add(textPane);
		
		JFormattedTextField formattedTextField = new JFormattedTextField();
		formattedTextField.setBounds(357, 301, 101, 44);
		contentPane.add(formattedTextField);
		
		JEditorPane editorPane = new JEditorPane();
		editorPane.setBounds(256, 201, 107, 20);
		contentPane.add(editorPane);

		this.setVisible(true);
	}
}


