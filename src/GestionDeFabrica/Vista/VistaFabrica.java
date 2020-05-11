package GestionDeFabrica.Vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import GestionDeFabrica.Controlador.ControladorDeFabrica;
import GestionDeFabrica.Modelo.Fabrica;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.border.CompoundBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.LineBorder;

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
	

	public VistaFabrica() {
		// TODO Auto-generated method stub
		
		setTitle("Gestoria de Fabrica");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 929, 600);
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
				
				new VistaFarmacos(_ctrl);
			}
		});
		btnNewButton.setBounds(204, 207, 164, 44);
		contentPane.add(btnNewButton);
		
		JButton btnPedidos = new JButton("PEDIDOS LABORATORIO");
		btnPedidos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new VistaPedidosLaboratorio();
			}
		});
		btnPedidos.setBackground(Color.WHITE);
		btnPedidos.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btnPedidos.setBounds(533, 207, 219, 44);
		contentPane.add(btnPedidos);
		
		JButton btnNewButton_1 = new JButton("INVENTARIO");
		btnNewButton_1.addActionListener( 
				new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						new VistaInventario(_ctrl);
					}
				});
		btnNewButton_1.setBackground(Color.WHITE);
		btnNewButton_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btnNewButton_1.setBounds(204, 318, 164, 44);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("FABRICA");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 50));
		lblNewLabel.setBounds(331, 29, 246, 90);
		contentPane.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 130, 893, 44);
		contentPane.add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 492, 893, 44);
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
				
				new VistaPedidosAlmacen();
			}
		});
		btnPedidosAlmacen.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btnPedidosAlmacen.setBackground(Color.WHITE);
		btnPedidosAlmacen.setForeground(Color.BLACK);
		btnPedidosAlmacen.setBounds(533, 318, 219, 44);
		contentPane.add(btnPedidosAlmacen);

		this.setVisible(true);
	}

	/*public VistaFabrica(ControladorDeFabrica ctrl) {
		// TODO Auto-generated constructor stub
		
		setTitle("Gestoria de Fabrica");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 929, 600);
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
			}
		});
		btnNewButton.setBounds(140, 212, 139, 39);
		contentPane.add(btnNewButton);
		
		JButton btnPedidos = new JButton("PEDIDOS LABORATORIO");
		btnPedidos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnPedidos.setBackground(Color.WHITE);
		btnPedidos.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btnPedidos.setBounds(565, 207, 197, 44);
		contentPane.add(btnPedidos);
		
		JButton btnNewButton_1 = new JButton("INVENTARIO");
		btnNewButton_1.setBackground(Color.WHITE);
		btnNewButton_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btnNewButton_1.setBounds(140, 306, 139, 44);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("FABRICA");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 50));
		lblNewLabel.setBounds(331, 29, 246, 90);
		contentPane.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 130, 893, 44);
		contentPane.add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 492, 893, 44);
		contentPane.add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JLabel lblPaginaPrincipal = new JLabel("Pagina Principal");
		lblPaginaPrincipal.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		panel_1.add(lblPaginaPrincipal, BorderLayout.WEST);
		
		JLabel lblMadridDe = new JLabel("Madrid, 26 de abril del 2020");
		lblMadridDe.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		panel_1.add(lblMadridDe, BorderLayout.EAST);
		
		JButton btnPedidosAlmacen = new JButton("PEDIDOS ALMACEN");
		btnPedidosAlmacen.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btnPedidosAlmacen.setBackground(Color.WHITE);
		btnPedidosAlmacen.setForeground(Color.BLACK);
		btnPedidosAlmacen.setBounds(565, 306, 197, 44);
		contentPane.add(btnPedidosAlmacen);

		this.setVisible(true);
		//initGUI();
	}

	private void initGUI() {
		// TODO Auto-generated method stub
		
		JPanel mainPanel = new JPanel( new BorderLayout() );
		mainPanel.setBackground(Color.ORANGE);
		mainPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setContentPane( mainPanel );
		
		
		mainPanel.add( new PanelDeControl(_ctrl), BorderLayout.PAGE_START);
		mainPanel.add( new BarraDeEstado(_ctrl), BorderLayout.PAGE_END);
		
		JPanel viewsPanel = new JPanel( new GridLayout(4, 1));
		//JPanel viewsPanel = new JPanel( new GridLayout(4, 1, 10, 10));
		mainPanel.add(viewsPanel, BorderLayout.CENTER);
		
		JPanel titulo = new JPanel();
		titulo.setLayout( new BoxLayout( titulo, BoxLayout.Y_AXIS));
		titulo.setBackground(Color.WHITE);
		JLabel texto = new JLabel("Fabrica");
		texto.setLocation(100, 0);
		texto.setFont(new Font("Agency FB", Font.BOLD, 50));
		titulo.add(texto);
		viewsPanel.add(titulo);
		
		JPanel farmacos = new JPanel();
		farmacos.setLayout( new BoxLayout( farmacos, BoxLayout.X_AXIS));
		farmacos.setBackground(Color.ORANGE);
		viewsPanel.add(farmacos);
		
		JPanel inventario = new JPanel();
		inventario.setLayout( new BoxLayout( inventario, BoxLayout.X_AXIS));
		viewsPanel.add(inventario);
		
		JPanel pedidos  = new JPanel();
		pedidos.setLayout( new BoxLayout( pedidos, BoxLayout.X_AXIS));
		pedidos.setBackground(Color.ORANGE);
		viewsPanel.add(pedidos);
		
		//Botones
		farmacos.add(Box.createRigidArea(new Dimension(0, 20)));
		this.botonFarmacos = new JButton("FARMACOS");
		farmacos.add(botonFarmacos);
		this.botonFarmacos.setToolTipText("Pricipios Quimicos");
		//this.botonFarmacos.setBounds(63, 89, 159, 39);
		this.botonFarmacos.setBackground(Color.BLACK);
		this.botonFarmacos.setForeground(Color.WHITE);
		
		this.botonFarmacos.addActionListener(
				new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						
						new VistaFarmacos(_ctrl);
					}
					
				});
		
		this.botonInventario = new JButton("INVENTARIO");
		inventario.add(botonInventario);
		this.botonInventario.setToolTipText("Productos en el inventario");
		this.botonInventario.setBackground(Color.GRAY);
		this.botonInventario.setForeground(Color.WHITE);
		
		this.botonInventario.addActionListener(  
				new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						
						new VistaInventario(_ctrl);
					}
					
				});
		
		this.botonPedidos = new JButton("PEDIDOS");
		pedidos.add(botonPedidos, BorderLayout.LINE_END);
		this.botonPedidos.setToolTipText("Todos los pedidos");
		this.botonPedidos.setBackground(Color.LIGHT_GRAY);
		this.botonPedidos.setForeground(Color.BLACK);
		//this.botonPedidos.setLocation(10000000, 1000);
		
		
		this.botonPedidos.addActionListener(
				new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						
						new VistaPedidos(_ctrl);
					}
					
				});
		
		this.setBackground(Color.ORANGE);
		this.setForeground(Color.orange);
		//this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		//this.setBounds(100, 100, 651, 416);
		//this.pack();
		this.setVisible(true);
	}*/
}


