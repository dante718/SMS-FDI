package GestionAlmacen.Presentacion;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import GestionAlmacen.Negocio.TProducto;

public class VentanaEliminarProducto extends JFrame implements InterfazVista{
	
	JFrame _ventana;
	ArrayList<TProducto> _productos;
	
	public VentanaEliminarProducto(Controlador c) {
		_productos = c.getProductos();
		_ventana = new JFrame("ELIMINARPRODUCTO");
		
		_ventana.setTitle("Eliminar Producto");
		_ventana.setLocationRelativeTo(null);
		
		JPanel panelPrincipal = new JPanel();
		panelPrincipal.setLayout(new BorderLayout(50, 50));
		
		JPanel formulario = new JPanel();
		formulario.setLayout(new BorderLayout(50, 50));
		
		JLabel id = new JLabel("ID Producto");
		JTextField tId = new JTextField(5);
		
		JPanel f = new JPanel();
		f.add(id);
		f.add(tId);
		
		formulario.add(f);
		
		panelPrincipal.add(formulario, BorderLayout.CENTER);
		
		JPanel panelBoton = new JPanel();
		panelBoton.setLayout(new BorderLayout(50, 50));
		
		JButton eliminar = new JButton("ELIMINAR");
		
		eliminar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int iden = -1;
				boolean encontrado = false;
				for(int i = 0; i < _productos.size() || !encontrado; ++i) {
					if(Integer.parseInt(tId.getText()) == _productos.get(i).getIdProducto()) {
						encontrado = true;
						iden = i;
					}
				}
				//Llamar funcion
				if(iden != -1) {
					_productos = c.eliminarProducto(iden);
					c.escribirBD(_productos);
				}
			}
		});
		
		JPanel botones = new JPanel();
		botones.add(eliminar);
		panelBoton.add(botones);
		panelPrincipal.add(panelBoton, BorderLayout.SOUTH);
		
		_ventana.getContentPane().add(panelPrincipal);
	}
	
	@Override
	public void arranca() {
		// TODO Auto-generated method stub
		_ventana.pack();
		_ventana.setLocationRelativeTo(null);
		_ventana.setVisible(true);
	}

}
