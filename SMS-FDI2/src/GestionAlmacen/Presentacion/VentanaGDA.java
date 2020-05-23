package GestionAlmacen.Presentacion;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

@SuppressWarnings("serial")
public class VentanaGDA extends JFrame implements InterfazVista{
	
	static final String INVENTARIO = "INVENTARIO";
	static final String ADDPRODUCT = "AÑADIR PRODUCTO";
	static final String LISTAPEDIDOS = "LISTA DE PEDIDOS";
	static final String PEDIDO = "LISTA DE PROVEEDORES";
	static final String MENSAJE = "Bienvenido a la app de gestión del almacén";
	static final String ELIMINAR = "ELIMINAR PRODUCTO";
	static final String ADDPROV = "AÑADIR PROVEEDOR";
	
	// VENTANA PRINCIPAL
	private JButton _inventario;
	private JButton _addProducto;
	private JButton _listaPedidos;
	private JButton _listaProveedores;
	private JButton _eliminarProducto;
	private JButton _addProveedor;
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
		
		Controlador c = new Controlador();
		
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
		
		_listaProveedores = new JButton(PEDIDO);
		_listaProveedores.setActionCommand(PEDIDO);
		
		_eliminarProducto = new JButton(ELIMINAR);
		_eliminarProducto.setActionCommand(ELIMINAR);
		
		_addProveedor = new JButton(ADDPROV);
		_addProveedor.setActionCommand(ADDPROV);
		
		JPanel botones = new JPanel();
		botones.add(_inventario);
		botones.add(_addProducto);
		botones.add(_eliminarProducto);
		botones.add(_listaPedidos);
		botones.add(_listaProveedores);
		botones.add(_addProveedor);
		panelPrincipal.add(botones, BorderLayout.SOUTH);
		getContentPane().add(panelPrincipal);
		
		_inventario.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//ventanaInventario();
				VentanaInventario vi = new VentanaInventario(c);
				vi.arranca();
			}
		});
		
		_addProducto.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				VentanaAddProducto vap = new VentanaAddProducto(c);
				vap.arranca();
			}
		});
		
		_eliminarProducto.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				VentanaEliminarProducto vep = new VentanaEliminarProducto(c);
				vep.arranca();
			}
		});
		
		_listaPedidos.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				VentanaListaPedidos vlp = new VentanaListaPedidos(c);
				vlp.arranca();
			}
		});
		
		_listaProveedores.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				VentanaProveedores vp = new VentanaProveedores(c);
				vp.arranca();
			}
		});
		
		_addProveedor.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				VentanaAddProveedor vapv = new VentanaAddProveedor(c);
				vapv.arranca();
			}
		});
	}

	@Override
	public void arranca() {
		// TODO Auto-generated method stub
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}	
}
