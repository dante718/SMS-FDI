package GestionAlmacen.Presentacion;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import GestionAlmacen.Negocio.TProducto;

public class VentanaAddProducto extends JFrame implements InterfazVista{
	
	JFrame ventana;
	ArrayList<TProducto> _productos;
	
	public VentanaAddProducto(Controlador c) {
		_productos = c.getProductos();
		ventana = new JFrame("ADDPRODUCT");
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
		
		JLabel desc = new JLabel("Descripcion");
		JTextField tDesc = new JTextField(5);
		
		JLabel cantidad = new JLabel("Cantidad");
		JTextField tCantidad = new JTextField(5);
		
		JPanel f = new JPanel();
		f.add(addi);
		f.add(tAdd);
		f.add(desc);
		f.add(tDesc);
		f.add(cantidad);
		f.add(tCantidad);
		
		formulario.add(f);
		panelPrincipal.add(formulario, BorderLayout.CENTER);
		
		//ventana.getContentPane().add(formulario);
		
		JPanel panelBoton = new JPanel();
		panelBoton.setLayout(new BorderLayout(50, 50));
		
		JButton add = new JButton("AÑADIR");
		
		TProducto producto = new TProducto();
		
		
		add.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				producto.setIdProducto(_productos.get(_productos.size()-1).getIdProducto()+1);
				producto.setNombreProducto(tAdd.getText());
				producto.setDescripcionProducto(tDesc.getText());
				producto.setCantidadProducto(Integer.parseInt(tCantidad.getText()));
				
				_productos = c.addProducto(producto);
				c.escribirBD(_productos);
			}
		});
		
		JPanel botones = new JPanel();
		botones.add(add);
		panelBoton.add(botones);
		panelPrincipal.add(panelBoton, BorderLayout.SOUTH);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);	
		
		ventana.getContentPane().add(panelPrincipal);
	}

	@Override
	public void arranca() {
		// TODO Auto-generated method stub
		ventana.pack();
		ventana.setLocationRelativeTo(null);
		ventana.setVisible(true);
	}

}
