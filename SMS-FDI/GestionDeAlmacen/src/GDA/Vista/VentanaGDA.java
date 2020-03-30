package GDA.Vista;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

import GDA.Controlador.Controlador;

public class VentanaGDA extends JFrame implements InterfazVista{
	
	static final String INVENTARIO = "INVENTARIO";
	static final String ADDPRODUCT = "AÑADIR PRODUCTO";
	static final String LISTAPEDIDOS = "LISTA DE PEDIDOS";
	static final String PEDIDO = "REALIZAR PEDIDO";
	static final String MENSAJE = "Bienvenido a la aplicación";
	
	// VENTANA PRINCIPAL
	private JButton _inventario;
	private JButton _addProducto;
	private JButton _listaPedidos;
	private JButton _hacerPedido;
	private JLabel _mensaje;
	
	// VENTANA INVENTARIO
	private JFrame _ventanaInventario;
	
	// VENTANA AÑADIR PRODUCTO
	private JFrame _ventanaAddProducto;
	private JTextField _nombre;
	private JTextField _cantidad;
	private JTextField _precio;
	
	// VENTANA LISTA PEDIDOS
	private JFrame _ventanaListaPedidos;
	
	public VentanaGDA(){
		super("Gestión de Almacén");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panelPrincipal = new JPanel();
		panelPrincipal.setLayout(new BorderLayout(50,50));
		
		_mensaje = new JLabel(MENSAJE);
		JPanel panelAux = new JPanel();
		panelAux.add(_mensaje);
		panelPrincipal.add(panelAux, BorderLayout.NORTH);
		
		_inventario = new JButton(INVENTARIO);
		_inventario.setActionCommand(INVENTARIO);
		
		_addProducto = new JButton(ADDPRODUCT);
		_addProducto.setActionCommand(ADDPRODUCT);
		
		_listaPedidos = new JButton(LISTAPEDIDOS);
		_listaPedidos.setActionCommand(LISTAPEDIDOS);
		
		_hacerPedido = new JButton(PEDIDO);
		_hacerPedido.setActionCommand(PEDIDO);
		
		JPanel botones = new JPanel();
		botones.add(_inventario);
		botones.add(_addProducto);
		botones.add(_listaPedidos);
		botones.add(_hacerPedido);
		panelPrincipal.add(botones, BorderLayout.SOUTH);
		getContentPane().add(panelPrincipal);
	}
	
	@Override
	public void setControlador(Controlador c) {
		// TODO Auto-generated method stub
		_inventario.addActionListener(c);
		_addProducto.addActionListener(c);
		_listaPedidos.addActionListener(c);
		_hacerPedido.addActionListener(c);
	}

	@Override
	public void arranca() {
		// TODO Auto-generated method stub
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	public void ventanaInventario(){
		JFrame ventana = new JFrame(INVENTARIO);
		ventana.setSize(500, 500);
		
		ventana.setTitle("Inventario");
		//ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setLocationRelativeTo(null);
		
		ventana.setVisible(true);
	}
	
	public void ventanaAddProducto(){
		JFrame ventana = new JFrame(ADDPRODUCT);
		ventana.setSize(500, 500);
		
		ventana.setTitle("Añadir producto");
		//ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setLocationRelativeTo(null);
		
		JPanel panelPrincipal = new JPanel();
		panelPrincipal.setLayout(new BorderLayout(50,50));
		
		JPanel formulario = new JPanel();
		formulario.setLayout(new BorderLayout(50, 50));
		
		JLabel addi = new JLabel("Nombre");
		JTextField tAdd = new JTextField(5);
		
		JLabel cantidad = new JLabel("Cantidad");
		JTextField tCantidad = new JTextField(5);
		
		JLabel precio = new JLabel("Precio");
		JTextField tPrecio = new JTextField(5);
		
		JPanel f = new JPanel();
		f.add(addi);
		f.add(tAdd);
		f.add(cantidad);
		f.add(tCantidad);
		f.add(precio);
		f.add(tPrecio);
		formulario.add(f);
		panelPrincipal.add(formulario, BorderLayout.CENTER);
		
		//ventana.getContentPane().add(formulario);
		
		JPanel panelBoton = new JPanel();
		panelBoton.setLayout(new BorderLayout(50, 50));
		
		JButton add = new JButton("AÑADIR");
		add.setActionCommand(ADDPRODUCT);
		
		JPanel botones = new JPanel();
		botones.add(add);
		panelBoton.add(botones);
		panelPrincipal.add(panelBoton, BorderLayout.SOUTH);
		
		ventana.getContentPane().add(panelPrincipal);
		
		ventana.setVisible(true);
	}
	
	public void ventanaListaPedidos(){
		JFrame ventana = new JFrame(LISTAPEDIDOS);
		ventana.setSize(500, 500);
		
		ventana.setTitle("Lista de pedidos");
		//ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setLocationRelativeTo(null);
		
		ventana.setVisible(true);
	}

}
